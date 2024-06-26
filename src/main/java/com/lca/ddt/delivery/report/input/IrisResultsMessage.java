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
 *         &lt;element name="accessionNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportSpecimen" type="{http://www.labcorp.com/iris/messages}AccessionSpecimen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="panel" type="{http://www.labcorp.com/iris/messages}Panel" minOccurs="0"/>
 *         &lt;element name="report" type="{http://www.labcorp.com/iris/messages}Report" minOccurs="0"/>
 *         &lt;element name="concurrentCases" type="{http://www.labcorp.com/iris/messages}ConcurrentCase" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cancelledPanel" type="{http://www.labcorp.com/iris/messages}Panel" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anyResults" type="{http://www.labcorp.com/iris/messages}TestResultValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attachedPDF" type="{http://www.labcorp.com/iris/messages}AttachedPDF" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msgSequenceID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "accessionNum",
    "reportNum",
    "reportSpecimen",
    "panel",
    "report",
    "concurrentCases",
    "cancelledPanel",
    "anyResults",
    "attachedPDF",
    "msgSequenceID"
})
@XmlRootElement(name = "IRISRESULTSMESSAGE")
public class IrisResultsMessage {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EVENTTYPE event;
    @XmlElement(required = true)
    protected String accessionNum;
    @XmlElement(required = true)
    protected String reportNum;
    protected List<AccessionSpecimen> reportSpecimen;
    protected Panel panel;
    protected Report report;
    protected List<ConcurrentCase> concurrentCases;
    protected List<Panel> cancelledPanel;
    protected List<TestResultValue> anyResults;
    protected List<AttachedPDF> attachedPDF;
    protected Integer msgSequenceID;

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
     * Gets the value of the reportNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportNum() {
        return reportNum;
    }

    /**
     * Sets the value of the reportNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportNum(String value) {
        this.reportNum = value;
    }

    /**
     * Gets the value of the reportSpecimen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportSpecimen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportSpecimen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccessionSpecimen }
     * 
     * 
     */
    public List<AccessionSpecimen> getReportSpecimen() {
        if (reportSpecimen == null) {
            reportSpecimen = new ArrayList<AccessionSpecimen>();
        }
        return this.reportSpecimen;
    }

    /**
     * Gets the value of the panel property.
     * 
     * @return
     *     possible object is
     *     {@link Panel }
     *     
     */
    public Panel getPanel() {
        return panel;
    }

    /**
     * Sets the value of the panel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Panel }
     *     
     */
    public void setPanel(Panel value) {
        this.panel = value;
    }

    /**
     * Gets the value of the report property.
     * 
     * @return
     *     possible object is
     *     {@link Report }
     *     
     */
    public Report getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     * 
     * @param value
     *     allowed object is
     *     {@link Report }
     *     
     */
    public void setReport(Report value) {
        this.report = value;
    }

    /**
     * Gets the value of the concurrentCases property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the concurrentCases property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConcurrentCases().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConcurrentCase }
     * 
     * 
     */
    public List<ConcurrentCase> getConcurrentCases() {
        if (concurrentCases == null) {
            concurrentCases = new ArrayList<ConcurrentCase>();
        }
        return this.concurrentCases;
    }

    /**
     * Gets the value of the cancelledPanel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelledPanel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelledPanel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Panel }
     * 
     * 
     */
    public List<Panel> getCancelledPanel() {
        if (cancelledPanel == null) {
            cancelledPanel = new ArrayList<Panel>();
        }
        return this.cancelledPanel;
    }

    /**
     * Gets the value of the anyResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anyResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnyResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TestResultValue }
     * 
     * 
     */
    public List<TestResultValue> getAnyResults() {
        if (anyResults == null) {
            anyResults = new ArrayList<TestResultValue>();
        }
        return this.anyResults;
    }

    /**
     * Gets the value of the attachedPDF property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachedPDF property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachedPDF().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttachedPDF }
     * 
     * 
     */
    public List<AttachedPDF> getAttachedPDF() {
        if (attachedPDF == null) {
            attachedPDF = new ArrayList<AttachedPDF>();
        }
        return this.attachedPDF;
    }

    /**
     * Gets the value of the msgSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMsgSequenceID() {
        return msgSequenceID;
    }

    /**
     * Sets the value of the msgSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMsgSequenceID(Integer value) {
        this.msgSequenceID = value;
    }

	@Override
	public String toString() {
		return "IrisResultsMessage [event=" + event + ", accessionNum=" + accessionNum + ", reportNum=" + reportNum
				+ ", reportSpecimen=" + reportSpecimen + ", panel=" + panel + ", report=" + report
				+ ", concurrentCases=" + concurrentCases + ", cancelledPanel=" + cancelledPanel + ", anyResults="
				+ anyResults + ", attachedPDF=" + attachedPDF + ", msgSequenceID=" + msgSequenceID + "]";
	}
    
    

}
