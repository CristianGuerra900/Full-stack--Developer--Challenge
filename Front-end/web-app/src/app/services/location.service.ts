import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {ResponseLocation} from '../model/responseLocation';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LocationService {

  private baseUrl = 'http://localhost:8080//locations';

  constructor(private http: HttpClient) { }

  getLocations(): Observable<ResponseLocation[]> {
    return this.http.get<ResponseLocation[]>('http://localhost:8080//locations/All');
  }

  createLocation(location: ResponseLocation): Observable<LocationService> {
    return this.http.post<LocationService>(`${this.baseUrl}`, location);
  }

  deleteLocation(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

}
