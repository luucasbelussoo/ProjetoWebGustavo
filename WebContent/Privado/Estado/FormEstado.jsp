<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
</head>
<body>

	<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>

	<p>${requestScope.erro}</p>
	<form action="EstadoServlet" method="post" name="valid">
		<input type="hidden" value="gravar" name="oper">

		<div class="container">


			<div class="form-group">
				<label>Id</label> <input type="text" name="id" readonly="readonly"
					class="form-control" placeholder="Auto"
					value="${requestScope.estado.id}">
			</div>

			<div class="form-group">
				<label>Nome</label> <input type="text" name="nome"
					required class="form-control"
					placeholder="Informe o nome do estado!"
					value="${requestScope.estado.nome}">
			</div>
			
			<div class="form-group">
				<label>UF</label> <input type="text" name="uf"
					required class="form-control"
					placeholder="Informe o UF do estado!"
					value="${requestScope.estado.UF}">
			</div>


			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar"
					class="btn btn-info pull-center" onclick="location='EstadoServlet'">
			</div>


		</div>
</body>

</body>
</html>