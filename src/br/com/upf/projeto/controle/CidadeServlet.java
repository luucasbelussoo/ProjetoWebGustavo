package br.com.upf.projeto.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.upf.projeto.beans.Cidade;
import br.com.upf.projeto.beans.Estado;
import br.com.upf.projeto.dao.GenericDAO;

/**
 * Servlet implementation class CidadeServlet
 */
@WebServlet("/Privado/Cidade/CidadeServlet")
public class CidadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CidadeServlet() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cidade> cidades = new ArrayList<>();
		GenericDAO<Cidade> dao = new GenericDAO<>(Cidade.class);
		GenericDAO<Estado> daoEstado = new GenericDAO<>(Estado.class);
		// 1 - Descobrir qual a operação e executar
		String oper = request.getParameter("oper");
		oper = oper == null ? "listar" : oper;
		String abrir = "";
		switch (oper) {
		case "listar":
			// fazer operação
			cidades = dao.getInstanciasList();
			abrir = "ListCidade.jsp";
			break;
		case "novo":
			// fazer operação
			abrir = "FormCidade.jsp";
			break;
		case "gravar": {
			// fazer operacão
			Cidade p = new Cidade(
					request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")),
					request.getParameter("nome"),
					new Estado(request.getParameter("estado").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("estado"))));					

			if (p.getNome().length() <= 0) {
				request.setAttribute("erro", "O nome da cidade é obrigatória!");
				abrir = "FormCidade.jsp";
				request.setAttribute("cidade", p);
			 
			} else
				try {
					dao.merge(p);
					cidades = dao.getInstanciasList();
					abrir = "ListCidade.jsp";
				} catch (Exception e) {
					abrir = "FormCidade.jsp";
					request.setAttribute("cidade", p);
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
			cidades = dao.getInstanciasList();
			abrir = "ListCidade.jsp";
			break;
		}
		case "alterar":
			try {
				Cidade p = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("cidade", p); // colocar na requisição para
													// o JSP usar
				abrir = "FormCidade.jsp";
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				cidades = dao.getInstanciasList();
				abrir = "ListCidade.jsp";
			}

			break;

		}
		request.getSession().setAttribute("cidades", cidades);
		request.setAttribute("estados", daoEstado.getInstanciasList());

		// 2 - Encaminhar para JPS dar resposta
		// response.sendRedirect(abrir);
		request.getRequestDispatcher(abrir).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
