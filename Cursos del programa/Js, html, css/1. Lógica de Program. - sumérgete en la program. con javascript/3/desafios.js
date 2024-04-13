// 1 - Crea un contador que comience en 1 y vaya hasta 10 usando un bucle 'while'. Muestra cada número.

let cuenta = 0;
while (cuenta < 10) {
    cuenta++;
    console.log(cuenta);
}

// 2 - Crea un contador que comience en 10 y vaya hasta 0 usando un bucle 'while'. Muestra cada número.

cuenta = 10;
while (cuenta > 0) {
    cuenta--;
    console.log(cuenta);
}

// 3 - Crea un programa de cuenta regresiva. Pide un número y cuenta desde 0 hasta ese número utilizando un bucle 'while' en la consola del navegador.

cuenta = prompt("Otorgue un número para realizar la cuenta regresiva");

while (cuenta > 0) {
    cuenta--;
    console.log(cuenta);
}
