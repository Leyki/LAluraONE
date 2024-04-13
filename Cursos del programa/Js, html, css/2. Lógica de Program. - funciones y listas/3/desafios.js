// 1 - Crea una función que calcule el índice de masa corporal (IMC) de una persona a partir de su altura en metros y peso en kilogramos, que se recibirán como parámetros.

function calcularIMC(peso, altura) {
    return peso / altura ^ 2;
}

// 2 - Crea una función que calcule el valor del factorial de un número pasado como parámetro.

function calcularValFactorial(factorial) {
    let resultado = 1;
    for (let i = 1; i < factorial; i++) {
        resultado += resultado * i;
    }
    return resultado;
}

// 3 - Crea una función que convierta un valor en dólares, pasado como parámetro, y devuelva el valor equivalente en reales(moneda brasileña,si deseas puedes hacerlo con el valor del dólar en tu país). Para esto, considera la cotización del dólar igual a R$4,80.

function dolarAReales(cantidad) {
    return cantidad * 4.8;
}

// 4 - Crea una función que muestre en pantalla el área y el perímetro de una sala rectangular, utilizando la altura y la anchura que se proporcionarán como parámetros.


function crearRectangulo(ancho, altura) { // todo
    let rect = "";
    let rectHeadFooter = "";
    let rectBody = "";
    
    for (let i = 0; i < ancho; i++) {
        rectHeadFooter += "X";
    }
    for (let i = 0; i < ancho; i++) {
        if (i == 0 || i == ancho-1) rectBody += "X";
        else rectBody += " ";
    }
    rectHeadFooter += "\n";
    rectBody += "\n";

    for (let i = 0; i < altura; i++) {
        if (i == 0 || i == altura-1) rect += rectHeadFooter;
        else rect += rectBody;
    }
    return rect;
}
console.log(crearRectangulo(5, 5));

// 5 - Crea una función que muestre en pantalla el área y el perímetro de una sala circular, utilizando su radio que se proporcionará como parámetro. Considera Pi = 3,14.

function crearCirculo(radio) {
    let circulo = "";
    return circulo;
}
console.log(crearCirculo(5))


// 6 - Crea una función que muestre en pantalla la tabla de multiplicar de un número dado como parámetro.


function generarTablaDeMultiplicar(numero, extension = 10) {
    for (let i = 1; i < extension; i++) {
        console.log(`${numero} x ${i} = ${numero * i}`);
    }
}
