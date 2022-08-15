export class Skill {
    id?: number;
    nombreS: string;
    imgS: string;
    progress: number;
    type: boolean;
    persona_fk: number;
    
    constructor(nombreS: string,
                imgS: string,
                progress: number,
                type: boolean,
                persona_fk: number){
                    
            this.nombreS = nombreS;
            this.imgS = imgS;
            this.progress = progress;
            this.type = type;
            this.persona_fk = persona_fk;
        }
}

