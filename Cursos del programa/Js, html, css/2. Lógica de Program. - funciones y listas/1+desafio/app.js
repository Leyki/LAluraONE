/*
Cambia el contenido de la etiqueta h1 con document.querySelector y asigna el siguiente texto: "Hora del Desafío".
Crea una función que muestre en la consola el mensaje "El botón fue clicado" siempre que se presione el botón "Console".
Crea una función que se ejecute cuando se haga clic en el botón "prompt", preguntando el nombre de una ciudad de Brasil. Luego, muestra una alerta con el mensaje concatenando la respuesta con el texto: "Estuve en {ciudad} y me acordé de ti".
Crea una función que muestre una alerta con el mensaje: "Yo amo JS" siempre que se presione el botón "Alerta".
Al hacer clic en el botón "suma", pide 2 números y muestra el resultado de la suma en una alerta.
*/

let titulo = document.querySelector("h1");
titulo.innerHTML = "Hora del Desafío";

function clickBotonConsola () {
    console.log("console");
}
function clickBotonPrompt () {
    alert(`Estuve en ${prompt("Indica alguna ciudad del Brazil")} y me acordé de ti`);
}
function clickBotonAlert () {
    alert("Yo amo JS");
}
function clickBotonSuma () {
    let numeros = prompt("Por favor indica cuantos númeroes gustes separados por un espacio entre cada uno para sumarlos");
    let resultado = 0;
    numeros = numeros.split(" ");
    for (num of numeros) {
        resultado += parseInt(num);
    }
    alert("El resultado de la suma es " + resultado);
}

