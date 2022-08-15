import { Component, OnInit } from '@angular/core';
import { SExperienciaService } from './../../servicios/s-experiencia.service';
import { Router } from '@angular/router';
import { Experiencia } from './../../model/experiencia';
import { PersonaService } from './../../servicios/persona.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombreE: string = '';
  descripcionE: string = '';
  persona_fk: number = 0;
  constructor(private sExperiencia: SExperienciaService,private personaService: PersonaService, private router: Router) { }

  ngOnInit(): void {
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onCreate():void{
    this.personaService.getPersona().subscribe(data =>{
      this.persona_fk = data.id;
      const expe = new Experiencia(this.nombreE, this.descripcionE,  this.persona_fk);
      this.sExperiencia.save(expe).subscribe(data =>{
        alert("experiencia añadida");
        this.router.navigate(['']);
      }, err =>{
        alert("falló");
        this.router.navigate(['']);
      }
      )

    });

    
  }

  
}
