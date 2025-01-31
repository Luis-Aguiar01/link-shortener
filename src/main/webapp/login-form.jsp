<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<jsp:include page="includes/links.html" />
</head>
<%-- <body class="flex flex-col justify-center items-center min-h-screen bg-gradient-to-r from-gray-800 to-gray-900"> --%>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<jsp:include page="/includes/header.jsp" />

	<div class="flex flex-col p-10 w-1/2 bg-white rounded-lg shadow-2xl">
		<h1 class="self-center font-bold text-4xl mb-4 text-gray-800">Login</h1>
		<p class="self-center text-gray-600 mb-10">Por favor, insira suas informações para continuar.</p>
		
		<form action="disconnected.do?action=login-user" method="POST" class="flex flex-col">
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500">mail</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="email" name="email" placeholder="Email" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
				<span class="material-icons text-gray-500">lock</span>
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full placeholder-gray-500" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<div class="flex items-center self-center w-full gap-5 justify-around">
		        <input class="text-md bg-black py-4 px-6 w-1/2 rounded-lg text-white hover:bg-gray-800 cursor-pointer font-bold focus:outline-none focus:ring-2 focus:ring-gray-500 transition duration-300" type="submit" value="Enviar">
    		</div>
		</form>
	</div>
	
</body>
</html>