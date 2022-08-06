import { Component, OnInit } from '@angular/core';
import { PorfolioService } from './../../servicios/porfolio.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  proyectoslist:any;

  constructor( private datosPorfolio: PorfolioService) { }

  ngOnInit(): void {
    this.datosPorfolio.obtenerDatos().subscribe(data =>{
      console.log(data.proyectos);
      this.proyectoslist=data.proyectos;
    });
  }
}
