//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.05 at 07:44:41 PM EDT 
//


package com.hem.test.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}FullTelephoneNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fullTelephoneNumber"
})
@XmlRootElement(name = "PreferredTelephoneNumber", namespace = "http://jenie.ao.dcn/jenie/niem/JenieServices/2.0")
public class PreferredTelephoneNumber {

    @XmlElement(name = "FullTelephoneNumber")
    protected FullTelephoneNumberType fullTelephoneNumber;

    /**
     * Gets the value of the fullTelephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link FullTelephoneNumberType }
     *     
     */
    public FullTelephoneNumberType getFullTelephoneNumber() {
        return fullTelephoneNumber;
    }

    /**
     * Sets the value of the fullTelephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullTelephoneNumberType }
     *     
     */
    public void setFullTelephoneNumber(FullTelephoneNumberType value) {
        this.fullTelephoneNumber = value;
    }

}