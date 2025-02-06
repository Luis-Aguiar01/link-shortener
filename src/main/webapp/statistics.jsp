<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% var countLinks = request.getAttribute("countLink");
	var countAccess = request.getAttribute("countAccess");
	
	if(countAccess == null || countLinks == null){
		response.sendRedirect("disconnected.do?action=statistics");
	}
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Statistics</title>
<jsp:include page="includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>

	
	<div class="flex-1 flex items-center justify-center">
		<div class="self-center w-full max-w-3xl px-4 mt-8 mb-10">
			<h1 class="text-2xl font-bold sm:text-4xl text-center text-white mt-5 mb-10 leading-relaxed">Nossas Estatísticas</h1>
			<div class="bg-gray-700 rounded-lg p-4 sm:p-6 text-white">
				<h2 class="font-bold text-2xl mb-4">Estatísticas</h2>
				<p>Total de links encurtados: <span class="font-bold"><%= (Long) countLinks %></span></p>
				<p>Total de cliques: <span class="font-bold"><%=(Long)countAccess %></span></p>
			</div>
				<div class="text-center mt-10">
					<a href="disconnected.do?action=register-page" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 w-full sm:w-auto block sm:inline-block">Cadastre-se para mais funcionalidades</a>
				</div>		
			</div>	
	</div>	
	

     <jsp:include page="/includes/footer.jsp" />

</body>
</html>