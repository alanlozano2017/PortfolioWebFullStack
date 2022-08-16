export class Experiencia {
    id?: number;
    nombreE: string;
    descripcionE: string;
    persona_fk: number;
    constructor(nombreE: string, descripcionE: string, persona_fk: number){
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.persona_fk = persona_fk;
    }
}
