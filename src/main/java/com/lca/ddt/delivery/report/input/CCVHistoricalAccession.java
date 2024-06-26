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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CCVHistoricalAccession complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CCVHistoricalAccession">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessionNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ccvReportId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accessionTmstp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ccvEligible" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ccvHistoricalCase" type="{http://www.labcorp.com/iris/messages}CCVHistoricalCase" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CCVHistoricalAccession", propOrder = {
    "accessionNum",
    "ccvReportId",
    "accessionTmstp",
    "ccvEligible",
    "ccvHistoricalCase"
})
public class CCVHistoricalAccession {

    @XmlElement(required = true)
    protected String accessionNum;
    protected String ccvReportId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accessionTmstp;
    protected Boolean ccvEligible;
    protected List<CCVHistoricalCase> ccvHistoricalCase;

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
     * Gets the value of the ccvReportId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcvReportId() {
        return ccvReportId;
    }

    /**
     * Sets the value of the ccvReportId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcvReportId(String value) {
        this.ccvReportId = value;
    }

    /**
     * Gets the value of the accessionTmstp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccessionTmstp() {
        return accessionTmstp;
    }

    /**
     * Sets the value of the accessionTmstp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccessionTmstp(XMLGregorianCalendar value) {
        this.accessionTmstp = value;
    }

    /**
     * Gets the value of the ccvEligible property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCcvEligible() {
        return ccvEligible;
    }

    /**
     * Sets the value of the ccvEligible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCcvEligible(Boolean value) {
        this.ccvEligible = value;
    }

    /**
     * Gets the value of the ccvHistoricalCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ccvHistoricalCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCcvHistoricalCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CCVHistoricalCase }
     * 
     * 
     */
    public List<CCVHistoricalCase> getCcvHistoricalCase() {
        if (ccvHistoricalCase == null) {
            ccvHistoricalCase = new ArrayList<CCVHistoricalCase>();
        }
        return this.ccvHistoricalCase;
    }

}
