<%@page import="br.edu.ifsp.dsw1.model.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	var message = request.getAttribute("message");
	var success = (Boolean) request.getAttribute("success");
	var customLink = request.getAttribute("custom-link");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Links Personalizados</title>
<jsp:include page="../includes/links.jsp" />
<script type="text/javascript" src="scripts/copy-link.js" defer></script>
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900 px-2 sm:px-0">
	
	<jsp:include page="./includes/logged-header.jsp" />
	
	<div class="flex-1 flex items-center justify-center">
		<div class="w-full max-w-2xl mt-8 mb-20 p-6 bg-gray-700 rounded-lg shadow-lg">
			<h1 class="text-3xl font-bold sm:text-3xl text-center text-white mb-8 leading-relaxed">Personalize o seu link</h1>
			
			<% if (message != null && success != null) {
				if (success) {
			%>	
				<div class="mb-6 p-4 bg-green-100 border-l-4 border-green-500 text-green-700">
					<p><%= message %></p>
				</div>
				
				<div class="flex items-center justify-between mb-6 p-4 bg-gray-600 rounded-lg">
					<p class="text-md sm:text-lg text-green-400 font-mono break-all font-bold" id="text-to-copy">
						<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/" + customLink %>
					</p>
					<button id="copy-button" class="text-center" title="Copiar">
						<span class="material-icons text-white hover:text-green-400 transition duration-300 ml-4">content_copy</span>
					</button>
				</div>
				
				<div id="feedback-message" class="hidden justify-center mb-6 text-green-500 text-center">
	        		Texto copiado com sucesso!
	    		</div>
			
			<%  } else { %>
				<div class="mb-6 p-4 bg-red-100 border-l-4 border-red-500 text-red-700">
					<p><%= message %></p>
				</div>
			<%  }  %>
			<% } %>
			
			<form action="logged.do?action=custom-link" method="POST" class="space-y-6">
				<div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
					<span class="material-icons text-gray-400 ml-3">link</span>
					<input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="text" name="full-link" placeholder="Digite o link completo" required/>
				</div>
				
				<div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
					<span class="material-icons text-gray-400 ml-3">link</span>
					<input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="text" name="custom-link" placeholder="Digite o seu link personalizado" minlength="5" maxlength="12" pattern="[a-zA-Z0-9_]{5,12}" required/>
				</div>
			
				<button type="submit" class="w-full bg-green-600 px-6 py-3 text-lg font-bold text-white rounded-lg hover:bg-green-500 transition duration-300">
					Gerar
				</button>
			</form>
		</div>	
	</div>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>