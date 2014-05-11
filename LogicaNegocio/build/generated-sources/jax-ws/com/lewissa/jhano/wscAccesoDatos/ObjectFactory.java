
package com.lewissa.jhano.wscAccesoDatos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lewissa.jhano.wscAccesoDatos package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetErrorConexion_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "getErrorConexion");
    private final static QName _ActualizarDataBase_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "actualizarDataBase");
    private final static QName _GetErrorConexionResponse_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "getErrorConexionResponse");
    private final static QName _ActualizarDataBaseResponse_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "actualizarDataBaseResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lewissa.jhano.wscAccesoDatos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActualizarDataBaseResponse }
     * 
     */
    public ActualizarDataBaseResponse createActualizarDataBaseResponse() {
        return new ActualizarDataBaseResponse();
    }

    /**
     * Create an instance of {@link ActualizarDataBase }
     * 
     */
    public ActualizarDataBase createActualizarDataBase() {
        return new ActualizarDataBase();
    }

    /**
     * Create an instance of {@link GetErrorConexionResponse }
     * 
     */
    public GetErrorConexionResponse createGetErrorConexionResponse() {
        return new GetErrorConexionResponse();
    }

    /**
     * Create an instance of {@link GetErrorConexion }
     * 
     */
    public GetErrorConexion createGetErrorConexion() {
        return new GetErrorConexion();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link CustomName }
     * 
     */
    public CustomName createCustomName() {
        return new CustomName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetErrorConexion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "getErrorConexion")
    public JAXBElement<GetErrorConexion> createGetErrorConexion(GetErrorConexion value) {
        return new JAXBElement<GetErrorConexion>(_GetErrorConexion_QNAME, GetErrorConexion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDataBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "actualizarDataBase")
    public JAXBElement<ActualizarDataBase> createActualizarDataBase(ActualizarDataBase value) {
        return new JAXBElement<ActualizarDataBase>(_ActualizarDataBase_QNAME, ActualizarDataBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetErrorConexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "getErrorConexionResponse")
    public JAXBElement<GetErrorConexionResponse> createGetErrorConexionResponse(GetErrorConexionResponse value) {
        return new JAXBElement<GetErrorConexionResponse>(_GetErrorConexionResponse_QNAME, GetErrorConexionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDataBaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "actualizarDataBaseResponse")
    public JAXBElement<ActualizarDataBaseResponse> createActualizarDataBaseResponse(ActualizarDataBaseResponse value) {
        return new JAXBElement<ActualizarDataBaseResponse>(_ActualizarDataBaseResponse_QNAME, ActualizarDataBaseResponse.class, null, value);
    }

}
