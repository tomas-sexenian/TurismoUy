package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoActividades;
import dao.DaoSalidas;
import dao.DaoUsuarios;
import servidor.DataActividadTuristica;

/**
 * Servlet implementation class consultaSalidaServlet
 */
@WebServlet(name = "consultaSalida", urlPatterns = { "/consultaSalida" })
public class consultaSalidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoSalidas daoSalidas = new DaoSalidas();
		servidor.DataSalidaTuristica salida = daoSalidas.obtenerSalida(request.getParameter("salida"));

		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
		LocalDate fechaSalida = LocalDate.parse(salida.getFechaSalida(), formatters);
		if (fechaSalida.isAfter(LocalDate.now())) {
			request.getSession().setAttribute("vigente", "yes");
		} else {
			request.getSession().setAttribute("vigente", "");
		}

		DaoActividades daoActividades = new DaoActividades();
		DaoUsuarios daoUsuarios = new DaoUsuarios();
		DataActividadTuristica actividad = daoActividades.obtenerActividadTuristica(salida.getActividad());
		List<servidor.DataPaqueteActividades> paquetes = new ArrayList<>();
		if (request.getSession().getAttribute("usuario_logueado") != null
				&& request.getSession().getAttribute("tipo_usuario").equals("Turista")) {
			String username = (String) request.getSession().getAttribute("usuario_logueado");
			List<servidor.DataPaqueteActividades> paquetesTurista = daoUsuarios
					.obternerPaquetesVigentesTurista(username);
			List<servidor.DataPaqueteActividades> paquetesActividad = actividad.getPaquetes();
			for (servidor.DataPaqueteActividades paqt : paquetesTurista) {
				for (servidor.DataPaqueteActividades paqa : paquetesActividad) {
					if (paqt.getNombre().equals(paqa.getNombre())) {
						paquetes.add(paqt);
					}
				}
			}
			if (paquetes.size() > 0) {
				request.getSession().setAttribute("tienePaquetes", "yes");
			}
		}
		request.getSession().setAttribute("paquetesUsuario", paquetes);
		request.getSession().setAttribute("salida", salida);
		request.getRequestDispatcher("/htmls/consultaSalida.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
