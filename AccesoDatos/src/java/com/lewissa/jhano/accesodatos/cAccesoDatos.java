/**
 * Acceso a Datos Esta clase permite gestionar la base de datos, Permitiendo
 * reaizar la aplicacion del CRUD NOTA: Manejo de exepciones sencibles a
 * proximos cambios
 */
package com.lewissa.jhano.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.lewissa.jhano.accesodatos.utilidades.cConstantes;
import com.sun.rowset.WebRowSetImpl;
import java.io.Serializable;
import java.io.StringWriter;
import javax.jws.WebService;

/**
 *
 */
/**
 * Acceso a Datos
 *
 * @author Fredy Janeta
 * @version 1.1 02-05-2014
 */
public class cAccesoDatos implements Serializable {

    private Connection conConexion = null;
    private Exception excErrorAcessoDatos = null;
    static cAccesoDatos accesoDatosInstancia;

    /**
     * Metodo que permite realizar la conexion a la DB y me retorna confirmacion
     *
     * @return booResultado, Booleano que retorna la confirmacion de la
     * ejecucion del metodo
     */
    public Boolean conectarDataBase() {
        Boolean booResultado = false;
        try {
            excErrorAcessoDatos = null;
            Class.forName(cConstantes.DRIVER);
            Properties proCredenciales = new Properties();
            proCredenciales.setProperty("user", cConstantes.USER);
            proCredenciales.setProperty("password", cConstantes.PASSWORD);
            conConexion = DriverManager.getConnection(cConstantes.URL, proCredenciales);
            conConexion.setAutoCommit(true);
            booResultado = true;
        } catch (Exception exeE) {
            excErrorAcessoDatos = exeE;
        } finally {
            return booResultado;
        }

    }

    /**
     * Metodo que permite realizar la desconexion de la DB y retorna la
     * confirmacion
     *
     * @return booResultado, Booleano que contiene la confirmaicond de la
     * ejecicion del metodo
     */
    public Boolean desconectarDataBase() {
        Boolean booResultado = false;
        try {
            if (this.conConexion != null) {
                conConexion.close();
                booResultado = true;
            }
        } finally {
            return booResultado;
        }
    }

    /**
     * Metodo que permite realizar consultas y obtener el resultado de dicha
     * consulta.
     *
     * @param strParametroQuery, String que contiene la sentencia SQL a
     * ejecuatrse
     * @return strResultadoConsulta, String que contiene el resultado de la
     * consulta en formato XML
     */
    public String consultarDataBase(String strParametroQuery) {
        String strResultadoConsulta = null;
        ResultSet resResultadoConsulta = null;
        Statement stmCreaQuery = null;
        try {
            if (this.conConexion != null) {
                excErrorAcessoDatos = null;
                stmCreaQuery = this.conConexion.createStatement();
                resResultadoConsulta = stmCreaQuery.executeQuery(strParametroQuery);
                WebRowSetImpl wrs = new WebRowSetImpl();
                wrs.populate(resResultadoConsulta);
                StringWriter sw = new StringWriter();
                wrs.writeXml(sw);
                strResultadoConsulta = sw.toString();
                stmCreaQuery.execute("END");
                stmCreaQuery.close();
            }
        } catch (SQLException sqlE) {
            excErrorAcessoDatos = sqlE;
        } finally {
            return strResultadoConsulta;
        }

    }

    /**
     * Metodo que permite Insertar Modificar y actualizar y retorna la
     * confirmaciond de la ejecucion del metodo
     *
     * @param strQuery, String que contiene la sentencia SQL a ejecutar
     * @return booRedsultado, Booleano que conetiene la la confirmacion de la
     * ejecucion del metodo
     */
    public Boolean actualizarDataBase(String strQuery) {
        Boolean booResultado = false;
        Statement staCreaQuery = null;
        try {
            if (this.conConexion != null) {
                staCreaQuery = this.conConexion.createStatement();
                staCreaQuery.execute(strQuery);
                staCreaQuery.close();
                booResultado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return booResultado;
        }
    }

    private cAccesoDatos() {
    }

    public static cAccesoDatos getInstanciaAccesoDatos() {
        if (accesoDatosInstancia == null) {
            accesoDatosInstancia = new cAccesoDatos();
        }
        return accesoDatosInstancia;
    }

    /**
     * @return the excErrorAcessoDatos
     */
    public String getExcErrorAcessoDatos() {
        String strError = null;
        if (excErrorAcessoDatos != null) {
            strError = excErrorAcessoDatos.toString();
        }
        return strError;
    }
}
