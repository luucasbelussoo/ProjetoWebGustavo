<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Estados</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
</head>
<body>
	<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
	
	<div class="container">
		<h2>Manutenção de Estados</h2>
		<a href="EstadoServlet?oper=novo" class="btn btn-info pull-right" title="Novo">Novo</a>	
		<p>${requestScope.erro}</p>	
		
		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Nome</th>
				<th>UF</th>
				<th>Alterar</th>
				<th>Excluir</th>

			</thead>

			<c:forEach var="estado" items="${sessionScope.estados}"
				varStatus="status">
				<tr>
					<td>${estado.id}</td>
					<td>${estado.nome}</td>
					<td>${estado.UF}</td>
					<td align="center">
					    <input type="button" value="Alterar" class="btn btn-info pull-center"
						onclick="location='EstadoServlet?oper=alterar&id=${estado.id}';">
					</td>
					<td align="center">
					    <input type="button" value="Excluir" class="btn btn-info pull-center" 
						onclick="if (confirm('Confirma exclusão?')) location='EstadoServlet?oper=excluir&id=${estado.id}';">

					</td>
				</tr>
			</c:forEach>

		</table>
	</div>