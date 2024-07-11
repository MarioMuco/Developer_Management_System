import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Developer } from '../interface/Developer';

@Injectable({
  providedIn: 'root'
})
export class DeveloperService {
  private apiUrl = 'http://localhost:8080/api/developers';

  constructor(private http: HttpClient) { }

  getDevelopers(): Observable<Developer[]> {
    return this.http.get<Developer[]>(this.apiUrl);
  }

  postDevelopers(developer: Developer): Observable<Developer[]> {
    const url = `${this.apiUrl}/addDeveloper`;
    return this.http.post<Developer[]>(url, developer);
  }

  putDevelopers(developer: Developer): Observable<Developer[]> {
    const url = `${this.apiUrl}/edit/${developer.id}`;
    return this.http.put<Developer[]>(url, developer);
  }

  deleteDeveloper(developerId: number): Observable<void> {
    const url = `${this.apiUrl}/delete/${developerId}`;
    return this.http.delete<void>(url);
  }
}
