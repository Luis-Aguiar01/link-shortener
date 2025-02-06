<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	var resultLink = request.getAttribute("result_link");
	var message = request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<jsp:include page="includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>

	<div class="self-center w-full max-w-3xl px-4 mt-8 mb-10">
		<h1 class="text-2xl font-bold sm:text-4xl text-center text-white mt-5 mb-10 leading-relaxed">Encurte o seu link em apenas 1 segundo</h1>
		
		<form action="disconnected.do?action=shorten-link" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">link</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="link" placeholder="Digite o seu link" required/>
				<button type="submit" class="hidden sm:block bg-blue-600 px-3 py-2 text-sm text-center font-bold text-white rounded-lg hover:bg-blue-500 cursor-pointer transition duration-300">Encurtar</button>
			</div>
			<button type="submit" class="sm:hidden bg-blue-600 px-3 py-2 mb-5 text-sm text-center font-bold text-white rounded-lg hover:bg-blue-500 cursor-pointer transition duration-300">Encurtar</button>
		</form>
		
		<%if(resultLink != null) { %>
			<p class="text-md text-center sm:text-lg text-green-500 font-bold mb-10 break-all">Seu link: <%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + resultLink %></p>
		<%} else if(message != null) { %>
			<p class="text-md text-center sm:text-lg text-red-500 font-bold mb-10 break-all"><%= message %></p>
		<%} %>
		<div class="text-center text-white mb-10">
			<p class="mb-4">Compartilhe em redes sociais, e-mails ou mensagens de texto.</p>
			<p>Cadastre-se e personalize seu link para facilitar o acesso.</p>
		</div>

		<div class="text-center mt-10">
			<a href="disconnected.do?action=register-page" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 w-full sm:w-auto block sm:inline-block">Cadastre-se para mais funcionalidades</a>
		</div>
	</div>	
	
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>