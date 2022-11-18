import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from './../model/persona.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private URL = 'https://a-lozano.herokuapp.com/personas/';
  
  constructor(private http: HttpClient) {}
    public getPersona(): Observable<Persona> {
      return this.http.get<Persona>(this.URL+ 'traer/perfil');
      
  }
  public update(id: number, persona: Persona): Observable<any>{
    return this.http.put<any>(this.URL + `update/${id}`, persona);
  }
}
