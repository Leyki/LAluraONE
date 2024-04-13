// 1 - Crea una lista vacía llamada "listaGenerica".

let listaGenerica = [];

// 2 - Crea una lista de lenguajes de programación llamada "lenguagesDeProgramacion con los siguientes elementos: 'JavaScript', 'C', 'C++', 'Kotlin' y 'Python'.

let lenguagesDeProgramacion = ['JavaScript', 'C', 'C++', 'Kotlin','Python'];

// 3 - Agrega a la lista "lenguagesDeProgramacion los siguientes elementos: 'Java', 'Ruby' y 'GoLang'.

lenguagesDeProgramacion.push("Java");
lenguagesDeProgramacion.push("Ruby");
lenguagesDeProgramacion.push("GoLang");

// 4 -Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion.

function printArrayElements(array) {
    for (let val of array) {
        console.log(val);
    }
}

// 5 - Crea una función que muestre en la consola todos los elementos de la lista "lenguagesDeProgramacion en orden inverso.

function printArrayElementsReversed(array) {
    printArrayElements(array.reverse());
}

// 6 - Crea una función que calcule el promedio de los elementos en una lista de números.

function promedioArray(array) {
    promedio = 0;
    for (let val of array) {
        promedio += val;
    }
    return promedio / array.length;
}

// 7 - Crea una función que muestre en la consola el número más grande y el número más pequeño en una lista.

function maximoYMinimoArray(array) {
    maximo = Number.MIN_SAFE_INTEGER;
    minimo = Number.MAX_SAFE_INTEGER;

    for (let val of array) {
        if (val > maximo) maximo = val;
        if (val < minimo) minimo = val;
    }
    console.log(minimo, maximo);
}

// 8 - Crea una función que devuelva la suma de todos los elementos en una lista.

function sumaArray(array) {
    suma = 0;
    for (let val of array) {
        suma += val;
    }
    return suma;
}

// 9 - Crea una función que devuelva la posición en la lista donde se encuentra un elemento pasado como parámetro, o -1 si no existe en la lista.

function encontrarValorArray(array, valor) {
    index = -1;
    for (let i in array) {
        if (array[i] == valor) index = parseInt(i);
    }
    return index;
}

// 10 - Crea una función que reciba dos listas de números del mismo tamaño y devuelva una nueva lista con la suma de los elementos uno a uno.

    function sumarArrays(array1, array2) {
        if (array1.length != array2.length) return -1;
        sumaArray = array1;

        for (let i in array2) {
            sumaArray[i] += array2[i];
        }
        return sumaArray;
    }

// 11 - Crea una función que reciba una lista de números y devuelva una nueva lista con el cuadrado de cada número.

function cuadrarArray(array) {
    for (let i in array) {
        array[i] = array[i] * array[i];
    }
    return array;
}
