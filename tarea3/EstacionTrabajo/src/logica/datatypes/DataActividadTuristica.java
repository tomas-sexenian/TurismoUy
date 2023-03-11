package logica.datatypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import logica.EstadoActividad;

public class DataActividadTuristica {

	private DataDepartamento departamento;
	private String nombre;
	private String descripcion;
	private String proveedor;
	private int duracion;
	private double costo;
	private String ciudad;
	private String fechaAlta;
	private List<DataSalidaTuristica> salidas;
	private EstadoActividad estado;
	private List<String> categorias;
	private String imageSrc;
	private String video;
	private List<DataPaqueteActividades> paquetes;
	private int cantFavoritos;

	public DataActividadTuristica(DataDepartamento departamento, String nombre, String proveedor, String descripcion,
			int duracion, double costo, String ciudad, LocalDate fechaAlta, List<DataSalidaTuristica> salidas,
			EstadoActividad estado, List<String> categorias, String imgSrc, String video, int cantFavoritos,
			List<DataPaqueteActividades> paquetes) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String fechaAltaString = fechaAlta.format(formatter);
		setDepartamento(departamento);
		setNombre(nombre);
		setProveedor(proveedor);
		setDescripcion(descripcion);
		setDuracion(duracion);
		setCosto(costo);
		setCiudad(ciudad);
		this.fechaAlta = fechaAltaString;
		setSalidas(salidas);
		this.estado = estado;
		setCategorias(categorias);
		setImageSrc(imgSrc);
		setVideo(video);
		setPaquetes(paquetes);
		setCantFavoritos(cantFavoritos);
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public DataActividadTuristica(DataDepartamento departamento, String nombre, String proveedor, String descripcion,
			int duracion, double real, String ciudad, LocalDate fechaAlta, EstadoActividad estado,
			List<String> categorias, String imgSrc, String video, int cantFavoritos) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String fechaAltaString = fechaAlta.format(formatter);
		setDepartamento(departamento);
		setNombre(nombre);
		setProveedor(proveedor);
		setDescripcion(descripcion);
		setDuracion(duracion);
		setCosto(real);
		setCiudad(ciudad);
		this.fechaAlta = fechaAltaString;
		this.salidas = new ArrayList<DataSalidaTuristica>();
		this.estado = estado;
		setCategorias(categorias);
		setImageSrc(imgSrc);
		setVideo(video);
		setCantFavoritos(cantFavoritos);
	}

	public DataActividadTuristica(DataDepartamento dpto, String nombre, String proveedor, String descripcion,
			int duracion, double costo, String ciudad, LocalDate fechaAlta, List<DataSalidaTuristica> salidas,
			EstadoActividad estado, List<String> nombresCategorias, String imgSrc, int cantFavoritos) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		String fechaAltaString = fechaAlta.format(formatter);
		setDepartamento(departamento);
		setNombre(nombre);
		setProveedor(proveedor);
		setDescripcion(descripcion);
		setDuracion(duracion);
		setCosto(costo);
		setCiudad(ciudad);
		this.fechaAlta = fechaAltaString;
		this.salidas = salidas;
		this.estado = estado;
		setCategorias(nombresCategorias);
		setImageSrc(imgSrc);
		setCantFavoritos(cantFavoritos);
	}

	public int getCantFavoritos() {
		return cantFavoritos;
	}

	public void setCantFavoritos(int cantFavoritos) {
		this.cantFavoritos = cantFavoritos;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<DataPaqueteActividades> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<DataPaqueteActividades> paquetes) {
		this.paquetes = paquetes;
	}

	public DataDepartamento getDepartamento() {
		return departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public List<DataSalidaTuristica> getSalidas() {
		return salidas;
	}

	public EstadoActividad getEstadoActividad() {
		return estado;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public void setDepartamento(DataDepartamento departamento) {
		this.departamento = departamento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setSalidas(List<DataSalidaTuristica> salidas) {
		this.salidas = salidas;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public EstadoActividad getEstado() {
		return estado;
	}

	public void setEstado(EstadoActividad estado) {
		this.estado = estado;
	}

	/*
	 * public DataSalidaTuristica obtenerSalida (String nombre) { return
	 * this.salidas.get(nombre); }
	 */

	@Override
	public String toString() {
		return nombre + " ($" + costo + ")";
	}

}
