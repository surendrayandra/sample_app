//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.29 at 06:09:43 PM IST 
//


package com.lca.ddt.delivery.report.inspire.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fixativeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fixativeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fixativeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeToFixation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fixativeDuration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fixativeDisclaimer" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fixativeType", propOrder = {
    "fixativeType",
    "timeToFixation",
    "fixativeDuration",
    "fixativeDisclaimer"
})
public class FixativeType {

    protected String fixativeType; //NOSONAR
    protected String timeToFixation;
    protected String fixativeDuration;
    protected Object fixativeDisclaimer;

    /**
     * Gets the value of the fixativeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixativeType() {
        return fixativeType;
    }

    /**
     * Sets the value of the fixativeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixativeType(String value) {
        this.fixativeType = value;
    }

    /**
     * Gets the value of the timeToFixation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeToFixation() {
        return timeToFixation;
    }

    /**
     * Sets the value of the timeToFixation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeToFixation(String value) {
        this.timeToFixation = value;
    }

    /**
     * Gets the value of the fixativeDuration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixativeDuration() {
        return fixativeDuration;
    }

    /**
     * Sets the value of the fixativeDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixativeDuration(String value) {
        this.fixativeDuration = value;
    }

    /**
     * Gets the value of the fixativeDisclaimer property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFixativeDisclaimer() {
        return fixativeDisclaimer;
    }

    /**
     * Sets the value of the fixativeDisclaimer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFixativeDisclaimer(Object value) {
        this.fixativeDisclaimer = value;
    }

}