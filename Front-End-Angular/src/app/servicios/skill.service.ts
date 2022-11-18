import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Skill } from './../model/skill';
@Injectable({
  providedIn: 'root'
})
export class SkillService {
  
  private expURL = 'https://a-lozano.herokuapp.com/skill/';
  constructor(private httpClient: HttpClient) { }


  public lista(): Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.expURL + 'lista');
  }

  public detail(id: number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.expURL + `detail/${id}`);
  }

  public save(skill:  Skill): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create/', skill );
  }

  public update(id: number, skill: Skill): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, skill);
  }
  
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }
}
