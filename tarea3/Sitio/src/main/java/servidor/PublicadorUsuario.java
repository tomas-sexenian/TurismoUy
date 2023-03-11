
package servidor;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import net.java.dev.jaxb.array.StringArray;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "PublicadorUsuario", targetNamespace = "http://servidor/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    net.java.dev.jaxb.array.ObjectFactory.class,
    servidor.ObjectFactory.class
})
public interface PublicadorUsuario {


    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/modificarTuristaRequest", output = "http://servidor/PublicadorUsuario/modificarTuristaResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/modificarTurista/Fault/UsuarioNoExisteException")
    })
    public void modificarTurista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/modificarProveedorRequest", output = "http://servidor/PublicadorUsuario/modificarProveedorResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/modificarProveedor/Fault/UsuarioNoExisteException")
    })
    public void modificarProveedor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/modificarImagenRequest", output = "http://servidor/PublicadorUsuario/modificarImagenResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/modificarImagen/Fault/UsuarioNoExisteException")
    })
    public void modificarImagen(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/modificarContrasenaRequest", output = "http://servidor/PublicadorUsuario/modificarContrasenaResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/modificarContrasena/Fault/UsuarioNoExisteException")
    })
    public void modificarContrasena(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataInscripcionArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/obtenerInscripcionesTuristaRequest", output = "http://servidor/PublicadorUsuario/obtenerInscripcionesTuristaResponse")
    public DataInscripcionArray obtenerInscripcionesTurista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @throws PaqueteCompradoException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/compraTuristaPaqueteRequest", output = "http://servidor/PublicadorUsuario/compraTuristaPaqueteResponse", fault = {
        @FaultAction(className = PaqueteCompradoException_Exception.class, value = "http://servidor/PublicadorUsuario/compraTuristaPaquete/Fault/PaqueteCompradoException")
    })
    public void compraTuristaPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2)
        throws PaqueteCompradoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/obtenerPasswordRequest", output = "http://servidor/PublicadorUsuario/obtenerPasswordResponse")
    public String obtenerPassword(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/obtenerNicknameRequest", output = "http://servidor/PublicadorUsuario/obtenerNicknameResponse")
    public String obtenerNickname(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/existeEmailRequest", output = "http://servidor/PublicadorUsuario/existeEmailResponse")
    public boolean existeEmail(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/dejarDeSeguirUsrRequest", output = "http://servidor/PublicadorUsuario/dejarDeSeguirUsrResponse")
    public void dejarDeSeguirUsr(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/seguirUsrRequest", output = "http://servidor/PublicadorUsuario/seguirUsrResponse")
    public void seguirUsr(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/cantSeguidoresRequest", output = "http://servidor/PublicadorUsuario/cantSeguidoresResponse")
    public int cantSeguidores(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/cantSeguidosRequest", output = "http://servidor/PublicadorUsuario/cantSeguidosResponse")
    public int cantSeguidos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/sigueAUsuarioRequest", output = "http://servidor/PublicadorUsuario/sigueAUsuarioResponse")
    public boolean sigueAUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/marcarFavoritaRequest", output = "http://servidor/PublicadorUsuario/marcarFavoritaResponse")
    public void marcarFavorita(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/desmarcarFavoritaRequest", output = "http://servidor/PublicadorUsuario/desmarcarFavoritaResponse")
    public void desmarcarFavorita(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataCompraArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/obtenerComprasTuristaRequest", output = "http://servidor/PublicadorUsuario/obtenerComprasTuristaResponse")
    public DataCompraArray obtenerComprasTurista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataProveedorArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getSeguidoresProvRequest", output = "http://servidor/PublicadorUsuario/getSeguidoresProvResponse")
    public DataProveedorArray getSeguidoresProv(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataTuristaArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getSeguidoresTurRequest", output = "http://servidor/PublicadorUsuario/getSeguidoresTurResponse")
    public DataTuristaArray getSeguidoresTur(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataProveedorArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getSeguidosProvRequest", output = "http://servidor/PublicadorUsuario/getSeguidosProvResponse")
    public DataProveedorArray getSeguidosProv(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataTuristaArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getSeguidosTurRequest", output = "http://servidor/PublicadorUsuario/getSeguidosTurResponse")
    public DataTuristaArray getSeguidosTur(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns net.java.dev.jaxb.array.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/obtenerFavoritasRequest", output = "http://servidor/PublicadorUsuario/obtenerFavoritasResponse")
    public StringArray obtenerFavoritas(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/esFavoritaRequest", output = "http://servidor/PublicadorUsuario/esFavoritaResponse")
    public boolean esFavorita(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @throws EmailRepetidoException_Exception
     * @throws NickameRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/crearTuristaRequest", output = "http://servidor/PublicadorUsuario/crearTuristaResponse", fault = {
        @FaultAction(className = EmailRepetidoException_Exception.class, value = "http://servidor/PublicadorUsuario/crearTurista/Fault/EmailRepetidoException"),
        @FaultAction(className = NickameRepetidoException_Exception.class, value = "http://servidor/PublicadorUsuario/crearTurista/Fault/NickameRepetidoException")
    })
    public void crearTurista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7)
        throws EmailRepetidoException_Exception, NickameRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @throws EmailRepetidoException_Exception
     * @throws NickameRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://servidor/PublicadorUsuario/crearProveedorRequest", output = "http://servidor/PublicadorUsuario/crearProveedorResponse", fault = {
        @FaultAction(className = EmailRepetidoException_Exception.class, value = "http://servidor/PublicadorUsuario/crearProveedor/Fault/EmailRepetidoException"),
        @FaultAction(className = NickameRepetidoException_Exception.class, value = "http://servidor/PublicadorUsuario/crearProveedor/Fault/NickameRepetidoException")
    })
    public void crearProveedor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8)
        throws EmailRepetidoException_Exception, NickameRepetidoException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.DataTuristaArray
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getTuristasRequest", output = "http://servidor/PublicadorUsuario/getTuristasResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/getTuristas/Fault/UsuarioNoExisteException")
    })
    public DataTuristaArray getTuristas()
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @return
     *     returns servidor.DataProveedorArray
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/getProveedoresRequest", output = "http://servidor/PublicadorUsuario/getProveedoresResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/getProveedores/Fault/UsuarioNoExisteException")
    })
    public DataProveedorArray getProveedores()
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataTurista
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/verInfoTuristaRequest", output = "http://servidor/PublicadorUsuario/verInfoTuristaResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/verInfoTurista/Fault/UsuarioNoExisteException")
    })
    public DataTurista verInfoTurista(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws UsuarioNoExisteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns servidor.DataProveedor
     * @throws UsuarioNoExisteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://servidor/PublicadorUsuario/verInfoProveedorRequest", output = "http://servidor/PublicadorUsuario/verInfoProveedorResponse", fault = {
        @FaultAction(className = UsuarioNoExisteException_Exception.class, value = "http://servidor/PublicadorUsuario/verInfoProveedor/Fault/UsuarioNoExisteException")
    })
    public DataProveedor verInfoProveedor(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws UsuarioNoExisteException_Exception
    ;

}
