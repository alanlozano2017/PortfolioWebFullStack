

/* función que cambia el estilo del input a visible
toma un valor del texto del párrafo con id "text-acercade"
y lo muestra en consola

*/
function cambiar_parrafo(){

    document.getElementById("edit-acercade").style.display="block";
    let texto = document.getElementById("text-acercade").innerText;
    console.log(texto);
}
//función que cambia el valor de un párrafo a medida que se llena el campo del input
function set_parrafo(valor){
    document.getElementById("text-acercade").innerText=valor;

}

function logMessage(message) {
    console.log(message);
}
//controla si se presionó enter t muestra en consola las teclas
let textarea=document.getElementById("edit-acercade");
textarea.addEventListener('keyup', (e) => {
    logMessage(`Key "${e.key}" released  [event: keydown]`);
if(e.key=="Enter"){
    document.getElementById("edit-acercade").style.display="none";
}

});

//carga el contenido de un archivo de texto y lo muestra en el parrafo

function showFile(input){
    let file = input.files[0];
    alert(`nombre de archivo: ${file.name}`) // archivo.txt
    alert(`última modificación: ${file.lastModified}`)

    let reader = new FileReader();
    reader.readAsText(file);
    reader.onload = function() {
        console.log(reader.result);
        document.getElementById("text-acercade").innerText=reader.result;
    };
    reader.onerror = function(){
        console.log(reader.error);
    };

}