<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Links Personalizados</title>
<jsp:include page="../includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<jsp:include page="./includes/logged-header.jsp" />

	<div class="self-center w-2/3 mt-8">
		<h1 class="font-bold text-4xl text-center text-white mt-5 mb-10 leading-relaxed">Crie o seu link personalizado</h1>
		
		<form action="disconnected.do?action=login-user" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<i class="fa-solid fa-link text-gray-500 ml-2"></i>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="full-link" placeholder="Digite o link completo" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<i class="fa-solid fa-user text-gray-500 ml-2"></i>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="custom-link" placeholder="Digite o seu link personalizado" required/>
			</div>
		
			<input type="submit" value="Gerar" class="bg-green-600 px-10 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 self-center">
		</form>
	</div>	
	
	<footer class="bg-gray-900 text-white py-6 mt-10">
		<div class="container mx-auto px-4">
			<div class="flex flex-col justify-between items-center">
				<div class="text-center mb-4">
					<p class="text-sm">&copy; 2025 Encurtador de URL. Todos os direitos reservados.</p>
				</div>
				<div class="flex space-x-5 mt-1">
					<a href="#" class="text-gray-400 hover:text-white transition duration-300">Política de Privacidade</a>
					<a href="#" class="text-gray-400 hover:text-white transition duration-300">Termos de Serviço</a>
					<a href="#" class="text-gray-400 hover:text-white transition duration-300">Contato</a>
				</div>
				<div class="flex space-x-4 mt-3">
					<a href="#" class="text-gray-400 hover:text-white transition duration-300">
						<i class="fab fa-facebook"></i>
					</a>
					<a href="#" class="text-gray-400 hover:text-white transition duration-300">
						<i class="fab fa-instagram"></i>
					</a>
				</div>
			</div>
		</div>
	</footer>
	
</body>
</html>