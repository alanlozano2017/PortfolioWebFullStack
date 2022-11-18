import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyect } from 'src/app/model/proyect';
import { PersonaService } from 'src/app/servicios/persona.service';
import { ProyectService } from './../../servicios/proyect.service';

@Component({
  selector: 'app-new-proyectos',
  templateUrl: './new-proyectos.component.html',
  styleUrls: ['./new-proyectos.component.css']
})
export class NewProyectosComponent implements OnInit {

    nombreP: string = '';
    descripcionP: string = '';
    urlP: string = '';
    imgP: string = '';
 


  constructor(private proyectService: ProyectService, private personaService: PersonaService, private router: Router) { }


  ngOnInit(): void {
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onCreate():void{
    this.personaService.getPersona().subscribe(data =>{
      
        const pro = new Proyect(this.nombreP, this.descripcionP, this.urlP, this.imgP);
      
        this.proyectService.save(pro).subscribe(data =>{
          alert("proyecto añadido");
          this.router.navigate(['']);
        }, err =>{
          alert("falló");
          this.router.navigate(['']);
        }
        )

    });

    
  }
}
