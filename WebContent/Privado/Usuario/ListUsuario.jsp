<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
</head>
<body>
	<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
	
	<div class="container">
		<h2>Manutenção de Usuarios</h2>
		<a href="UsuarioServlet?oper=novo" class="btn btn-info pull-right" title="Novo">Novo</a>	
		<p>${requestScope.erro}</p>	
		
		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Nome</th>
				<th>Login</th>
				<th>Endereco</th>
				<th>Telefone</th>
				<th>CPF</th>
				<th>Cidade</th>
				<th>Alterar</th>
				<th>Excluir</th>

			</thead>

			<c:forEach var="usuario" items="${sessionScope.usuarios}"
				varStatus="status">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.login}</td>
					<td>${usuario.endereco}</td>
					<td>${usuario.telefone}</td>
					<td>${usuario.cpf}</td>
					<td>${usuario.cidade.nome}</td> <!-- iMPORTANTE-->
					
					<td align="center">
					    <input type="button" value="Alterar" class="btn btn-info pull-center"
						onclick="location='UsuarioServlet?oper=alterar&id=${usuario.id}';">
					</td>
					<td align="center">
					    <input type="button" value="Excluir" class="btn btn-danger pull-center" 
						onclick="if (confirm('Confirma exclusão?')) location='UsuarioServlet?oper=excluir&id=${usuario.id}';">

					</td>
				</tr>
			</c:forEach>


		</table>
	</div>