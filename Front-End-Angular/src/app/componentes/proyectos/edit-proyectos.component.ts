import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyect } from 'src/app/model/proyect';
import { ProyectService } from './../../servicios/proyect.service';

@Component({
  selector: 'app-edit-proyectos',
  templateUrl: './edit-proyectos.component.html',
  styleUrls: ['./edit-proyectos.component.css']
})
export class EditProyectosComponent implements OnInit {
  
  proyect: Proyect = null;

  constructor(private proyectService: ProyectService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.proyectService.detail(id).subscribe(
      data =>{
        this.proyect = data;
      }, err =>{
        alert("error al modificar el proyecto");
        this.router.navigate(['']);
      }
    )
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.proyectService.update(id, this.proyect).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("error al modificar el proyecto");
        this.router.navigate(['']);
      }
    )
  }

}
