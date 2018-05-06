package com.hem.test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.hem.test.generated.JenieServices;
import com.hem.test.generated.JenieUser;

public class Parser {
	private static final String DB_URI = "jdbc:postgresql://localhost:5432/postgres";
	private static Properties CREDS = new Properties();

	public static void main(String[] args) {
		CREDS.put("user", "postgres");
		CREDS.put("password", "postgres");
		if (new XMLValidator().validate(XMLValidator.XML_FILE, XMLValidator.SCHEMA_FILE))
			new Parser().parse(XMLValidator.XML_FILE, XMLValidator.SCHEMA_FILE);
		else 
			System.out.println("Schema validation failed! \nPlease check the stack trace");
	}

	private void parse(String xml, String xsd) {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			ClassLoader classLoader = getClass().getClassLoader();

			Schema schema = sf.newSchema(new File(classLoader.getResource(xsd).getFile()));

			JAXBContext jc = JAXBContext.newInstance(JenieServices.class);

			Unmarshaller unmarshaller = jc.createUnmarshaller();
			unmarshaller.setSchema(schema);

			JenieServices svcs = (JenieServices) unmarshaller
					.unmarshal(new File(classLoader.getResource(xml).getFile()));

			storeToDatabase(svcs.getJenieUser());

		} catch (JAXBException | SAXException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void storeToDatabase(JenieUser user) throws SQLException {

		if (user == null || user.getPersonName() == null) {
			System.out.println("No Data received");
			return;
		}

		// Data structure for values to be inserted
		List<String> list = new ArrayList<>();
		list.add(getFirst(user.getPersonName().getPersonNamePrefixText()));
		list.add(getFirst(user.getPersonName().getPersonGivenName()));
		list.add(getFirst(user.getPersonName().getPersonPreferredName()));
		list.add(getFirst(user.getPersonName().getPersonSurName()));
		list.add(getFirst(user.getPersonName().getPersonNameSuffixText()));
		list.add(user.getContactEmailID() == null ? "" : user.getContactEmailID().getValue().trim());
		list.add(user.getCourtLoginID());
		list.add(user.getJUID());
		list.add(user.getJobTitle());
		list.add(user.getPreferredTitle());
		if (user.getContactTelephoneNumber() != null) {
			list.add(getFirst(user.getContactTelephoneNumber().getTelephoneNumberFullID()) + "x"
					+ getFirst(user.getContactTelephoneNumber().getTelephoneSuffixID()));
		} else
			list.add("");

		try (Connection conn = DriverManager.getConnection(DB_URI, CREDS);) {
			try (Statement stmt = conn.createStatement();) {

				// convert to sql format values with quotes
				String values = list.stream().collect(Collectors.joining("\', \'", "\'", "\'"));

				if (stmt.executeUpdate("Insert into interview (prefix, givenName, preferredName, surName, "
						+ "suffix, email, courtLoginId, juid, jobTitle, preferredTitle,  telephoneNumber) values" + "("
						+ values + ")") > 0) {

					System.out.println("One record inserted");
				}
			}

		}

	}

	private String getFirst(List<? extends com.hem.test.generated.String> list) {
		if (list != null && !list.isEmpty()) {
			return list.get(0).getValue();
		}
		return "";
	}

}
