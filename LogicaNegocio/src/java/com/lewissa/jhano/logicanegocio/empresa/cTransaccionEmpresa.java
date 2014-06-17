/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.logicanegocio.empresa;

import com.sun.rowset.WebRowSetImpl;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fredy Janeta
 */
public class cTransaccionEmpresa {
    public List<cEmpresa> buscarEmpresa(String strParametro)
    {
        List<cEmpresa> lisEmpresas = new ArrayList<cEmpresa>();
        try {
            
            cEmpresa oEmpresa;
            StringReader strReader = new StringReader(buscarEmpresa_1(strParametro));
            WebRowSetImpl wrsImplement = new WebRowSetImpl();
            wrsImplement.readXml(strReader);
            while (wrsImplement.next()) 
            {                
                oEmpresa= new cEmpresa();
                oEmpresa.setStrRuc(wrsImplement.getString("RUC"));
                oEmpresa.setStrNombreFiscal(wrsImplement.getString("Nombre_fiscal"));
                oEmpresa.setStrDirecccion(wrsImplement.getString("Direccion"));
                oEmpresa.setStrTelefono("Telefono");
                lisEmpresas.add(oEmpresa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(cTransaccionEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisEmpresas;
    }

    private static String buscarEmpresa_1(java.lang.String strIdEmpresa) {
        com.lewissa.jhano.accesodatos.empresa.WsAccesoDatosEmpresa_Service service = new com.lewissa.jhano.accesodatos.empresa.WsAccesoDatosEmpresa_Service();
        com.lewissa.jhano.accesodatos.empresa.WsAccesoDatosEmpresa port = service.getWsAccesoDatosEmpresaPort();
        return port.buscarEmpresa(strIdEmpresa);
    }
    
}
