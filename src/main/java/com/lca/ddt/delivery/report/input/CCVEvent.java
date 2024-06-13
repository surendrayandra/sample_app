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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CCVEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CCVEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="eventName" type="{http://www.labcorp.com/iris/messages}EVENTTYPE"/>
 *         &lt;element name="accessionNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reasonType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reasonCmnts" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loginId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateTimeStmp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="previousStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CCVEvent", propOrder = {
    "eventName",
    "accessionNum",
    "reasonType",
    "reasonCmnts",
    "loginId",
    "dateTimeStmp",
    "previousStatus"
})
public class CCVEvent {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EVENTTYPE eventName;
    @XmlElement(required = true)
    protected String accessionNum;
    @XmlElement(required = true)
    protected String reasonType;
    @XmlElement(required = true)
    protected String reasonCmnts;
    @XmlElement(required = true)
    protected String loginId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeStmp;
    @XmlElement(required = true)
    protected String previousStatus;

    /**
     * Gets the value of the eventName property.
     * 
     * @return
     *     possible object is
     *     {@link EVENTTYPE }
     *     
     */
    public EVENTTYPE getEventName() {
        return eventName;
    }

    /**
     * Sets the value of the eventName property.
     * 
     * @param value
     *     allowed object is
     *     {@link EVENTTYPE }
     *     
     */
    public void setEventName(EVENTTYPE value) {
        this.eventName = value;
    }

    /**
     * Gets the value of the accessionNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessionNum() {
        return accessionNum;
    }

    /**
     * Sets the value of the accessionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessionNum(String value) {
        this.accessionNum = value;
    }

    /**
     * Gets the value of the reasonType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonType() {
        return reasonType;
    }

    /**
     * Sets the value of the reasonType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonType(String value) {
        this.reasonType = value;
    }

    /**
     * Gets the value of the reasonCmnts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCmnts() {
        return reasonCmnts;
    }

    /**
     * Sets the value of the reasonCmnts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCmnts(String value) {
        this.reasonCmnts = value;
    }

    /**
     * Gets the value of the loginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * Sets the value of the loginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginId(String value) {
        this.loginId = value;
    }

    /**
     * Gets the value of the dateTimeStmp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTimeStmp() {
        return dateTimeStmp;
    }

    /**
     * Sets the value of the dateTimeStmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTimeStmp(XMLGregorianCalendar value) {
        this.dateTimeStmp = value;
    }

    /**
     * Gets the value of the previousStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviousStatus() {
        return previousStatus;
    }

    /**
     * Sets the value of the previousStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviousStatus(String value) {
        this.previousStatus = value;
    }

}
