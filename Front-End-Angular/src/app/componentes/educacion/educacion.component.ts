import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { PorfolioService } from 'src/app/servicios/porfolio.service';
import { TokenService } from 'src/app/servicios/token.service';
import { Educacion } from './../../model/educacion';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

educacion: Educacion[] = [];

  constructor( private educacionService: EducacionService, private tokenService: TokenService) { }

  isLogged = false;
  ngOnInit(): void {
    this.cargarEducacion();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarEducacion():void{
    this.educacionService.lista().subscribe(data => {
      this.educacion = data
    });
  }

  delete(id?: number):void{
    if(id != undefined){
      this.educacionService.delete(id).subscribe(
        data =>{
          this.cargarEducacion();
        }, err =>{
          alert("no se pudo borrar la educación");
        }
      )
    }
  }



}
