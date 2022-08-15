import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from './../model/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  URL = 'http://localhost:8080/personas/';
  personaIdExport: number = 0;
  constructor(private http: HttpClient) {}
    public getPersona(): Observable<Persona> {
      return this.http.get<Persona>(this.URL+ 'traer/perfil');
      
  }
}
