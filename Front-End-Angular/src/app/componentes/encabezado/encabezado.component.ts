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
  miPorfolio:any={
    experience:[],
    education:[],
    aptitudes:[],
    sobre_mi:[]
  };
  persona: Persona = new Persona("","","");

  constructor( private datosPorfolio: PorfolioService, public personaService: PersonaService) { }

  ngOnInit(): void {
    this.datosPorfolio.obtenerDatos().subscribe(data =>{
      console.log(data);
      this.miPorfolio=data;
    });
    this.personaService.getPersona().subscribe(data =>{
      this.persona = data;
    
    });
  }

}
