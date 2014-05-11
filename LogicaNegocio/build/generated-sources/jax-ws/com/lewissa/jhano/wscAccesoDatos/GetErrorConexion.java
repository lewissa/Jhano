
package com.lewissa.jhano.wscAccesoDatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getErrorConexion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getErrorConexion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="excExc" type="{http://ws.accesodatos.jhano.lewissa.com/}exception" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getErrorConexion", propOrder = {
    "excExc"
})
public class GetErrorConexion {

    protected Exception excExc;

    /**
     * Obtiene el valor de la propiedad excExc.
     * 
     * @return
     *     possible object is
     *     {@link Exception }
     *     
     */
    public Exception getExcExc() {
        return excExc;
    }

    /**
     * Define el valor de la propiedad excExc.
     * 
     * @param value
     *     allowed object is
     *     {@link Exception }
     *     
     */
    public void setExcExc(Exception value) {
        this.excExc = value;
    }

}
