let numeroSecreto = randomIntRango(1, 10);

function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
}

function randomIntRango(bajo, alto) {
    return bajo + Math.floor(Math.random() * (alto-bajo+1));
}

function verificarIntento() {
    let input = parseInt(document.getElementById("valorUsuario").value);
    console.log(typeof(input));
    console.log(input);
    console.log(numeroSecreto);
    console.log(input === numeroSecreto);
}

asignarTextoElemento("h1", "Juego del número secreto");
asignarTextoElemento("p", "Indica un número del 1 al 10.");
