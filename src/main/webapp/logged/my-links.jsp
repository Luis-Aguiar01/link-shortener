<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Meus Links</title>
<jsp:include page="../includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">
	
	<jsp:include page="./includes/logged-header.jsp" />
	
	<h1 class="font-bold text-4xl text-center text-white mt-10 mb-8 leading-relaxed">Meus Links &#128279;</h1>
	
	<div class="container mx-auto px-4 max-w-7xl mb-20">
		<div class="rounded-lg shadow-lg overflow-hidden">
			
			<!-- SCROLL HORIZONTAL PARA TELAS PEQUENAS -->
			<div class="overflow-x-auto">
				<table class="w-full min-w-[600px] text-sm text-left border-collapse">
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
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium break-words">
								<a href="https://www.google.com/" target="_blank" class="text-blue-500 hover:text-blue-400 transition duration-300">
									https://www.google.com/
								</a>
							</td>
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium flex flex-wrap justify-center gap-4">
								<a href="#" title="Editar">
									<span class="material-icons text-blue-500 hover:text-blue-400 transition duration-300">edit</span>
								</a> 
								<a href="#" title="Excluir">
									<span class="material-icons text-red-500 hover:text-red-400 transition duration-300">delete</span>
								</a> 
								<a href="#" title="Detalhes">
									<span class="material-icons text-gray-500 hover:text-gray-400 transition duration-300">info</span>
								</a> 
							</td>
						</tr>
						<tr class="bg-gray-50 hover:bg-gray-100 transition-all">
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium">Google</td>
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium break-words">
								<a href="https://www.google.com/" target="_blank" class="text-blue-500 hover:text-blue-400 transition duration-300">
									https://www.google.com/
								</a>
							</td>
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium flex flex-wrap justify-center gap-4">
								<a href="#" title="Editar">
									<span class="material-icons text-blue-500 hover:text-blue-400 transition duration-300">edit</span>
								</a> 
								<a href="#" title="Excluir">
									<span class="material-icons text-red-500 hover:text-red-400 transition duration-300">delete</span>
								</a> 
								<a href="#" title="Detalhes">
									<span class="material-icons text-gray-500 hover:text-gray-400 transition duration-300">info</span>
								</a> 
							</td>
						</tr>
						<tr class="bg-gray-50 hover:bg-gray-100 transition-all">
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium">Google</td>
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium break-words">
								<a href="https://www.google.com/" target="_blank" class="text-blue-500 hover:text-blue-400 transition duration-300">
									https://www.google.com/
								</a>
							</td>
							<td class="px-6 py-4 border-b border-gray-200 text-center font-medium flex flex-wrap justify-center gap-4">
								<a href="#" title="Editar">
									<span class="material-icons text-blue-500 hover:text-blue-400 transition duration-300">edit</span>
								</a> 
								<a href="#" title="Excluir">
									<span class="material-icons text-red-500 hover:text-red-400 transition duration-300">delete</span>
								</a> 
								<a href="#" title="Detalhes">
									<span class="material-icons text-gray-500 hover:text-gray-400 transition duration-300">info</span>
								</a> 
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>