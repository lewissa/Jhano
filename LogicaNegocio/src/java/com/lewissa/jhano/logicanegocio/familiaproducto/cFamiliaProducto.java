/*
 *Esta clase repressenta a la tabla familia 
 *
 */
package com.lewissa.jhano.logicanegocio.familiaproducto;

import java.io.Serializable;

/**
 * @author Fredy Janeta
 * @version 2.0 09-05-2014
 */
public class cFamiliaProducto implements Serializable {

    private String strId;
    private String strDescripcion;

    /**
     * metodo que permite obntener el Id de la familia
     *
     * @return strId, contiene el identfificador del objeto
     */
    public String getStrId() {
        return strId;
    }

    /**
     * metodo que permite asignar el Id al objeto
     *
     * @param strId , String que contiene el Id del objeto
     */
    public void setStrId(String strId) {
        this.strId = strId;
    }

    /**
     * metodo que permite obtener la descripcion del objeto
     *
     * @return strDescripcion,String quje contiene la descripcoion del objeto
     */
    public String getStrDescripcion() {
        return strDescripcion;
    }

    /**
     * metodo que permite asignar la descripcion al objeto
     *
     * @param strDescripcion , String que contiene la descripcion del objeto
     */
    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

}
