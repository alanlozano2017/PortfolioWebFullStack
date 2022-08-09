export class Educacion {
    id?: number;
    nombreE: string;
    tituloE: string;
    descripcionE: string;
    inicioE: number;
    finE: number;
    imgE:string;


    constructor(nombreE: string, tituloE: string, descripcionE: string, 
        inicioE: number, finE: number, imgE:string){
        this.nombreE = nombreE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.imgE = imgE;

    }
}
