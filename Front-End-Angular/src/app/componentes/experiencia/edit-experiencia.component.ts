import { Component, OnInit } from '@angular/core';
import { Experiencia } from './../../model/experiencia';
import { SExperienciaService } from './../../servicios/s-experiencia.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {
  expLab: Experiencia = null;

  constructor(private sExperiencia: SExperienciaService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.sExperiencia.detail(id).subscribe(
      data =>{
        this.expLab = data;
      }, err =>{
        alert("error al modificar experiencia");
        this.router.navigate(['']);
      }
    )

  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.sExperiencia.update(id, this.expLab).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("error al modificar experiencia");
        this.router.navigate(['']);
      }
    )
  }

}
