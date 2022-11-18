import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { PersonaService } from 'src/app/servicios/persona.service';
import { SkillService } from './../../servicios/skill.service';

@Component({
  selector: 'app-new-skill',
  templateUrl: './new-skill.component.html',
  styleUrls: ['./new-skill.component.css']
})
export class NewSkillComponent implements OnInit {
 
  nombreS: string = '';
  imgS: string = '';
  progress: number = 0;
  type: boolean = false;


  constructor(private skillService: SkillService, private personaService: PersonaService, private router: Router) { }

  ngOnInit(): void {
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onCreate():void{
    this.personaService.getPersona().subscribe(data =>{
      
        const sk = new Skill(this.nombreS, this.imgS, this.progress, this.type);
      
        this.skillService.save(sk).subscribe(data =>{
          alert("skill añadida");
          this.router.navigate(['']);
        }, err =>{
          alert("falló");
          this.router.navigate(['']);
        }
        )

    });

    
  }

}
