<%@page import="br.edu.ifsp.dsw1.model.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	var message = request.getAttribute("message");
	var success = (Boolean) request.getAttribute("success");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Links Personalizados</title>
<jsp:include page="../includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900 px-2 sm:px-0">
	
	<jsp:include page="./includes/logged-header.jsp" />
	
	<div class="flex-1 flex items-center justify-center">
		<div class="w-full self-center sm:w-2/3 mt-8 mb-20">
			<h1 class="text-3xl font-bold sm:text-4xl text-center text-white mt-5 mb-10 leading-relaxed">Crie o seu link personalizado</h1>
			
			<form action="logged.do?action=custom-link" method="POST" class="flex flex-col">
			<% if (message != null && success != null) {
				if (success) {
			%>
				<div class="self-center justify-self-start mb-5 text-green-700 text-xl">
					<%= message %>
				</div>
			<%  } else { %>
				<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
					<%= message %>
				</div>
				
			<%  }  %>
			<% } %>
				<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
					<span class="material-icons text-gray-500">link</span>
					<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="full-link" placeholder="Digite o link completo" required/>
				</div>
				
				<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
					<span class="material-icons text-gray-500">link</span>
					<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="custom-link" placeholder="Digite o seu link personalizado" minlength="5" maxlength="10" required/>
				</div>
			
				<input type="submit" value="Gerar" class="bg-green-600 px-10 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 self-center">
			</form>
		</div>	
	</div>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>