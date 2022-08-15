import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { SkillService } from './../../servicios/skill.service';

@Component({
  selector: 'app-edit-skill',
  templateUrl: './edit-skill.component.html',
  styleUrls: ['./edit-skill.component.css']
})
export class EditSkillComponent implements OnInit {
skill: Skill = null;
  constructor( private skillService: SkillService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params['id'];
    this.skillService.detail(id).subscribe(
      data =>{
        this.skill = data;
      }, err =>{
        alert("error al modificar la skill");
        this.router.navigate(['']);
      }
    )
  }
onCancel():void{
  this.router.navigate(['']);
}
  onUpdate(): void{
    const id = this.activatedRoute.snapshot.params['id'];
    this.skillService.update(id, this.skill).subscribe(
      data =>{
        this.router.navigate(['']);
      }, err =>{
        alert("error al modificar la skill");
        this.router.navigate(['']);
      }
    )
  }
}
