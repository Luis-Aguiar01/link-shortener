<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="flex p-6 items-center">
 	<div class="flex flex-col items-center text-white justify-around w-full">
   
	    <button id="menu-button" class="lg:hidden focus:outline-none self-start">
	      <span class="material-icons text-4xl">menu</span>
	    </button>
	
	    <div class="hidden lg:flex items-center justify-around w-full">
		    <a href="logged.do?action=logged-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white hover:text-gray-300 pb-1 text-lg font-bold transition duration-300">
		      <span class="material-icons text-4xl">home</span>
		      <span>Home</span>
		    </a>
	
		      <a href="logged.do?action=custom-link-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold hover:text-gray-300 transition duration-300">
		        <span class="material-icons text-4xl">draw</span>
		        <span>Personalizados</span>
		      </a>
	
		      <a href="logged.do?action=my-links-page" class="flex items-center gap-2 border-b-2 border-transparent hover:border-white pb-1 text-lg font-bold hover:text-gray-300 transition duration-300">
		        <span class="material-icons text-4xl">person</span>
		        <span>Meus Links</span>
		      </a>
	
		      <a href="logged.do?action=logout" class="bg-red-600 px-6 py-4 mr-4 text-md text-center font-bold text-white rounded-lg hover:bg-red-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-blue-400 transition duration-300">
		        Logout
		      </a>
	    </div>
  	</div>
</header>

<div id="mobile-menu" class="lg:hidden hidden bg-gray-800 text-white w-full p-4">
  <a href="logged.do?action=logged-page" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">home</span>
    <span>Home</span>
  </a>

  <a href="logged.do?action=custom-link-page" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">draw</span>
    <span>Personalizados</span>
  </a>

  <a href="logged.do?action=my-links-page" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">person</span>
    <span>Meus Links</span>
  </a>

  <a href="logged.do?action=logout" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">logout</span>
    <span>Logout</span>
  </a>
</div>


<script>
  const menuButton = document.getElementById('menu-button');
  const mobileMenu = document.getElementById('mobile-menu');

  menuButton.addEventListener('click', () => {
    mobileMenu.classList.toggle('hidden');
  });
</script>