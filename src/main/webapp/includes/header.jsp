<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="flex p-6 items-center">
	<div class="flex items-center text-white justify-between w-full">
		
		<a href="disconnected.do?action=home" class="flex items-center ml-10 gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl font-bold">
			<span class="material-icons text-4xl">home</span>
			<span>Home</span>
		</a>
		
		<div>
			<a href="disconnected.do?action=login-page" 
				class="bg-blue-600 px-6 py-4 mr-4 text-md text-center font-bold text-white 
				rounded-lg hover:bg-blue-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-blue-400 transition duration-300">
				Login
			</a>
		
			<a href="disconnected.do?action=register-page" 
				class="bg-[#138808] px-4 py-4 ml-4 text-md text-center font-bold text-white 
				rounded-lg hover:bg-green-600 cursor-pointer focus:outline-none focus:ring-2 focus:ring-green-400 transition duration-300">
				Cadastrar
			</a>
		</div>
		
	</div>
</header>