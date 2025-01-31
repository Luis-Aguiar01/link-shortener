<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<jsp:include page="../includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<jsp:include page="./includes/logged-header.jsp" />

	<div class="self-center w-2/3 mt-8 mb-10">
		<h1 class="font-bold text-4xl text-center text-white mt-5 mb-10 leading-relaxed">Encurte o seu link em apenas 1 segundo</h1>
		
		<form action="disconnected.do?action=login-user" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500 ml-2">link</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="link" placeholder="Digite o seu link" required/>
				<button type="submit" class="bg-blue-600 px-3 py-2 text-sm text-center font-bold text-white rounded-lg hover:bg-blue-500 cursor-pointer transition duration-300">Encurtar</button>
			</div>
		</form>

		<div class="text-center text-white mb-10">
			<p class="mb-4">Compartilhe em redes sociais, e-mails ou mensagens de texto.</p>
			<p>Cadastre-se e personalize seu link para facilitar o acesso.</p>
		</div>

		<div class="bg-gray-700 rounded-lg p-6 text-white">
			<h2 class="font-bold text-2xl mb-4">Estatísticas</h2>
			<p>Total de links encurtados: <span class="font-bold">200</span></p>
			<p>Total de cliques: <span class="font-bold">250</span></p>
		</div>

	</div>	
	
	<jsp:include page="../includes/footer.html" />

</body>
</html>