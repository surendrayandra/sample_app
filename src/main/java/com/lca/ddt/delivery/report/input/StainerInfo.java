//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StainerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StainerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stainerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stainerLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stainerIPAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stainerPortNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StainerInfo", propOrder = {
    "stainerName",
    "stainerLocation",
    "stainerIPAddress",
    "stainerPortNumber"
})
public class StainerInfo {

    protected String stainerName;
    protected String stainerLocation;
    protected String stainerIPAddress;
    protected String stainerPortNumber;

    /**
     * Gets the value of the stainerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStainerName() {
        return stainerName;
    }

    /**
     * Sets the value of the stainerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStainerName(String value) {
        this.stainerName = value;
    }

    /**
     * Gets the value of the stainerLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStainerLocation() {
        return stainerLocation;
    }

    /**
     * Sets the value of the stainerLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStainerLocation(String value) {
        this.stainerLocation = value;
    }

    /**
     * Gets the value of the stainerIPAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStainerIPAddress() {
        return stainerIPAddress;
    }

    /**
     * Sets the value of the stainerIPAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStainerIPAddress(String value) {
        this.stainerIPAddress = value;
    }

    /**
     * Gets the value of the stainerPortNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStainerPortNumber() {
        return stainerPortNumber;
    }

    /**
     * Sets the value of the stainerPortNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStainerPortNumber(String value) {
        this.stainerPortNumber = value;
    }

}