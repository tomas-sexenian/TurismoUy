package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoRepetidoException;
import excepciones.EmailRepetidoException;
import excepciones.EntidadRepetidaException;
import excepciones.InscripcionRepetidaException;
import excepciones.NickameRepetidoException;
import excepciones.NoExisteEntidadException;
import excepciones.NoHayCapacidadException;
import excepciones.SalidaNoExisteException;
import excepciones.SalidaRepetidaException;
import excepciones.UsuarioNoExisteException;
import logica.Fabrica;
import logica.datatypes.DataInscripcion;
import logica.datatypes.DataSalidaTuristica;
import logica.interfaces.IControladorActividades;
import logica.interfaces.IControladorDepartamentos;
import logica.interfaces.IControladorSalidas;
import logica.interfaces.IControladorUsuario;

class ControladorSalidasTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		IControladorUsuario controlUSR = Fabrica.getInstance().getIControladorUsuario();
		IControladorSalidas controlSAL = Fabrica.getInstance().getIControladorSalidas();
		IControladorActividades controlACT = Fabrica.getInstance().getIControladorActividades();
		IControladorDepartamentos controlDEP = Fabrica.getInstance().getIControladorDepartamentos();
		try {
			controlACT.agregarCategoria("Categoria de prueba");
			controlUSR.crearProveedor("washington", "Washington", "Rocha", "washington@turismorocha.gub.uy",
					LocalDate.of(1970, 9, 14),
					"Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay",
					"http://turismorocha.gub.uy/", "psw", "");
			controlUSR.crearTurista("waston", "Emma", "Waston", "e.waston@gmail.com", LocalDate.of(1990, 4, 14),
					"inglesa", "psw", "");

			controlDEP.crearDepartamento("Rocha",
					"La Organizacion de Gestion del Destino (OGD) Rocha es un ambito de articulacion publico / privada "
							+ "en el sector turistico que integran la Coporacion Rochense de Turismo y la Intendencia de Rocha a traves de su Direccion de Turismo",
					"http://www.turismorocha.gub.uy/");
		} catch (EmailRepetidoException e) {
			// empty block on purpose
		} catch (NickameRepetidoException e) {
			// empty block on purpose
		} catch (DepartamentoRepetidoException e) {
			// empty block on purpose
		} catch (EntidadRepetidaException e) {
			// empty block on purpose
		}
		controlACT.crearActividad("Rocha", "Festival gastronomico de productos locales en Rocha", "Degusta", 3, 800,
				"Rocha", LocalDate.of(2022, 7, 20), "washington",
				new ArrayList<String>(Arrays.asList("Categoria de prueba")));

		controlSAL.crearSalida("Degusta Agosto Dos", 20, LocalDate.of(2022, 7, 21), "Sociedad Agropecuaria de Rocha",
				LocalDate.of(2022, 12, 20), "17:00", "Degusta");

	}

	@Test
	void crearSalidaOK() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icSalidas = fabrica.getIControladorSalidas();
		String nombre = "Un nombre";
		int cant = 10;
		String lugar = "Un lugar";
		LocalDate fecha = LocalDate.of(2022, 8, 1);
		String hora = "5:00";
		String act = "Degusta";
		String img = "";
		try {
			icSalidas.crearSalida(nombre, cant, lugar, fecha, hora, act, img);
		} catch (SalidaRepetidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ActividadNoExisteException e1) {
			fail(e1.getMessage());
			e1.printStackTrace();
		}
		try {
			DataSalidaTuristica datas = icSalidas.consultarSalida(nombre);
			assertEquals(nombre, datas.getNombre());
			assertEquals(cant, datas.getCantMaxTuristas());
			assertEquals(lugar, datas.getLugarSalida());
			// assertEquals(fecha, datas.getFechaSalida());
			assertEquals(act, datas.getActividad());
			assertEquals(img, datas.getImgSrc());
		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ActividadNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * @Test void testobtenerActividadesDepartamentoOk() { Fabrica fabrica =
	 * Fabrica.getInstance(); IControladorSalidas icd =
	 * fabrica.getIControladorSalidas(); try { DataActividadTuristica[] acts =
	 * icd.obtenerActividadesDepartamento("Rocha"); assertTrue(acts.length > 0); }
	 * catch (DepartamentoNoExisteException e) { fail(e.getMessage());
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	@Test
	void testGetSalidasOK() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icActividades = fabrica.getIControladorSalidas();
		try {
			assertTrue(icActividades.getSalidas("Degusta").size() > 0);
		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testobtenerActividadesDepartamentoFail() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		assertThrows(DepartamentoNoExisteException.class, () -> {
			icd.obtenerActividadesDepartamento("algo");
		});
	}

	@Test
	void testCrearSalidaRepetida() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		assertThrows(SalidaRepetidaException.class, () -> {
			icd.crearSalida("Degusta Agosto", 0, LocalDate.of(2022, 8, 1), "lugar", LocalDate.of(2022, 8, 1), "00:00",
					"Degusta");
		});
	}

	@Test
	void testModificarSalida() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		String nombreString = "Degusta Agosto";
		int cant = 8;
		LocalDate fechaA = LocalDate.of(2022, 8, 1);
		String lugar = "lugar";
		LocalDate fechaS = LocalDate.of(2022, 12, 1);
		String hora = "01:00";
		try {

			icd.modificarSalida(nombreString, cant, fechaA, lugar, fechaS, hora);
			DataSalidaTuristica salidaTuristica = icd.consultarSalida(nombreString);
			assertEquals(salidaTuristica.getNombre(), nombreString);
			assertEquals(salidaTuristica.getFechaAlta(), fechaA);
			// assertEquals(salidaTuristica.getFechaSalida(), fechaS);
			assertEquals(salidaTuristica.getHoraSalida(), hora);
			assertEquals(salidaTuristica.getCantMaxTuristas(), cant);
			assertEquals(salidaTuristica.getLugarSalida(), lugar);
		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testConsultarSalidaFail() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		assertThrows(SalidaNoExisteException.class, () -> {
			icd.consultarSalida("algo");
		});
	}

	@Test
	void testGetSalidas() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		try {
			DataSalidaTuristica[] salidas = icd.getSalidas();
			assertTrue(salidas.length > 0);
		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testGetSalidasVigentes() {

		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		boolean encontrado = false;
		try {
			List<DataSalidaTuristica> salidas = Arrays.asList(icd.getSalidasVigentes("Degusta"));
			for (DataSalidaTuristica s : salidas) {
				if (s.getNombre().equals("Degusta Agosto Dos")) {
					encontrado = true;
				}
			}

		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertTrue(encontrado);
	}

	@Test
	void testGetSalidasVigentesFail() {

		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		try {
			List<DataSalidaTuristica> salidas = Arrays.asList(icd.getSalidasVigentes("algo"));
			assertTrue(salidas.size() == 0);

		} catch (SalidaNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	void testInscribirTuristaSalida() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		String nick = "waston";
		String nomsalida = "Degusta Agosto";
		int cant = 1;
		LocalDate fechaA = LocalDate.of(2022, 10, 1);
		try {
			icd.inscribirTuristaSalida(nick, nomsalida, cant, fechaA);
		} catch (NoExisteEntidadException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (InscripcionRepetidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (NoHayCapacidadException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		IControladorUsuario icu = fabrica.getIControladorUsuario();

		boolean encontradoInscripcion = false;

		try {
			DataInscripcion[] dis = icu.obtenerInscripcionesTurista(nick)
					.toArray(new DataInscripcion[icu.obtenerInscripcionesTurista(nick).size()]);
			for (DataInscripcion di : dis) {
				if (di.getSalida().getNombre().equals(nomsalida)) {
					encontradoInscripcion = true;
					assertTrue(di.getCantTuristas() == cant);
				}
			}
		} catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		IControladorUsuario controlUSR = Fabrica.getInstance().getIControladorUsuario();
		try {
			controlUSR.verInfoTurista("waston");
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(encontradoInscripcion);
	}

	@Test
	void testInscribirTuristaSalida2() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		String nick = "waston";
		String nomsalida = "Degusta setiembre";
		int cant = 1;
		try {
			icd.inscribirTuristaSalida(nick, nomsalida, cant);
		} catch (NoExisteEntidadException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (InscripcionRepetidaException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (NoHayCapacidadException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		IControladorUsuario icu = fabrica.getIControladorUsuario();

		boolean encontradoInscripcion = false;

		try {
			DataInscripcion[] dis = icu.obtenerInscripcionesTurista(nick)
					.toArray(new DataInscripcion[icu.obtenerInscripcionesTurista(nick).size()]);
			for (DataInscripcion di : dis) {
				if (di.getSalida().getNombre().equals(nomsalida)) {
					encontradoInscripcion = true;
					assertTrue(di.getCantTuristas() == cant);
				}
			}
		} catch (UsuarioNoExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		IControladorUsuario controlUSR = Fabrica.getInstance().getIControladorUsuario();
		try {
			controlUSR.verInfoTurista("waston");
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(encontradoInscripcion);
	}

	@Test
	void testInscribirTuristaSalidaPaq() {
		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas icd = fabrica.getIControladorSalidas();
		String nick = "lachiqui";
		String nomsalida = "Degusta Octubre";
		int cant = 1;
		assertThrows(NoHayCapacidadException.class, () -> {
			icd.inscribirTuristaSalidaPaquete(nick, nomsalida, "Disfrutar Rocha", cant);
		});

	}

	@Test
	void testVIsitas() {

		Fabrica fabrica = Fabrica.getInstance();
		IControladorSalidas iControladorSalidas = fabrica.getIControladorSalidas();

		int cant = iControladorSalidas.updateVisitsSalida("Degusta Octubre");
		assertTrue(cant > 0);
	}

}
