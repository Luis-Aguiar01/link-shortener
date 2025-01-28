<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="flex p-6 items-center">
	<div class="flex items-center text-white justify-around w-full">
		
		<a href="disconnected.do?action=home_page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">home</span>
			<span>Home</span>
		</a>
		
		<a href="logged.do?action=register_users_page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">add_circle</span>
			<span>Criar Link</span>
		</a>
		
		<a href="logged.do?action=page_pedidos" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">draw</span>
			<span>Personalizados</span>
		</a>
		
		<a href="logged.do?action=page_pedidos" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">person</span>
			<span>Meus Links</span>
		</a>
		
		<a href="logged.do?action=page_pedidos" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold">
			<span class="material-icons text-4xl">security</span>
			<span>Acessos</span>
		</a>
		
		<a href="logged.do?action=logout" 
			class="bg-red-700 px-4 py-4 text-md text-center font-bold text-white rounded-lg 
			hover:bg-red-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-red-300">
			Logout
		</a>
		
		<a href="disconnected.do?action=login_page" 
			class="bg-blue-600 px-6 py-4 text-md text-center font-bold text-white 
			rounded-lg hover:bg-blue-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-blue-400">
			Login
		</a>
		
		<a href="disconnected.do?action=login_page" 
			class="bg-green-600 px-4 py-4 text-md text-center font-bold text-white 
			rounded-lg hover:bg-green-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-green-400">
			Cadastrar
		</a>
	</div>
</header>