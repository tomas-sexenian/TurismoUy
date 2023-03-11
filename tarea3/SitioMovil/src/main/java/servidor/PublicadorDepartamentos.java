
package servidor;

import jakarta.jws.WebMethod;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "PublicadorDepartamentos", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PublicadorDepartamentos {


    /**
     * 
     * @return
     *     returns servidor.DataDepartamentoArray
     * @throws DepartamentoNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorDepartamentos/obtenerDepartamentosRequest", output = "http://servidor/PublicadorDepartamentos/obtenerDepartamentosResponse", fault = {
        @FaultAction(className = DepartamentoNoExisteException_Exception.class, value = "http://servidor/PublicadorDepartamentos/obtenerDepartamentos/Fault/DepartamentoNoExisteException")
    })
    public DataDepartamentoArray obtenerDepartamentos()
        throws DepartamentoNoExisteException_Exception
    ;

}
