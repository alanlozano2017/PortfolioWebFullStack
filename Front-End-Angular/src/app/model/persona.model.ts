export class Persona {
    id?: number
    nombre: string;
    tituloP: string;
    descripcionP: string;
    apellido: string;
    img: string;
    pais: string;
    ubicacion:string
    constructor(
                id: number,
                nombre: string,
                apellido: string,
                tituloP: string,
                descripcionP: string,
                img: string,
                pais: string,
                ubicacion:string
                ){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.img = img;
        this.pais = pais;
        this.ubicacion = ubicacion;

    }
}
