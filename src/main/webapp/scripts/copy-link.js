const copyButton = document.getElementById('copy-button');
const textToCopy = document.getElementById('text-to-copy');

copyButton.addEventListener('click', () => {
	const text = textToCopy.innerText;
	navigator.clipboard.writeText(text)
        .then(() => {
            const feedbackMessage = document.getElementById('feedback-message');
            feedbackMessage.style.display = 'block';
            setTimeout(() => {
                feedbackMessage.style.display = 'none';
            }, 2000);
        })
        .catch((err) => {
            console.error('Erro ao copiar o texto: ', err);
        });
});
