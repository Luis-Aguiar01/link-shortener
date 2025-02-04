<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contato</title>
<jsp:include page="includes/links.jsp" />
<script type="text/javascript" src="scripts/loading-page.js" defer></script>
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
		
		<div id="loading" class="hidden fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
			<div class="animate-spin rounded-full h-12 w-12 border-t-2 border-b-2 border-blue-500"></div>
			<p class="ml-4 text-white text-2xl">Enviando email...</p>
		</div>

		<div id="successMessage" class="hidden fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
			<span class="material-icons text-[50px] text-green-600 mr-5">check</span>
			<p class="text-white text-2xl">Email enviado com sucesso!</p>
		</div>

		<div id="errorMessage" class="hidden fixed inset-0 flex items-center justify-center bg-black bg-opacity-50">
			<span class="material-icons text-[50px] text-red-600 mr-5">close</span>
			<p class="text-white text-2xl">Falha ao enviar o email.</p>
		</div>
		
		<form id="emailForm" class="w-full flex flex-col sm:w-2/3 mx-auto" enctype="application/x-www-form-urlencoded">
			  <div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
			    <span class="material-icons text-gray-500 ml-2">person</span>
			    <input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="name" placeholder="Nome" required />
			  </div>
			
			  <div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
			    <span class="material-icons text-gray-500 ml-2">email</span>
			    <input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="email" name="email" placeholder="E-mail" required />
			  </div>
			
			  <div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
			    <span class="material-icons text-gray-500 ml-2">subject</span>
			    <input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="subject" placeholder="Assunto" required />
			  </div>
			
			  <div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
			    <span class="material-icons text-gray-500 ml-2">message</span>
			    <textarea class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500 resize-none h-32" name="message" placeholder="Mensagem" required></textarea>
			  </div>
			
			  <button type="submit" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300">
			  	Enviar
			  </button>
		</form>
		
	</div>	
	
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>