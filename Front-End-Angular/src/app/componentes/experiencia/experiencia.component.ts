import { Component, OnInit } from '@angular/core';
import { PorfolioService } from './../../servicios/porfolio.service';
import { SExperienciaService } from './../../servicios/s-experiencia.service';
import { TokenService } from './../../servicios/token.service';
import { Experiencia } from './../../model/experiencia';



@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  expe: Experiencia[] = [];

 

  constructor( private sExperiencia: SExperienciaService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {

    this.cargarExperiencia();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarExperiencia():void{
    this.sExperiencia.lista().subscribe(data => {
      this.expe = data
    });
  }

  delete(id?: number):void{
    if(id != undefined){
      this.sExperiencia.delete(id).subscribe(
        data =>{
          this.cargarExperiencia();
        }, err =>{
          alert("no se pudo borrar la experiencia");
        }
      )
    }
  }

}


