
 function toggleTheme() {
    const body = document.body;
    const btn = document.getElementById('theme-toggle');
    body.classList.toggle('dark');
    btn.textContent = body.classList.contains('dark') ? 'Light Mode' : 'Dark Mode';
 }
