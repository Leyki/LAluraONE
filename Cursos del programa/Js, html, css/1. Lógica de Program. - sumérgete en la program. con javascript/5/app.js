// Variables
let numeroMaximo = 10;
let intentosMaximos = 3;
let numeroUsuario = 0;
let intentos = 0;

let numeroSecreto = Math.floor(Math.random() * numeroMaximo) + 1;

while(numeroUsuario != numeroSecreto) {
    numeroUsuario = parseInt(prompt(`Por favor indique un número del 1 al ${numeroMaximo}.`));
    if (numeroUsuario > numeroSecreto) {
        alert("El número secreto es menor.");
    }
    else if (numeroUsuario < numeroSecreto) {
        alert("El número secreto es mayor.");
    }
    intentos++;
    if (numeroUsuario == numeroSecreto) {    
        alert(`Acertaste al número (${numeroUsuario}). Te tomó ${intentos} ${intentos == 1 ? "intento" : "intentos"}.`);
    }
    else if (intentos == intentosMaximos) {
        alert(`Llegaste al número de intentos máximo (${intentosMaximos}).`);
        break;
    }
}   

