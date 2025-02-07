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
<script type="text/javascript" src="scripts/copy-link.js" defer></script>
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>

	<div class="flex-1 flex items-center justify-center">
		<div class="w-full max-w-2xl mt-8 mb-10 p-6 bg-gray-700 rounded-lg shadow-lg">
			<h1 class="text-3xl font-bold sm:text-3xl text-center text-white mb-8 leading-relaxed">Encurte o seu link</h1>
		
		<% if (resultLink != null) { %>
				
				<div class="mb-6 p-4 bg-green-100 border-l-4 border-green-500 text-green-700">
					<p>Link gerado com sucesso!</p>
				</div>
				
				<div class="flex items-center justify-between mb-6 p-4 bg-gray-600 rounded-lg">
					<p class="text-to-copy text-md sm:text-lg text-green-400 font-mono break-all font-bold">
						<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + resultLink %>
					</p>
					
					<button class="copy-button" class="text-center" title="Copiar">
						<span class="material-icons text-white hover:text-green-400 transition duration-300 ml-4">content_copy</span>
					</button>
				</div>
				
				<div id="feedback-message" class="hidden justify-center mb-6 text-green-500 text-center">
	        		Link copiado com sucesso!
	    		</div>
	    		
			<%} else if (message != null) { %>
				<div class="mb-6 p-4 bg-red-100 border-l-4 border-red-500 text-red-700">
					<p><%= message %></p>
				</div>
			<%} %>
			
			<form action="disconnected.do?action=shorten-link" method="POST" class="space-y-6">
				<div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
					<span class="material-icons text-gray-400 ml-3">link</span>
					<input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="text" name="link" placeholder="Digite o link completo" required/>
				</div>
				
				<button type="submit" class="w-full bg-green-600 px-6 py-3 text-lg font-bold text-white rounded-lg hover:bg-green-500 transition duration-300">
					Gerar
				</button>
			</form>
		</div>	
	</div>
	
	<div class="text-center text-white mb-5">
		<p class="mb-4 text-lg">Compartilhe em redes sociais, e-mails ou mensagens de texto.</p>
		<p class="text-lg">Cadastre-se e personalize seu link para facilitar o acesso.</p>
	</div>

	<div class="text-center mt-5 mb-10">
		<a href="disconnected.do?action=register-page" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 w-full sm:w-auto block sm:inline-block">Cadastre-se para mais funcionalidades</a>
	</div>	

	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>