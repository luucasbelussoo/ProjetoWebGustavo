<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      
     
	<form action="UsuarioServlet" method="post" name="valid">
        <input type="hidden" value="gravar" name="oper" >

		<div class="container">


			<div class="form-group">
				<label>Id</label placeholder="Id" > 
				<input type="text" name="id" readonly="readonly" 
					class="form-control" placeholder="Auto"
					value="${requestScope.usuario.id}">
			</div>

			<div class="form-group">
				<label>Nome</label > <input type="text" name="nome" required
					class="form-control" placeholder="Informe o nome do usuário"
					value="${requestScope.usuario.nome}">
			</div>
			<div class="form-group">
				<label>Loginl</label> <input type="text" name="login" required
					class="form-control" placeholder="Informe seu login de acesso"
					value="${requestScope.usuario.login}">
			</div>
			<div class="form-group">
				<label>Senha</label> <input type="text" name="senha" required
					class="form-control" placeholder="Informe sua senha de acesso"
					value="${requestScope.usuario.senha}">
			</div>
			<div class="form-group">
				<label>Endereço</label> <input type="text" name="endereco" required
					class="form-control" placeholder="Informe seu endereço "
					value="${requestScope.usuario.endereco}">
			</div>
			<div class="form-group">
				<label>Telefone</label> <input type="text" name="telefone" required
					class="form-control" placeholder="Informe seu telefone "
					value="${requestScope.usuario.telefone}">
			</div>
			<div class="form-group">
				<label>CPF</label> <input type="text" name="cpf" required
					class="form-control" placeholder="Informe seu CPF "
					value="${requestScope.usuario.cpf}">
			</div>
			<div class="form-group">
				<label>Cidade</label> 
				
				 <select name="cidade" required class="form-control" placeholder="Informe sua cidade">
				 	<c:forEach var="cidade" items="${requestScope.cidades}"	varStatus="status">
					  <option value="${cidade.id}">${cidade.nome}</option>
					</c:forEach>  
				</select> 

			</div>
			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar" class="btn btn-info pull-center" onclick="location='UsuarioServlet'">
			</div>


		</div>
</body>
</html>