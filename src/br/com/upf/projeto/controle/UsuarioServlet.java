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
import br.com.upf.projeto.beans.Usuario;
import br.com.upf.projeto.dao.GenericDAO;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/Privado/Usuario/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Usuario> usuarios = new ArrayList<>();
		GenericDAO<Usuario> dao = new GenericDAO<>(Usuario.class);
		GenericDAO<Cidade> daoCidade = new GenericDAO<>(Cidade.class);
		// 1 - Descobrir qual a operação e executar
		String oper = request.getParameter("oper");
		oper = oper == null ? "listar" : oper;
		String abrir = "";
		switch (oper) {
		case "listar":
			// fazer operação
			usuarios = dao.getInstanciasList();
			abrir = "ListUsuario.jsp";
			break;
		case "novo":
			// fazer operação
			abrir = "FormUsuario.jsp";
			break;
		case "gravar": {
			// fazer operacão
			Usuario p = new Usuario(
					request.getParameter("id").trim().isEmpty() ? null : Integer.parseInt(request.getParameter("id")),
					request.getParameter("nome"),
					request.getParameter("login"),
					request.getParameter("senha"),
					request.getParameter("endereco"),
					request.getParameter("telefone"),
					request.getParameter("cpf"),
					new Cidade(request.getParameter("cidade").trim().isEmpty() ? null
							: Integer.parseInt(request.getParameter("cidade"))));

			if (p.getNome().length() <= 0) {
				request.setAttribute("erro", "O nome é obrigatório!");
				abrir = "FormUsuario.jsp";
				request.setAttribute("usuario", p);

			}
			if (p.getLogin().length() <= 0) {
				request.setAttribute("erro", "O login é obrigatório!");
				abrir = "FormUsuario.jsp";
				request.setAttribute("usuario", p);
			}
			if (p.getSenha().length() <= 0) {
				request.setAttribute("erro", "A senha é obrigatória!");
				abrir = "FormUsuario.jsp";
				request.setAttribute("usuario", p);
			}
			if (p.getEndereco().length() <= 0) {
				request.setAttribute("erro", "O endereço é obrigatório!");
				abrir = "FormUsuario.jsp";
				request.setAttribute("usuario", p);
			} 
			if (p.getTelefone().length() <= 0) {
				request.setAttribute("erro", "O telefone é obrigatório!");
				abrir = "FormUsuario.jsp";
				request.setAttribute("usuario", p);
			} else
				try {
					dao.merge(p);
					usuarios = dao.getInstanciasList();
					abrir = "ListUsuario.jsp";
				} catch (Exception e) {
					abrir = "FormUsuario.jsp";
					request.setAttribute("usuario", p);
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
			usuarios = dao.getInstanciasList();
			abrir = "ListUsuario.jsp";
			break;
		}
		case "alterar":
			try {
				Usuario p = dao.getInstancia(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("usuario", p); // colocar na requisição para
														// o JSP usar
				abrir = "FormUsuario.jsp";
			} catch (Exception e) {
				request.setAttribute("erro", e.getMessage());
				usuarios = dao.getInstanciasList();
				abrir = "ListUsuario.jsp";
			}

			break;

		}
		request.getSession().setAttribute("usuarios", usuarios);
		request.setAttribute("cidades", daoCidade.getInstanciasList());

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
