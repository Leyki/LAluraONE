// 1 - Pregunta al usuario qué día de la semana es. Si la respuesta es "Sábado" o "Domingo", muestra "¡Buen fin de semana!". De lo contrario, muestra "¡Buena semana!".
let respuesta = prompt("Qué día es hoy?");

if (respuesta == "Sábado" || respuesta == "Domingo") {
    alert("¡Buena semana!");
}

// 2 - Verifica si un número ingresado por el usuario es positivo o negativo. Muestra una alerta informativa.
respuesta = prompt("Por favor ingresa un número de cualquier tipo.");

if (Number(respuesta) != NaN) {
    if (respuesta < 0) {
        alert("El número es negativo.");
    }
    else {
        alert("El número es positivo.");
    }
}
else {
    alert("No se ha dado un número.");
}

// 3 - Crea un sistema de puntuación para un juego. Si la puntuación es mayor o igual a 100, muestra "¡Felicidades, has ganado!". En caso contrario, muestra "Intenta nuevamente para ganar.".

let puntuacionVictoria = 100;
respuesta = prompt("¿Cuál es su puntaje?");

if (Number(respuesta) != NaN) {
    if (respuesta < puntuacionVictoria) {
        alert("Intenta nuevamente para ganar.");
    }
    else {
        alert("¡Felicidades, has ganado!");
    }
}
else {
    alert("No se ha dado un número.");
}

// 4 - Crea un mensaje que informe al usuario sobre el saldo de su cuenta, utilizando un template string para incluir el valor del saldo.

let SaldoCuenta = 50;
alert(`El saldo actual de tu cuenta es: ${SaldoCuenta}.`);

// 5 - Pide al usuario que ingrese su nombre mediante un prompt. Luego, muestra una alerta de bienvenida usando ese nombre.

let nombre = prompt("¿Cómo es tu nombre?");
alert(`Bienvenido, ${nombre}`);
