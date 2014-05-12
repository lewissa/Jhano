
package com.lewissa.jhano.wscAccesoDatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizarDataBase complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizarDataBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="strSql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarDataBase", propOrder = {
    "strSql"
})
public class ActualizarDataBase {

    protected String strSql;

    /**
     * Obtiene el valor de la propiedad strSql.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrSql() {
        return strSql;
    }

    /**
     * Define el valor de la propiedad strSql.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrSql(String value) {
        this.strSql = value;
    }

}
