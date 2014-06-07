package com.lewissa.jhano.logicanegocio.proveedor;

import com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service;
import com.lewissa.jhano.logicanegocio.utilidades.cCedula;
import com.lewissa.jhano.logicanegocio.utilidades.cCorreo;
import com.lewissa.jhano.logicanegocio.utilidades.cRuc;
import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
//import com.lewissa.jhano.wscAccesoDatos.WsAccesoDatos_Service;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
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
    /**
     * metodo que permite capturar los datos de proveedor en un List<String>
     * y prmite enviarlos al metodo para ser modificados
     * @param oProveedor, objeto priveedor que contirne los datso del proveedor
     * @return un List<String> que contine los datos a ser modificados
     */
    public Boolean modificarProveedor(cProveedor oProveedor)
    {
        Boolean booResultado=false;
            List<String> strProveedor = new ArrayList<>();
            strProveedor.add(0, oProveedor.getId());
            strProveedor.add(1, oProveedor.getNombreFiscal());
            strProveedor.add(2, oProveedor.getNombreComercial());
            strProveedor.add(3, oProveedor.getDireccion());
            strProveedor.add(4, oProveedor.getConvencional());
            strProveedor.add(5, oProveedor.getCelular());
            strProveedor.add(6, oProveedor.getCorreo());
            booResultado=modificarProveedor(strProveedor);  
                     
        return booResultado;
    }

    /**
     * Metodo que permite cargar los proveedores
     * @return lisProveedor, contiene los proveedores en una lista
     * @author Fredy Janeta
     */
    public List<cProveedor> cargarProveedor() {
        List<cProveedor> lisProveedor = new ArrayList<cProveedor>();
        try {
            StringReader sr = new StringReader(cargaProveedor());
            WebRowSetImpl wrs = new WebRowSetImpl();
            wrs.readXml(sr);
            while (wrs.next()) {
                cProveedor proveedor = new cProveedor();
                proveedor.setId(wrs.getString("Id_prove"));
                proveedor.setNombreFiscal(wrs.getString("Nombre_fiscal"));
                proveedor.setNombreComercial(wrs.getString("Nombre_comercial"));
                proveedor.setDireccion(wrs.getString("Direccion"));
                proveedor.setConvencional(wrs.getString("Convencional"));
                proveedor.setCelular(wrs.getString("Celular"));
                proveedor.setCorreo(wrs.getString("Correo"));
                lisProveedor.add(proveedor);
            }
        } catch (Exception ex) {
        }

        return lisProveedor;
    }
/**
 * Metod que pemite elimar un proveedor
 * @author Fredy Janeta
 * @param oProveedor, cProveedor cintien los datos de un proveedor
 * @return Boolean, contiene la confirmacio de la realizacion del metodo
 */
    public Boolean eliminarProveedor(cProveedor oProveedor, Integer intTipoEliminacion) {
        Boolean booResulado = false;
        String strCodigoProveedor;
        if(oProveedor != null)
        {
            strCodigoProveedor=oProveedor.getId();
            if(intTipoEliminacion == 1) //Realiza eliminacion FISICA
            {
              booResulado=eliminarFisicoProveedor(strCodigoProveedor);
            }
            else
            {
              if(intTipoEliminacion == 0) //Realiza eliminacion LOGICA 
              {
                  booResulado=eliminarLogicoProveedor(strCodigoProveedor);
              }
            }
        }
        return booResulado;
    }
    
    
    


    /**
     * permite consumir el servico de la capa de Acceso a datos para cargar a
     * los prvoeedorees
     *
     * @return String
     */
    private static String cargaProveedor() {
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        return port.cargaProveedor();
    }

    private static Boolean eliminarFisicoProveedor(java.lang.String strCodigoProveedor) {
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        return port.eliminarFisicoProveedor(strCodigoProveedor);
    }

    private static Boolean eliminarLogicoProveedor(java.lang.String strCodigoProveedor) {
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        return port.eliminarLogicoProveedor(strCodigoProveedor);
    }

    private static Boolean modificarProveedor(java.util.List<java.lang.String> strProveedor) {
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service service = new com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor_Service();
        com.lewissa.jhano.accesodatos.proveedor.WsAccesoDatosProveedor port = service.getWsAccesoDatosProveedorPort();
        return port.modificarProveedor(strProveedor);
    }



    
    
}
