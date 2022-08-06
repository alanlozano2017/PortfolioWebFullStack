import { Component, OnInit } from '@angular/core';
import { PorfolioService } from './../../servicios/porfolio.service';


@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {


  experienceList:any;

  constructor( private datosPorfolio: PorfolioService) { }

  ngOnInit(): void {
    this.datosPorfolio.obtenerDatos().subscribe(data =>{
      console.log(data.education);
      this.experienceList=data.experience;
    });
  }
}
