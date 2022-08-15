import { Persona } from './persona.model';

export class Educacion {
    id?: number;
    nombreE: string;
    tituloE: string;
    descripcionE: string;
    inicioE: number;
    finE: number;
    imgE:string;
    persona_fk: number;


    constructor(nombreE: string, tituloE: string, descripcionE: string, 
        inicioE: number, finE: number, imgE:string, persona_fk: number ){

            this.nombreE = nombreE;
            this.tituloE = tituloE;
            this.descripcionE = descripcionE;
            this.inicioE = inicioE;
            this.finE = finE;
            this.imgE = imgE;
            this.persona_fk = persona_fk;

    }
}
