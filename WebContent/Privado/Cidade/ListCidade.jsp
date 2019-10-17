<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cidades</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
</head>
<body>
	<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>

	<div class="container">
		<h2>Manuten��o de Cidades</h2>
		<a href="CidadeServlet?oper=novo" class="btn btn-info pull-right"
			title="Novo">Novo</a>
		<p>${requestScope.erro}</p>

		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Nome</th>
				<th>Estado</th>
				<th>Alterar</th>
				<th>Excluir</th>

			</thead>

			<c:forEach var="cidade" items="${sessionScope.cidades}"
				varStatus="status">
				<tr>
					<td>${cidade.id}</td>
					<td>${cidade.nome}</td>
					<td>${cidade.estado.nome}</td>
					<!-- iMPORTANTE-->

					<td align="center"><input type="button" value="Alterar"
						class="btn btn-info pull-center"
						onclick="location='CidadeServlet?oper=alterar&id=${cidade.id}';">
					</td>
					<td align="center"><input type="button" value="Excluir"
						class="btn btn-danger pull-center"
						onclick="if (confirm('Confirma exclus�o?')) location='CidadeServlet?oper=excluir&id=${cidade.id}';">

					</td>
				</tr>
			</c:forEach>


		</table>
	</div>