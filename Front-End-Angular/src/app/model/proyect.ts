export class Proyect {
    id?: number;
    nombreP: string;
    descripcionP: string;
    urlP: string;
    imgP: string;
    persona_fk: number;

    constructor(
                nombreP: string,
                descripcionP: string,
                urlP: string,
                imgP: string,
                persona_fk: number){
                    
            this.nombreP = nombreP;
            this.descripcionP = descripcionP;
            this.urlP = urlP;
            this.imgP = imgP;
            this.persona_fk = persona_fk;
    }
}
