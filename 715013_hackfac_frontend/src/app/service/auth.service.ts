import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

//enviournment
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  checkAuthentication(data): Observable<any> {
    const options = { headers: new HttpHeaders({ 'content-type': 'application/json','Authorization': 'hackfse','Access-Control-Allow-Origin': '*', }) };
    return this.http.post(`${environment.urls.serviceBase}auth/login`, data, options).pipe(
        map(res => {
            console.log(res);                 
            return res;
        })
    );
}
validAuthentication(data): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const options = { headers: new HttpHeaders({ 'content-type': 'application/json','Authorization': headerKey,'Access-Control-Allow-Origin': '*', }) };
    return this.http.post(`${environment.urls.serviceBase}auth/validatetoken`, data, options).pipe(
        map(res => {
            console.log(res);                 
            return res;
        })
    );
}
}
