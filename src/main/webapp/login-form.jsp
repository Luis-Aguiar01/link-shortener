<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% var message = request.getAttribute("mensagem"); %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>
	
	<div class="flex-1 flex items-center justify-center">
		<div class="w-full max-w-2xl mt-8 mb-10 p-6 bg-gray-700 rounded-lg shadow-lg flex flex-col justify-center">
			<h1 class="text-3xl font-bold sm:text-3xl text-center text-white mb-8 leading-relaxed">Login</h1>
			
			<% if (message != null) {%>
				<p class="self-center text-red-500 mb-5"><%= message %></p>
			<% } %>
			
			<form action="disconnected.do?action=login-user" method="POST" class="flex flex-col space-y-6">
				
				<div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
					<span class="material-icons text-gray-400 ml-3">mail</span>
					<input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="email" name="email" placeholder="Email" required/>
				</div>
				
				<div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
					<span class="material-icons text-gray-400 ml-3">lock</span>
					<input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="password" name="password" placeholder="Password" required/>
				</div>
				
				<p class="text-white self-center mb-10">Não tem uma conta? <a href="disconnected.do?action=register-page" class="text-blue-400 transition hover:text-blue-300 duration-300">Clique aqui para se registrar.</a></p>
				
				<div class="flex items-center self-center w-full gap-5 justify-around">
			        <input class="text-md bg-blue-600 py-4 px-6 w-1/2 rounded-lg text-white hover:bg-blue-500 cursor-pointer font-bold focus:outline-none transition duration-300" type="submit" value="Enviar">
	    		</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>