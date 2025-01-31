<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../includes/links.html" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<jsp:include page="./includes/logged-header.jsp" />
	
	<div class="flex flex-col items-center rounded-lg w-5/6 bg-white self-center p-10 mt-5 shadow-lg">
	
	    <a href="application.do?action=flight-register-page" class="add-button">
	        <span class="material-symbols-outlined text-white font-bold">add</span>
	    </a>
	
	    <table class="w-full text-sm text-left border-collapse">
	        <thead>
	            <tr>
	                <th class="bg-[#02111D] text-white border-b border-[#061F34] text-center font-bold py-4 rounded-tl-lg">Link Curto</th>
	                <th class="bg-[#02111D] text-white border-b border-[#061F34] text-center font-bold py-4">Link Original</th>
	                <th class="bg-[#02111D] text-white border-b border-[#061F34] text-center font-bold py-4 rounded-tr-lg">Ações</th>           
	            </tr>
	        </thead>
	        <tbody>
	            <tr class="bg-gray-100 hover:bg-gray-200 transition-all w-full">
	                <td class=" px-4 py-3 border-b border-gray-300 text-center font-medium py-5">Teste</td>
	                <td class=" px-4 py-3 border-b border-gray-300 text-center font-medium py-5">Teste</td>
	                <td class=" px-4 py-3 border-b border-gray-300 text-center font-medium w-1/3 py-5">
		                
		                <a class="bg-green-600 px-4 py-3 text-md text-center font-bold text-white rounded-lg 
							hover:bg-green-500 cursor-pointer transition duration-300">Redirecionar</a> 
		                
		                <a  class="bg-blue-600 px-4 py-3 text-md text-center font-bold text-white rounded-lg 
							hover:bg-blue-500 cursor-pointer transition duration-300">Editar</a>
		                
		                <a  class="bg-red-600 px-4 py-3 text-md text-center font-bold text-white rounded-lg 
							hover:bg-red-500 cursor-pointer transition duration-300">Excluir</a>
	                </td>
	            </tr>
	       
	        </tbody>
	    </table>
	</div>
	
</body>
</html>