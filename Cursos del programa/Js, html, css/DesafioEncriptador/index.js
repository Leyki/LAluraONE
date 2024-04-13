// Encript / Decript
const Normal = [
    "i",
    "e",
    "a",
    "o",
    "u"
];
const Encriptado = [
    "imes",  // i
    "enter", // e - imes
    "ai",    // a
    "ober",  // o
    "ufat"   // u
];
// i - we can form imes with enter and ai so imes must be parsed before enter or ai must be parsed before imes
const EncriptacionLen = Encriptado.length

function procesarRegla(char, de, a) { // rename
    for (i in de) {
        if (val == de[i]) return a[i];
    }
    return char;
}
function encriptar(texto) {
    let resultado = "";
    for (val of texto) {
        val.char()
        resultado += procesarRegla(val, Normal, Encriptado);
    }
    return resultado;
}

function desencriptar(texto) {
    for (let i = 0; i < EncriptacionLen; i++) {
        texto = texto.replace(Encriptado, Normal[i]);
        console.log(texto)
    }
    return texto;
}

const Essexdachis = document.getElementById("essexdachis");

let rgb = [0, 64, 128];
let rgbDirection = [true, true, true];
const RgbMaxValue = 128;
const RgbMinValue = 0;

function rainbowMask() {
    for (let i in rgb) {
        if (rgb[i] == RgbMaxValue) rgbDirection[i] = false;
        if (rgb[i] == RgbMinValue) rgbDirection[i] = true;
        rgb[i] += rgbDirection[i] ? 1 : -1;
    }
    // Essexdachis.style.background = `rgb(${rgb[0]} ${rgb[1]} ${rgb[2]}`;
}

function each32Tasks() {
    rainbowMask();
}

function updateButton() {
    
}

let button = document.getElementById("miku");

button.addEventListener("click", updateButton);


const Each32Tasks = setInterval(each32Tasks, 1000/32);
