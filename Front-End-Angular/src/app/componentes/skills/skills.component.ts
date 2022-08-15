import { Component, OnInit } from '@angular/core';
import { TokenService } from 'src/app/servicios/token.service';
import { PorfolioService } from './../../servicios/porfolio.service';
import { SkillService } from './../../servicios/skill.service';
import { Skill } from './../../model/skill';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skill: Skill[] = [];
  

  constructor( private skillService: SkillService, private tokenService: TokenService) { }

  isLogged = false;
  ngOnInit(): void {
    this.cargarSkill();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }

  cargarSkill():void{
    this.skillService.lista().subscribe(data => {
      this.skill = data
    });
  }

  delete(id?: number):void{
    if(id != undefined){
      this.skillService.delete(id).subscribe(
        data =>{
          this.cargarSkill();
        }, err =>{
          alert("no se pudo borrar la skill");
        }
      )
    }
  }
}
