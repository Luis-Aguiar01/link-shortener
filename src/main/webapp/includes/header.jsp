<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="flex p-6 items-center">
  <div class="flex items-center text-white justify-evenly w-full">

    <button id="menu-button" class="lg:hidden focus:outline-none">
      <span class="material-icons text-4xl">menu</span>
    </button>

    <a href="disconnected.do?action=home" class="hidden lg:flex items-center ml-10 gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl font-bold">
      <span class="material-icons text-4xl">home</span>
      <span>Home</span>
    </a>
     <a href="disconnected.do?action=statistics" class="hidden lg:flex items-center ml-10 gap-2 border-b-2 border-transparent hover:border-white pb-1 text-xl font-bold">
      <span class="material-icons text-4xl">equalizer</span>
      <span>Estatísticas</span>
    </a>

    <div class="hidden lg:flex">
      <a href="disconnected.do?action=login-page" 
        class="bg-blue-600 px-6 py-4 mr-4 text-md text-center font-bold text-white 
        rounded-lg hover:bg-blue-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-blue-400 transition duration-300">
        Login
      </a>
      <a href="disconnected.do?action=register-page" 
        class="bg-green-600 px-4 py-4 ml-4 text-md text-center font-bold text-white 
        rounded-lg hover:bg-green-500 cursor-pointer focus:outline-none focus:ring-2 focus:ring-green-400 transition duration-300">
        Cadastrar
      </a>
    </div>
  </div>
</header>

<div id="mobile-menu" class="lg:hidden hidden bg-gray-800 text-white w-full p-4">
  <a href="disconnected.do?action=home" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">home</span>
    <span>Home</span>
  </a>
  <a href="disconnected.do?action=login-page" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">login</span>
    <span>Login</span>
  </a>
  <a href="disconnected.do?action=register-page" class="block py-2 hover:text-gray-300 transition duration-300">
    <span class="material-icons">how_to_reg</span>
    <span>Cadastrar</span>
  </a>
</div>

<script>
  const menuButton = document.getElementById('menu-button');
  const mobileMenu = document.getElementById('mobile-menu');

  menuButton.addEventListener('click', () => {
    mobileMenu.classList.toggle('hidden');
  });
</script>