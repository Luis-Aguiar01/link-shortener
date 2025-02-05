document.getElementById('emailForm').addEventListener('submit', (event) => {
  event.preventDefault();

  document.getElementById('loading').classList.remove('hidden');

  fetch('disconnected.do?action=question-email', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
    },
    body: new URLSearchParams(new FormData(event.target))
  })
    .then(response => response.json())
    .then(data => {
  
      document.getElementById('loading').classList.add('hidden');

      if (data.success) {
        document.getElementById('successMessage').classList.remove('hidden');
        setTimeout(() => {
          document.getElementById('successMessage').classList.add('hidden');
        }, 2500);
      } else {
        document.getElementById('errorMessage').classList.remove('hidden');
        setTimeout(() => {
          document.getElementById('errorMessage').classList.add('hidden');
        }, 2500);
      }
    })
    .catch(() => {
      document.getElementById('loading').classList.add('hidden');
      document.getElementById('errorMessage').classList.remove('hidden');
      setTimeout(() => {
        document.getElementById('errorMessage').classList.add('hidden');
      }, 2500);
    });
});