import { Component, OnInit } from '@angular/core';
import { PorfolioService } from './../../servicios/porfolio.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {


  hard_skillslist:any;
  soft_skillslist:any;

  constructor( private datosPorfolio: PorfolioService) { }

  ngOnInit(): void {
    this.datosPorfolio.obtenerDatos().subscribe(data =>{
      console.log("skills");
      console.log(data.skills);
      this.hard_skillslist=data.skills[0].hard_skills;
      console.log("hard_skillslist");
      console.log(this.hard_skillslist);
      this.soft_skillslist=data.skills[1].soft_skills;
      console.log("soft_skillslist");
      console.log(this.soft_skillslist);
    });
  }
}
