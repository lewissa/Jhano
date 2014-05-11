
package com.lewissa.jhano.wscAccesoDatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para exception complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="exception">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="className" type="{http://ws.accesodatos.jhano.lewissa.com/}customName" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exception", propOrder = {
    "className"
})
public class Exception {

    protected CustomName className;

    /**
     * Obtiene el valor de la propiedad className.
     * 
     * @return
     *     possible object is
     *     {@link CustomName }
     *     
     */
    public CustomName getClassName() {
        return className;
    }

    /**
     * Define el valor de la propiedad className.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomName }
     *     
     */
    public void setClassName(CustomName value) {
        this.className = value;
    }

}
