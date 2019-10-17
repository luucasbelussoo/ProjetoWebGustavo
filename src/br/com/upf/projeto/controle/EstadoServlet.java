package br.com.upf.projeto.controle;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upf.projeto.beans.Estado;
import br.com.upf.projeto.dao.GenericDAO;

/**
 * Servlet implementation class UfServlet
 */
@WebServlet("/Privado/Estado/EstadoServlet")
public class EstadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EstadoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Estado> estados = new ArrayList<>();
		GenericDAO<Estado> dao = new GenericDAO<>(Estado.class);

		String oper = request.getParameter("oper");
		oper = oper == null ? "listar" : oper;
		String abrir = "";
		switch (oper) {

		case "listar":

			estados = dao.getInstanciasList();

			abrir = "ListEstado.jsp";
			break;
		case "novo": {
			abrir = "FormEstado.jsp";

		}
			break;
		case "gravar": {
			Estado d = new Estado(
					request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")),
					request.getParameter("nome"), 
					request.getParameter("uf")
					);

			
			
			if (d.getNome().length() <= 0) {
				request.setAttribute("Erro", "A nome é obrigatório");
				abrir = "FormEstado.jsp";
				request.setAttribute("estado", d);
			} else
				try {
					dao.merge(d);
					estados = dao.getInstanciasList();
					abrir = "ListEstado.jsp";
				} catch (Exception e) {
					abrir = "FormEstado.jsp";
					request.setAttribute("Estado", d);
					request.setAttribute("erro", e.getMessage());
				}
			break;
		}
		case "excluir": {
			try {
				dao.remove(Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
			}
			estados = dao.getInstanciasList();
			abrir = "ListEstado.jsp";
			break;

		}
		case "alterar":
			try {
				Estado d = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("estado", d);
				abrir = "FormEstado.jsp";
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				estados = dao.getInstanciasList();
				abrir = "ListEstado.jsp";
			}

			break;
		}

		request.getSession().setAttribute("estados", estados);

		request.getRequestDispatcher(abrir).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
