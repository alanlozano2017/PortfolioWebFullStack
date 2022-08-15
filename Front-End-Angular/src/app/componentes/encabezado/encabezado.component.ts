import { Component, OnInit } from '@angular/core';
import { PorfolioService } from 'src/app/servicios/porfolio.service';
import { Persona } from './../../model/persona.model';
import { PersonaService } from './../../servicios/persona.service';


@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
  
})
export class EncabezadoComponent implements OnInit {
  
  persona: Persona = new Persona(0,"","","","","","","");

  constructor( public personaService: PersonaService) { }

  ngOnInit(): void {
   
    this.personaService.getPersona().subscribe(data =>{
      this.persona = data;
    });
  }

}
