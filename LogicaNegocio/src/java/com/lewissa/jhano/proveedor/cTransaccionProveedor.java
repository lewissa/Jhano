package com.lewissa.jhano.proveedor;

import com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service;
import com.lewissa.jhano.utilidades.cCedula;
import com.lewissa.jhano.utilidades.cCorreo;
import com.lewissa.jhano.utilidades.cRuc;
//import com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 * Clase Transacción de Proveedor Gestiona el comportamiento de la clase
 * cCliente, mediante los métodos creados
 *
 * @author Miguel Mejía, Juan Moyano
 * @version 1.0 06/05/2014
 */
public class cTransaccionProveedor {

    //@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/AccesoDatos/wsAccesoDatos.wsdl")
    //private WsAccesoDatos_Service service;

    /**
     * Ingresar Proveedor Método que construye y envia la sentecia SQL para el
     * ingreso de proveedores
     *
     * @param datDatos, Objeto que represnta a la tabla Proveedor
     * @return flag.actualizarDataBase, Boolean que retorna la confimacion de la
     * realizacion del metodo
     */
    /*public Boolean ingresarProveedor(cProveedor datDatos) {
     //cAccesoDatos accEjecutaQry=new cAccesoDatos();
     com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service service = new WsAccesoDatos_Service();
     com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos flag = service.getWsAccesoDatosPort();
     String strSqlIngreso;
     strSqlIngreso = "INSERT INTO proveedor VALUES ('"+datDatos.getId()+"', '"+datDatos.getNombreFiscal()+"'"
     + ", '"+datDatos.getNombreComercial()+"', '"+datDatos.getDireccion()+"', '"+datDatos.getConvencional()+"'"
     + ", '"+datDatos.getCelular()+"', '"+datDatos.getCorreo()+"')";
     return flag.actualizarDataBase(strSqlIngreso);
     }  */
    /**
     * Método que permite ingresar un proveedor
     *
     * @param datDatos, objeto de tipo Proveedor
     * @return booflag, booleano que contiene el valor de verdad, si ingreso el
     * proveedor
     */
    public Boolean ingresarProveedor(cProveedor datDatos) {
        
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor flag = service.getWsAccesoDatosProveedorPort();
        String strSqlIngreso;
        Boolean booFlag = false;
        cCedula cedCedula = new cCedula(datDatos.getId());
        cRuc rucRuc = new cRuc(datDatos.getId());
        cCorreo corCorreo = new cCorreo(datDatos.getCorreo());
        List<String> strProveedor = new ArrayList<String>();
        if ((cedCedula.validaCedula() || rucRuc.validaRuc()) && corCorreo.validaEmail()) {
            strProveedor.add(0, datDatos.getId());
            strProveedor.add(1, datDatos.getNombreFiscal());
            strProveedor.add(2, datDatos.getNombreComercial());
            strProveedor.add(3, datDatos.getDireccion());
            strProveedor.add(4, datDatos.getConvencional());
            strProveedor.add(5, datDatos.getCelular());
            strProveedor.add(6, datDatos.getCorreo());
            booFlag = flag.insertarProveedor(strProveedor);//actualizarDataBaseProveedor(strProveedor);
        }
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    private static Boolean insertarProveedor(java.util.List<java.lang.String> strProveedor) {
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        return port.insertarProveedor(strProveedor);
    }

}

