let numeroSecreto;
let intentos;
//let intentosMaximos = 3;
console.log(numeroSecreto);

function condicionesIniciales() {
    asignarTextoElemento("h1", "Juego del número secreto");
    asignarTextoElemento("p", "Indica un número del 1 al 10.");
    numeroSecreto = randomIntRango(1, 10);
    intentos = 1;
}

function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
}

function randomIntRango(bajo, alto) {
    return bajo + Math.floor(Math.random() * (alto-bajo+1));
}

function limpiarCaja() {
    document.querySelector("#valorUsuario").value = "";
}

function reiniciarJuego() {
    limpiarCaja();
    condicionesIniciales();
    document.getElementById("reiniciar").setAttribute("disabled", "");
}

function verificarIntento() {
    let input = parseInt(document.getElementById("valorUsuario").value);

    if (input === numeroSecreto) {
        asignarTextoElemento("p", `Acercaste al número secreto en ${intentos} ${intentos === 1 ? "intento" : "intentos"}!`);
        document.getElementById("reiniciar").removeAttribute("disabled")
    }
    else {
        limpiarCaja();
        if (numeroSecreto > input) {
            asignarTextoElemento("p", "El número secreto es mayor");
        }
        else {
            asignarTextoElemento("p", "El número secreto es menor");
        }
        intentos++;
        console.log(intentos);
    }
}

condicionesIniciales();
