package com.lewissa.jhano.cliente;

import com.lewissa.jhano.utilidades.cCedula;
import com.lewissa.jhano.utilidades.cCorreo;
import com.lewissa.jhano.utilidades.cRuc;
import com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 * Clase Transacción de Clientes
 *
 * Gestiona el comportamiento de la clase cCliente, mediante los métodos creados
 *
 * @version 1.0 03/05/2014
 * @author
 */
public class cTransaccionCliente {

    /**
     * Método que permite ingresar un cliente.
     *
     * @param datDatos, contiene objeto tipo cliente a ser ingresado.
     * @return Booleano, que contine la verificacion de si ingreso o no el
     * cleinte.
     */
    public Boolean ingresarCliente(cCliente datDatos) {
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service service= new WsAccesoDatosCliente_Service();
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();

        Boolean booFlag = false;
        cCedula cedCedula = new cCedula(datDatos.getStrIdCliente());
        cRuc rucRuc = new cRuc(datDatos.getStrIdCliente());
        cCorreo corCorreo = new cCorreo(datDatos.getStrCorreo());
        List<String> strCliente = new ArrayList<String>();
        if ((cedCedula.validaCedula() || rucRuc.validaRuc()) && corCorreo.validaEmail()) {
            strCliente.add(0, datDatos.getStrIdCliente());
            strCliente.add(1, datDatos.getStrNombreFiscal());
            strCliente.add(2, datDatos.getStrNombreComercial());
            strCliente.add(3, datDatos.getStrDireccion());
            strCliente.add(4, datDatos.getStrConvencional());
            strCliente.add(5, datDatos.getStrCelular());
            strCliente.add(6, datDatos.getStrCorreo());
            strCliente.add(7, datDatos.getStrTipoCliente());
            booFlag = port.actualizarDataBaseCliente(strCliente);
        }
        if (booFlag == null) {
            booFlag = false;
        }
        return booFlag;
    }

    private static Boolean actualizarDataBaseCliente(java.util.List<java.lang.String> strCli) {
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service service = new com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente_Service();
        com.lewissa.jhano.accesodatos.cliente.WsAccesoDatosCliente port = service.getWsAccesoDatosClientePort();
        return port.actualizarDataBaseCliente(strCli);
    }

}
