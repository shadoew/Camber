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
 *         &lt;element ref="{http://jenie.ao.dcn/jenie/niem/JenieServices/2.0}ServiceEndpoint" minOccurs="0"/>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}AddressFullText" minOccurs="0"/>
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
    "serviceEndpoint",
    "addressFullText"
})
@XmlRootElement(name = "DeliveryAddress", namespace = "http://jenie.ao.dcn/jenie/niem/JenieServices/2.0")
public class DeliveryAddress {

    @XmlElement(name = "ServiceEndpoint", namespace = "http://jenie.ao.dcn/jenie/niem/JenieServices/2.0")
    protected java.lang.String serviceEndpoint;
    @XmlElement(name = "AddressFullText")
    protected TextType addressFullText;

    /**
     * Gets the value of the serviceEndpoint property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getServiceEndpoint() {
        return serviceEndpoint;
    }

    /**
     * Sets the value of the serviceEndpoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setServiceEndpoint(java.lang.String value) {
        this.serviceEndpoint = value;
    }

    /**
     * Gets the value of the addressFullText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAddressFullText() {
        return addressFullText;
    }

    /**
     * Sets the value of the addressFullText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAddressFullText(TextType value) {
        this.addressFullText = value;
    }

}
