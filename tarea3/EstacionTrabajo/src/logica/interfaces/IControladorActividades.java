package logica.interfaces;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.EntidadRepetidaException;
import excepciones.NoExisteEntidadException;
import excepciones.NoExistePaqueteException;
import excepciones.PaqueteCompradoException;
import logica.datatypes.DataActividadTuristica;
import logica.datatypes.DataActividadTuristicaP;
import logica.datatypes.DataPaqueteActividades;

public interface IControladorActividades {

	public abstract void crearActividad(String departamento, String descripcion, String nombre, int duracion,
			double costo, String ciudad, String proveedor, List<String> nomCategorias)
			throws ActividadRepetidaException;

	public abstract void crearActividad(String departamento, String descripcion, String nombre, int duracion,
			double costo, String ciudad, LocalDate fechaAlta, String proveedor, List<String> nomCategorias)
			throws ActividadRepetidaException;

	public abstract void crearActividad(String departamento, String descripcion, String nombre, int duracion,
			double costo, String ciudad, String proveedor, List<String> nomCategorias, String imgSrc, String video,
			int cantFavoritos) throws ActividadRepetidaException;

	public abstract void crearActividad(String departamento, String descripcion, String nombre, int duracion,
			double costo, String ciudad, LocalDate fechaAlta, String proveedor, List<String> nomCategorias,
			String imgSrc, String video, int cantFavoritos) throws ActividadRepetidaException;

	public abstract void aceptarActividad(String nombreActividad) throws ActividadNoExisteException;

	public abstract void rechazarActividad(String nombreActividad) throws ActividadNoExisteException;

	public abstract void modificarActividad(String departamento, String nombre, int duracion, double costo,
			String ciudad, LocalDate fechaAlta) throws ActividadNoExisteException;

	public abstract DataActividadTuristica consultarActividad(String nombre) throws ActividadNoExisteException;

	public abstract List<DataActividadTuristica> obtenerActividades() throws ActividadNoExisteException;

	public abstract ArrayList<DataActividadTuristica> obtenerActividadesConfirmadas() throws ActividadNoExisteException;

	public abstract List<DataActividadTuristica> obtenerActividades(String departamento)
			throws ActividadNoExisteException;

	public abstract ArrayList<DataActividadTuristica> obtenerActividadesConfirmadas(String departamento)
			throws ActividadNoExisteException;

	public abstract ArrayList<DataActividadTuristica> obtenerActividadesConfirmadas(String departamento,
			String categoria) throws ActividadNoExisteException;

	public abstract ArrayList<String> obtenerCategorias();

	public abstract void agregarCategoria(String nombre) throws EntidadRepetidaException;

	public abstract void crearPaquete(String nombre, String descripcion, int validez, double descuento, LocalDate fecha)
			throws EntidadRepetidaException;

	public abstract void crearPaquete(String nombre, String descripcion, int validez, double descuento, LocalDate fecha,
			String imgSrc) throws EntidadRepetidaException;

	public abstract void modificarPaquete(String nombre, String descripcion, int validez, double descuento)
			throws NoExistePaqueteException;

	public abstract DataPaqueteActividades consultarPaquete(String nombre) throws NoExisteEntidadException;

	public abstract ArrayList<DataPaqueteActividades> obtenerPaquetes() throws NoExisteEntidadException;

	public abstract List<DataPaqueteActividades> obtenerPaquetes(String actividad) throws NoExisteEntidadException;

	public abstract void agregarActividadPaquete(String paquete, String actividad) throws NoExistePaqueteException,
			ActividadNoExisteException, ActividadRepetidaException, PaqueteCompradoException;

	public abstract String obtenerProveedorActividad(String nombre) throws ActividadNoExisteException;

	public abstract ArrayList<DataActividadTuristica> obtenerProveedorActividadesNoFinalizadas(String nickname);

	public abstract ArrayList<DataActividadTuristicaP> obtenerProveedorActividadesFinalizadas(String nickname,
			String nombreActividad);

	public abstract void finalizarActividad(String nombreActividad) throws ActividadNoExisteException;

	public abstract int updateVisitsActividad(String nombre);

	public abstract Map<String, Integer> getContadorActividades();

}
