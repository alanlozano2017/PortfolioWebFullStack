import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EducacionService } from './../../servicios/educacion.service';
import { Educacion } from './../../model/educacion';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {
  nombreE: string = '';
  tituloE: string = '';
  descripcionE: string = '';
  inicioE: number = 0;
  finE: number = 0;
  imgE:string = '';

  constructor(private educacionService: EducacionService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate():void{
    const edu = new Educacion(this.nombreE, this.tituloE, this.descripcionE, this.inicioE, this.finE, this.imgE);
    this.educacionService.save(edu).subscribe(data =>{
      alert("educación añadida");
      this.router.navigate(['']);
    }, err =>{
      alert("falló");
      this.router.navigate(['']);
    }
    )
  }

}
