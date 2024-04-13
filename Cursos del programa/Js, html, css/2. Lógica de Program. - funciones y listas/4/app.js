let numeroSecreto;
let numeroSecretoMaximo = 10;
let numerosSorteados = [];
let intentos;
//let intentosMaximos = 3;

function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
}

function limpiarCaja() {
    document.querySelector("#valorUsuario").value = "";
}

function randomIntRango(bajo, alto) { // inclusivo
    return bajo + Math.floor(Math.random() * (alto-bajo+1));
}

function condicionesIniciales() {
    asignarTextoElemento("h1", "Juego del número secreto");
    asignarTextoElemento("p", `Indica un número del 1 al ${numeroSecretoMaximo}.`);
    numeroSecreto = generarNumeroSecreto();
    console.log(numeroSecreto)
    intentos = 1;
}

function generarNumeroSecreto() {
    let numero = randomIntRango(1, numeroSecretoMaximo);
    if (numerosSorteados.includes(numero)) numero = generarNumeroSecreto();
    else numerosSorteados.push(numero);
    
    console.log(numero);
    console.log(numerosSorteados);
    if (numerosSorteados.length == numeroSecretoMaximo) numerosSorteados = [];
    return numero;
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
    }
}

condicionesIniciales();
