// Variables
let numeroSecreto = 8;
let numeroUsuario = 0;
let intentosHechos = 1;
let intentosCuantificador = "intento"

numeroUsuario = prompt("Por favor indique un número del 1 al 10.");

while(numeroUsuario != numeroSecreto) {
    numeroUsuario = prompt("Por favor indique un número del 1 al 10.");
    if (numeroUsuario > numeroSecreto) {
        alert("El número secreto es menor.");
    }
    else if (numeroUsuario < numeroSecreto) {
        alert("El número secreto es mayor.");
    }
    intentosHechos++;
}
if (intentosHechos != 1) {
    intentosCuantificador = "intentos";
}
alert(`Acertaste al número (${numeroUsuario}). Te tomó ${intentosHechos} ${intentosCuantificador}.`);
