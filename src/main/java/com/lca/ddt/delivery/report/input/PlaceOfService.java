//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceOfService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaceOfService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testPerformed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="componentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="performedLocation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="medicalDirector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceOfService", propOrder = {
    "testPerformed",
    "componentType",
    "performedLocation",
    "medicalDirector"
})
public class PlaceOfService {

    @XmlElement(required = true)
    protected String testPerformed;
    @XmlElement(required = true)
    protected String componentType;
    @XmlElement(required = true)
    protected String performedLocation;
    @XmlElement(required = true)
    protected String medicalDirector;

    /**
     * Gets the value of the testPerformed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestPerformed() {
        return testPerformed;
    }

    /**
     * Sets the value of the testPerformed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestPerformed(String value) {
        this.testPerformed = value;
    }

    /**
     * Gets the value of the componentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentType() {
        return componentType;
    }

    /**
     * Sets the value of the componentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentType(String value) {
        this.componentType = value;
    }

    /**
     * Gets the value of the performedLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerformedLocation() {
        return performedLocation;
    }

    /**
     * Sets the value of the performedLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerformedLocation(String value) {
        this.performedLocation = value;
    }

    /**
     * Gets the value of the medicalDirector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMedicalDirector() {
        return medicalDirector;
    }

    /**
     * Sets the value of the medicalDirector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMedicalDirector(String value) {
        this.medicalDirector = value;
    }

}
