<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Link</title>
<jsp:include page="../includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<jsp:include page="./includes/logged-header.jsp" />
	
	<div class="flex flex-col p-10 w-1/2 bg-white rounded-lg shadow-2xl self-center mt-10 mb-20">
        <h1 class="self-center font-bold text-3xl mb-10 text-gray-800">Editar Link Personalizado</h1>

        <form action="disconnected.do?action=login-user" method="POST" class="flex flex-col">
 
            <div class="flex items-center border rounded-lg mb-10 bg-gray-100 px-3 hover:bg-gray-200 transition duration-300">
                <span class="material-icons text-gray-500">link</span>
                <input class="px-3 py-4 bg-transparent outline-none w-full placeholder-gray-500" type="text" name="new-link" placeholder="Digite o novo link curto" required/>
            </div>

            <div class="flex items-center self-center w-full gap-5 justify-around">
                <a href="#" class="text-md bg-gray-600 py-4 px-6 w-1/2 rounded-lg text-white hover:bg-gray-500 cursor-pointer font-bold text-center focus:outline-none focus:ring-2 focus:ring-gray-300 transition duration-300">Cancelar</a>
                <input class="text-md bg-blue-600 py-4 px-6 w-1/2 rounded-lg text-white hover:bg-blue-500 cursor-pointer font-bold focus:outline-none focus:ring-2 focus:ring-blue-300 transition duration-300" type="submit" value="Salvar">
            </div>
        </form>
    </div>
	
	<jsp:include page="../includes/footer.html" />
	
</body>
</html>