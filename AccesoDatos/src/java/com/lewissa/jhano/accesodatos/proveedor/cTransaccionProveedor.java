/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lewissa.jhano.accesodatos.proveedor;

import com.lewissa.jhano.accesodatos.cAccesoDatos;

/**
 *
 * @author Usuario
 */
public class cTransaccionProveedor {
   public Boolean ingresarProveedor(String strProveedor[]) 
   {
       Boolean booResultado=false;
       String strQuery;
       strQuery="INSERT INTO proveedor VALUES ('"+strProveedor[0]+"','"+strProveedor[1]+"',"
               + "'"+strProveedor[2]+"','"+strProveedor[3]+"','"+strProveedor[4]+"',"
               + "'"+strProveedor[5]+"','"+strProveedor[6]+"')";
       booResultado=cAccesoDatos.getInstanciaAccesoDatos().actualizarDataBase(strQuery);
       if(booResultado == null)
       {
           booResultado = false;
       }
       return booResultado;
   }
    
    
}
