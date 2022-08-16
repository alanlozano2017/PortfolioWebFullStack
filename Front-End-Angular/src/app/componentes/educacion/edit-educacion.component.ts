import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Educacion } from './../../model/educacion';
import { EducacionService } from './../../servicios/educacion.service';

@Component({
  selector: 'app-edit-educacion',
  templateUrl: './edit-educacion.component.html',
  styleUrls: ['./edit-educacion.component.css']
})
export class EditEducacionComponent implements OnInit {
  educacion: Educacion= null;
  constructor(private educacionService: EducacionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.detail(id).subscribe(
      data =>{
        this.educacion = data;
      }, err =>{
        alert("error al modificar educación");
        this.router.navigate(['']);
      }
    )
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.educacionService.update(id, this.educacion).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("error al modificar educacion");
        this.router.navigate(['']);
      }
    )
  }

}
