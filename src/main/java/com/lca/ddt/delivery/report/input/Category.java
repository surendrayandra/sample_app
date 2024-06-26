//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.30 at 03:09:20 PM IST 
//


package com.lca.ddt.delivery.report.input;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Category.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Category">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BREASTPROGNOSTIC"/>
 *     &lt;enumeration value="CCV"/>
 *     &lt;enumeration value="FLOW"/>
 *     &lt;enumeration value="LLPANEL"/>
 *     &lt;enumeration value="ZAP70PANEL"/>
 *     &lt;enumeration value="PNHPANEL"/>
 *     &lt;enumeration value="MOLECULAR"/>
 *     &lt;enumeration value="CYTOGENETICS"/>
 *     &lt;enumeration value="FISH"/>
 *     &lt;enumeration value="BONEMARROW"/>
 *     &lt;enumeration value="REFERAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Category")
@XmlEnum
public enum Category {

    BREASTPROGNOSTIC("BREASTPROGNOSTIC"),
    CCV("CCV"),
    FLOW("FLOW"),
    LLPANEL("LLPANEL"),
    @XmlEnumValue("ZAP70PANEL")
    ZAP_70_PANEL("ZAP70PANEL"),
    PNHPANEL("PNHPANEL"),
    MOLECULAR("MOLECULAR"),
    CYTOGENETICS("CYTOGENETICS"),
    FISH("FISH"),
    BONEMARROW("BONEMARROW"),
    REFERAL("REFERAL");
    private final String value;

    Category(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Category fromValue(String v) {
        for (Category c: Category.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
