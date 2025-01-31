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
	
	<div class="flex flex-col items-center rounded-lg w-5/6 bg-white self-center p-10 mt-5 shadow-md">
	
	    <table class="w-full text-sm text-left border-collapse">
	        <thead>
	            <tr class="bg-[#02111D] text-white">
	                <th class="px-6 py-4 text-center font-bold rounded-tl-lg">Link Curto</th>
	                <th class="px-6 py-4 text-center font-bold">Link Original</th>
	                <th class="px-6 py-4 text-center font-bold rounded-tr-lg">Ações</th>           
	            </tr>
	        </thead>
	        <tbody>
	            <tr class="bg-gray-50 hover:bg-gray-100 transition-all">
	                <td class="px-6 py-4 border-b border-gray-200 text-center font-medium">Google</td>
	                <td class="px-6 py-4 border-b border-gray-200 text-center font-medium">https://www.google.com/</td>
	                <td class="px-6 py-4 border-b border-gray-200 text-center font-medium space-x-2">
	                    <a class="bg-green-600 px-3 py-2 text-sm text-center font-bold text-white rounded-lg hover:bg-green-500 cursor-pointer transition duration-300">Redirecionar</a> 
	                    <a class="bg-blue-600 px-3 py-2 text-sm text-center font-bold text-white rounded-lg hover:bg-blue-500 cursor-pointer transition duration-300">Editar</a>
	                    <a class="bg-red-600 px-3 py-2 text-sm text-center font-bold text-white rounded-lg hover:bg-red-500 cursor-pointer transition duration-300">Excluir</a>
	                </td>
	            </tr>
	        </tbody>
	    </table>
	</div>
	
</body>
</html>