
package servidor;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;
import servlets.ConfigListener;

/**
 * This class was generated by the XML-WS Tools. XML-WS Tools 4.0.0 Generated
 * source version: 3.0
 * 
 */
@WebServiceClient(name = "PublicadorDepartamentosService", targetNamespace = "http://servidor/")
public class PublicadorDepartamentosService extends Service {

	private final static URL PUBLICADORDEPARTAMENTOSSERVICE_WSDL_LOCATION;
	private final static WebServiceException PUBLICADORDEPARTAMENTOSSERVICE_EXCEPTION;
	private final static QName PUBLICADORDEPARTAMENTOSSERVICE_QNAME = new QName("http://servidor/",
			"PublicadorDepartamentosService");

	static {
		URL url = null;
		WebServiceException e = null;
		try {
			url = new URL(ConfigListener.cfg.getProperty("departamentosControllerURL"));
		} catch (MalformedURLException ex) {
			e = new WebServiceException(ex);
		}
		PUBLICADORDEPARTAMENTOSSERVICE_WSDL_LOCATION = url;
		PUBLICADORDEPARTAMENTOSSERVICE_EXCEPTION = e;
	}

	public PublicadorDepartamentosService() {
		super(__getWsdlLocation(), PUBLICADORDEPARTAMENTOSSERVICE_QNAME);
	}

	public PublicadorDepartamentosService(WebServiceFeature... features) {
		super(__getWsdlLocation(), PUBLICADORDEPARTAMENTOSSERVICE_QNAME, features);
	}

	public PublicadorDepartamentosService(URL wsdlLocation) {
		super(wsdlLocation, PUBLICADORDEPARTAMENTOSSERVICE_QNAME);
	}

	public PublicadorDepartamentosService(URL wsdlLocation, WebServiceFeature... features) {
		super(wsdlLocation, PUBLICADORDEPARTAMENTOSSERVICE_QNAME, features);
	}

	public PublicadorDepartamentosService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public PublicadorDepartamentosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
		super(wsdlLocation, serviceName, features);
	}

	/**
	 * 
	 * @return returns PublicadorDepartamentos
	 */
	@WebEndpoint(name = "PublicadorDepartamentosPort")
	public PublicadorDepartamentos getPublicadorDepartamentosPort() {
		return super.getPort(new QName("http://servidor/", "PublicadorDepartamentosPort"),
				PublicadorDepartamentos.class);
	}

	/**
	 * 
	 * @param features A list of {@link jakarta.xml.ws.WebServiceFeature} to
	 *                 configure on the proxy. Supported features not in the
	 *                 <code>features</code> parameter will have their default
	 *                 values.
	 * @return returns PublicadorDepartamentos
	 */
	@WebEndpoint(name = "PublicadorDepartamentosPort")
	public PublicadorDepartamentos getPublicadorDepartamentosPort(WebServiceFeature... features) {
		return super.getPort(new QName("http://servidor/", "PublicadorDepartamentosPort"),
				PublicadorDepartamentos.class, features);
	}

	private static URL __getWsdlLocation() {
		if (PUBLICADORDEPARTAMENTOSSERVICE_EXCEPTION != null) {
			throw PUBLICADORDEPARTAMENTOSSERVICE_EXCEPTION;
		}
		return PUBLICADORDEPARTAMENTOSSERVICE_WSDL_LOCATION;
	}

}
