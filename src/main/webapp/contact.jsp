<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	var success = request.getParameter("success");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contato</title>
<jsp:include page="includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900 px-2 sm:px-0">
	
	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>

	<div class="self-center sm:w-2/3 mt-8 mb-10 w-full">
		<h1 class="text-xl font-bold sm:text-4xl text-center text-white mt-5 mb-5 leading-relaxed">Tem alguma dúvida ou sugestão?</h1>
		<h1 class="text-xl font-bold sm:text-4xl text-center text-white mt-2 mb-10 leading-relaxed">Entre em contato conosco</h1>
		
		<% if (success != null && Boolean.parseBoolean(success)) { %>
			<p class="text-md text-center sm:text-2xl text-green-500 font-bold mb-10 break-all">Seu email foi enviado com sucesso!</p>
		<% } else if(success != null && !Boolean.parseBoolean(success)) { %>
			<p class="text-md text-center sm:text-2xl text-red-500 font-bold mb-10 break-all">Falha ao enviar o email.</p>
		<% } %>
		
		<form action="disconnected.do?action=question-email" method="POST" class="w-full flex flex-col sm:w-2/3 mx-auto">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="name" placeholder="Nome" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">email</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="email" name="email" placeholder="E-mail" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">subject</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="subject" placeholder="Subject" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
  				<span class="material-icons text-gray-500 ml-2">message</span>
			  	<textarea class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500 resize-none h-32" name="message" placeholder="Mensagem" required></textarea>
			</div>
			
			<input type="submit" value="Enviar" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300">
			
		</form>
		
	</div>	
	
	<jsp:include page="/includes/footer.html" />
	
</body>
</html>