import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyect } from './../model/proyect';


@Injectable({
  providedIn: 'root'
})
export class ProyectService {
  
  private expURL = 'https://a-lozano.herokuapp.com/proyecto/';

  constructor(private httpClient: HttpClient) { }

  public lista(): Observable<Proyect[]>{
    return this.httpClient.get<Proyect[]>(this.expURL + 'lista');
  }

  public detail(id: number): Observable<Proyect>{
    return this.httpClient.get<Proyect>(this.expURL + `detail/${id}`);
  }

  public save(proyect:  Proyect): Observable<any>{
    return this.httpClient.post<any>(this.expURL + 'create/', proyect );
  }

  public update(id: number, proyect: Proyect): Observable<any>{
    return this.httpClient.put<any>(this.expURL + `update/${id}`, proyect);
  }
  
  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.expURL + `delete/${id}`);
  }
}
