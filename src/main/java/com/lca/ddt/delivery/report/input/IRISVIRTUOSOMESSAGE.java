//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="event" type="{http://www.labcorp.com/iris/messages}EVENTTYPE"/>
 *         &lt;element name="accessions" type="{http://www.labcorp.com/iris/messages}Accession" maxOccurs="unbounded"/>
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
    "event",
    "accessions"
})
@XmlRootElement(name = "IRISVIRTUOSOMESSAGE")
public class IRISVIRTUOSOMESSAGE {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EVENTTYPE event;
    @XmlElement(required = true)
    protected List<Accession> accessions;

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link EVENTTYPE }
     *     
     */
    public EVENTTYPE getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link EVENTTYPE }
     *     
     */
    public void setEvent(EVENTTYPE value) {
        this.event = value;
    }

    /**
     * Gets the value of the accessions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accessions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccessions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accession }
     * 
     * 
     */
    public List<Accession> getAccessions() {
        if (accessions == null) {
            accessions = new ArrayList<Accession>();
        }
        return this.accessions;
    }

}
