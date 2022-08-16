import { Component, OnInit } from '@angular/core';
import { PorfolioService } from './../../servicios/porfolio.service';
import { Proyect } from './../../model/proyect';
import { TokenService } from 'src/app/servicios/token.service';
import { ProyectService } from './../../servicios/proyect.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  proyect: Proyect[] = [];

  constructor(private proyectService: ProyectService, private tokenService: TokenService) { }

  isLogged = false;


  ngOnInit(): void {
    this.cargarProyecto();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarProyecto():void{
    this.proyectService.lista().subscribe(data => {
      this.proyect = data
    });
  }

  delete(id?: number):void{
    if(id != undefined){
      this.proyectService.delete(id).subscribe(
        data =>{
          this.cargarProyecto();
        }, err =>{
          alert("no se pudo borrar el proyecto");
        }
      )
    }
  }
}
