export class Skill {
    id?: number;
    nombreS: string;
    imgS: string;
    progress: number;
    type: boolean;

    
    constructor(
                nombreS: string,
                imgS: string,
                progress: number,
                type: boolean){
            this.nombreS = nombreS;
            this.imgS = imgS;
            this.progress = progress;
            this.type = type;

        }
}

