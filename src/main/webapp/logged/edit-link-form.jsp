<%@page import="br.edu.ifsp.dsw1.model.entity.Link"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% 
	Link link = (Link) request.getAttribute("link");
	var message = request.getAttribute("message");
	var success = (Boolean) request.getAttribute("success");
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Link</title>
<jsp:include page="/includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<jsp:include page="./includes/logged-header.jsp" />
	
	<div class="flex-1 flex items-center justify-center">
        <div class="w-full max-w-2xl mt-8 mb-10 p-6 bg-gray-700 rounded-lg shadow-lg flex flex-col justify-center">
            <h1 class="text-3xl font-bold sm:text-2xl text-center text-white mb-8 leading-relaxed">Editar Link Personalizado</h1>
			
			<% if (link == null) { 
				 response.sendRedirect("logged.do?action=my-links-page"); 
			} else { 
			%>
            
            <form action="logged.do?action=edit-link" method="POST" class="flex flex-col space-y-6">
            <% if (message != null && success != null) {
				if (success) {
			%>
				<div class="self-center justify-self-start mb-5 text-green-500 text-xl">
					<%= message %>
				</div>
			<%  } else { %>
				<div class="self-center justify-self-start mb-5 text-red-500 text-xl">
					<%= message %>
				</div>
				
			<%  }  %>
			<% } %>
                <div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
                    <span class="material-icons text-gray-400 ml-3">link</span>
                    <input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="text" name="short-link" value = "<%= link.getShortLink() %>" minlength="5" maxlength="12" pattern = "[a-zA-Z0-9_]{5,12}" required/>
                </div>
                <div class="flex items-center border border-gray-500 rounded-lg bg-gray-600 hover:bg-gray-500 transition duration-300">
                    <span class="material-icons text-gray-400 ml-3">link</span>
                    <input class="px-4 py-3 bg-transparent outline-none w-full text-white placeholder-gray-400" type="text" name="full-link" value = "<%= link.getFullLink() %>" pattern="(https?|ftp)://[^\s/$.?#].[^\s]*" required/>
                </div>
                <div class="flex items-center self-center w-full gap-5 justify-around">
                    <a href="logged.do?action=my-links-page" class="text-md bg-[#E6A23C] py-4 px-6 w-1/2 rounded-lg text-white hover:bg-[#E6A200] cursor-pointer font-bold text-center focus:outline-none focus:ring-2 focus:ring-gray-300 transition duration-300">Cancelar</a>
                    <input class="text-md bg-blue-600 py-4 px-6 w-1/2 rounded-lg text-white hover:bg-blue-500 cursor-pointer font-bold focus:outline-none focus:ring-2 focus:ring-blue-300 transition duration-300" type="submit" value="Salvar">
                </div>
                
                <input type="hidden" id="id" name="id" value="<%= link.getShortLink() %>">
                
            </form>
            <%}%>
        </div>
    </div>
	
	<jsp:include page="../includes/footer.jsp" />
	
</body>
</html>