document.addEventListener('DOMContentLoaded', function() {
	// Seleciona todos os botões de cópia e textos para copiar
	const copyButtons = document.querySelectorAll('.copy-button');
	const feedbackMessage = document.getElementById('feedback-message');

	copyButtons.forEach(button => {
		button.addEventListener('click', () => {
			// Encontra o texto correspondente ao botão clicado
			const textToCopy = button.previousElementSibling.innerText;

			// Copia o texto para a área de transferência
			navigator.clipboard.writeText(textToCopy)
				.then(() => {
					// Exibe a mensagem de feedback
					if (feedbackMessage) {
						feedbackMessage.style.display = 'block';
						setTimeout(() => {
							feedbackMessage.style.display = 'none';
						}, 2000);
					}
				})
				.catch((err) => {
					console.error('Erro ao copiar o link: ', err);
				});
		});
	});
});