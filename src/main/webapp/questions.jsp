<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dúvidas</title>
<jsp:include page="includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900 px-1 sm:px-0">
	
	<% if (session != null && session.getAttribute("user") != null) { %>
		<jsp:include page="/logged/includes/logged-header.jsp" />
	<% } else { %>
		<jsp:include page="/includes/header.jsp" />
	<% } %>
	
	<div class="self-center sm:w-2/3 mt-8 mb-10 w-full">
		<h1 class="flex items-center justify-center font-bold text-4xl text-center text-white mt-5 mb-10 leading-relaxed">
			<span class="material-symbols-outlined text-[30px] mr-5">help</span>
			Dúvidas Frequentes
		</h1>
		
		<div class="text-center text-white mb-10">
			<p class="mb-4">Encontre respostas para as perguntas mais comuns abaixo.</p>
			<p>Se precisar de mais ajuda, entre em contato conosco.</p>
		</div>

		<div class="space-y-4">
			<div>
				<h2 class="text-center sm:text-start font-bold text-2xl text-white mb-4">Cadastro e Conta</h2>
				<div class="bg-gray-700 rounded-lg p-4">
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Como faço para me cadastrar?</summary>
						<p class="text-gray-300 mt-2">Clique em "Cadastre-se" no menu superior e preencha o formulário com seus dados.</p>
					</details>
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Esqueci minha senha. O que fazer?</summary>
						<p class="text-gray-300 mt-2">Clique em "Esqueci minha senha" na página de login e siga as instruções para redefinição.</p>
					</details>
				</div>
			</div>

			
			<div>
				<h2 class="text-center sm:text-start font-bold text-2xl text-white mb-4">Uso do Serviço</h2>
				<div class="bg-gray-700 rounded-lg p-4">
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Como personalizo meu link?</summary>
						<p class="text-gray-300 mt-2">Após o cadastro, acesse a seção "Personalizar" e crie o link desejado.</p>
					</details>
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Como edito o meu link?</summary>
						<p class="text-gray-300 mt-2">Após o cadastro, acesse a seção "Meus Links" e edite o link desejado.</p>
					</details>
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Eu consigo ver estatísticas de acesso do meu link?</summary>
						<p class="text-gray-300 mt-2">Sim, acesse a seção "Meus Links" e clique no botão de informações para acessar as estatísitcas.</p>
					</details>
					<details class="mb-4">
						<summary class="font-semibold text-white cursor-pointer">Posso compartilhar meu link em redes sociais?</summary>
						<p class="text-gray-300 mt-2">Sim, você pode compartilhar seu link em qualquer plataforma.</p>
					</details>
				</div>
			</div>
		</div>

		
		<div class="text-center mt-10">
			<a href="disconnected.do?action=contact-page" class="bg-green-600 px-6 py-3 text-lg text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300 w-full sm:w-auto block sm:inline-block"">Entre em Contato</a>
		</div>
	</div>	
	
	<jsp:include page="/includes/footer.jsp" />
	
</body>
</html>