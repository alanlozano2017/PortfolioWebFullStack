import { Component, OnInit } from '@angular/core';
import { PersonaService } from './../../servicios/persona.service';
import { Persona } from './../../model/persona.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-edit-encabezado',
  templateUrl: './edit-encabezado.component.html',
  styleUrls: ['./edit-encabezado.component.css']
})
export class EditEncabezadoComponent implements OnInit {

  persona: Persona= null;
  constructor(private personaService: PersonaService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.personaService.getPersona().subscribe(
      data =>{
        this.persona = data;
      }, err =>{
        alert("error al modificar Persona");
        this.router.navigate(['']);
      }
    )
  }
  onCancel():void{
    this.router.navigate(['']);
  }
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.personaService.update(id, this.persona).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("error al modificar Persona");
        this.router.navigate(['']);
      }
    )
  }
}
