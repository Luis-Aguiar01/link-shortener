<%@page import="br.edu.ifsp.dsw1.model.entity.Link"%>
<%@page import="br.edu.ifsp.dsw1.model.entity.Access"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Link link = (Link) request.getAttribute("link"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhes do Link</title>
<jsp:include page="/includes/links.jsp" />
</head>
<body class="flex flex-col min-h-screen bg-gradient-to-t from-gray-800 to-gray-900">

	<jsp:include page="./includes/logged-header.jsp" />

	<h1 class="text-2xl font-bold sm:text-3xl text-center text-white mt-10 mb-8 leading-relaxed">
		Acessos ao seu link "<%= link.getShortLink() %>" (<%= link.getListAccess().size() %>)
	</h1>

	<div class="container max-w-3xl w-full mx-auto px-4 mb-20">
		<div class="rounded-lg shadow-lg overflow-hidden">
			
			<div class="overflow-x-auto">
				<table class="w-full min-w-[300px] text-sm text-left border-collapse">
					<thead>
						<tr class="bg-[#02111D] text-white">
							<th class="px-6 py-4 text-center font-bold">IP's</th>         
						</tr>
					</thead>
					<tbody>
					<% 
                   
                    if (link.getListAccess() != null && !link.getListAccess().isEmpty()) {
   
                        for (Access access : link.getListAccess()) {
                    %>
                        <tr class="bg-gray-50 hover:bg-gray-100 transition-all">
                            <td class="px-6 py-4 border-b border-gray-200 text-center font-medium"><%= access.getIp() %></td>
                        </tr>
                    <% 
                        }
                    } else { 
                    %>
                        <tr class="bg-gray-50 hover:bg-gray-100 transition-all">
                            <td class="px-6 py-4 border-b border-gray-200 text-center font-medium">Nenhum acesso registrado</td>
                        </tr>
                    <% 
                    }
                    %>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>

	<jsp:include page="../includes/footer.jsp" />

</body>
</html>