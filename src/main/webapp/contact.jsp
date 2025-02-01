<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contato</title>
<jsp:include page="includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<jsp:include page="/includes/header.jsp" />

	<div class="self-center w-2/3 mt-8 mb-10">
		<h1 class="font-bold text-4xl text-center text-white mt-5 mb-5 leading-relaxed">Tem alguma dúvida ou sugestão?</h1>
		<h1 class="font-bold text-4xl text-center text-white mt-2 mb-10 leading-relaxed">Entre em contato conosco</h1>
		
		<form action="disconnected.do?action=question-email" method="POST" class="flex flex-col w-2/3 mx-auto">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="link" placeholder="Nome" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">email</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="link" placeholder="E-mail" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
  				<span class="material-icons text-gray-500 ml-2">message</span>
			  	<textarea class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500 resize-none h-32" placeholder="Mensagem" required></textarea>
			</div>
			
			<input type="submit" value="Enviar" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300">
			
		</form>
		
	</div>	
	
	<jsp:include page="/includes/footer.html" />
	
</body>
</html>