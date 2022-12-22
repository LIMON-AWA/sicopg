var abrirPopUp = document.getElementById('abrir'),
    overlay = document.getElementById('overlay'),
    ventana = document.getElementById('ventana'),
    cerrarPopUp = document.getElementById('cerrar');

abrirPopUp.addEventListener('click', function(){
    overlay.classList.add('active');
    ventana.classList.add('active');
});


cerrarPopUp.addEventListener('click', function(){
    overlay.classList.remove('active');
    ventana.classList.remove('active');
});
