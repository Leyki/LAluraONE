// Variables
let numeroSecreto = 8;
let numeroUsuario = prompt("Por favor indique un número del 1 al 10.");

console.log(numeroUsuario);

/*
Lo siguiente realiza la comparación
*/
if (numeroUsuario == numeroSecreto) {
    alert(`Acertaste el número(${numeroUsuario})!`);
}
else {
    alert("El número no es acertado."); 
}
