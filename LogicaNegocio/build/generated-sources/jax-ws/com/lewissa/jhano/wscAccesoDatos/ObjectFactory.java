
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

    private final static QName _ActualizarDataBaseCliente_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "actualizarDataBaseCliente");
    private final static QName _GetErrorConexion_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "getErrorConexion");
    private final static QName _ActualizarDataBaseClienteResponse_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "actualizarDataBaseClienteResponse");
    private final static QName _GetErrorConexionResponse_QNAME = new QName("http://ws.accesodatos.jhano.lewissa.com/", "getErrorConexionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lewissa.jhano.wscAccesoDatos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetErrorConexionResponse }
     * 
     */
    public GetErrorConexionResponse createGetErrorConexionResponse() {
        return new GetErrorConexionResponse();
    }

    /**
     * Create an instance of {@link ActualizarDataBaseClienteResponse }
     * 
     */
    public ActualizarDataBaseClienteResponse createActualizarDataBaseClienteResponse() {
        return new ActualizarDataBaseClienteResponse();
    }

    /**
     * Create an instance of {@link GetErrorConexion }
     * 
     */
    public GetErrorConexion createGetErrorConexion() {
        return new GetErrorConexion();
    }

    /**
     * Create an instance of {@link ActualizarDataBaseCliente }
     * 
     */
    public ActualizarDataBaseCliente createActualizarDataBaseCliente() {
        return new ActualizarDataBaseCliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDataBaseCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "actualizarDataBaseCliente")
    public JAXBElement<ActualizarDataBaseCliente> createActualizarDataBaseCliente(ActualizarDataBaseCliente value) {
        return new JAXBElement<ActualizarDataBaseCliente>(_ActualizarDataBaseCliente_QNAME, ActualizarDataBaseCliente.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizarDataBaseClienteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "actualizarDataBaseClienteResponse")
    public JAXBElement<ActualizarDataBaseClienteResponse> createActualizarDataBaseClienteResponse(ActualizarDataBaseClienteResponse value) {
        return new JAXBElement<ActualizarDataBaseClienteResponse>(_ActualizarDataBaseClienteResponse_QNAME, ActualizarDataBaseClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetErrorConexionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.accesodatos.jhano.lewissa.com/", name = "getErrorConexionResponse")
    public JAXBElement<GetErrorConexionResponse> createGetErrorConexionResponse(GetErrorConexionResponse value) {
        return new JAXBElement<GetErrorConexionResponse>(_GetErrorConexionResponse_QNAME, GetErrorConexionResponse.class, null, value);
    }

}
