<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de Erro</title>
<jsp:include page="includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>
	
	<div class="self-center w-full max-w-3xl px-4 mt-8 mb-10">
		<h1 class="flex items-center justify-center text-2xl font-bold sm:text-4xl text-center text-white mt-5 mb-10 leading-relaxed">
			<span class="material-symbols-outlined text-red-500 text-[40px] mr-5">error</span>
			Erro ao redirecionar.
		</h1>
		
		<div class="text-center text-white mb-10">
			<p class="mb-4 text-md">O link digitado é inválido.</p>
			<p class="mb-4 text-md">Por favor, certifique-se de digitar o link corretamente.</p>
			<p class="text-green-500 text-bold text-md">Exemplo: http://localhost:8080/Link-Shortener/seu-link-personalizado</p>
		</div>

	</div>	
	
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>