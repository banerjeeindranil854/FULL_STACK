import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { Observable, Subject } from "rxjs";

//enviournment
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) { }
  private massage = () => {
    let subject = new Subject<any>();
    return {
      get: () => {
        return subject.asObservable();
      },
      send: (data: any) => {
        subject.next(data);
      }
    };
  };
  private loaderMsg = this.massage();
  private loader = () => {
    let loaderCount = 0;
    return {
      start: () => {
        loaderCount++;
        if (loaderCount > 0) {
          this.loaderMsg.send(true);
        }
      },
      stop: () => {
        loaderCount--;
        if (loaderCount <= 0) {
          this.loaderMsg.send(false);
        }
      },
      get: () => {
        return this.loaderMsg.get();
      }
    };
  };

  public Loader = this.loader();

  getEvent(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    console.log(headerKey);
    //const options = { headers: new HttpHeaders({ 'content-type': 'application/json','Authorization': 'hackfse','Access-Control-Allow-Origin': '*', }) };
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}findAllEmpAttndAnEvt`, {}, httpOptions);
  }

  getRole(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    console.log(headerKey);
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}getAllRoles`, {}, httpOptions);
  }

  getFeedbackList(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    console.log(headerKey);
    //const options = { headers: new HttpHeaders({ 'content-type': 'application/json','Authorization': 'hackfse','Access-Control-Allow-Origin': '*', }) };
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}getFeedbacks`, {}, httpOptions);
  }
  getFeedback(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}getFeedbacks`, {}, httpOptions);
  }
  feedBackSubmit(eventId, empId, feedbackVal, description): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}addFeedBack?eventId=${eventId}&empId=${empId}&rating=${feedbackVal}&description=${description}`, {}, httpOptions);
  }

  allReport(path, associate): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    
    return this.http.post(`${environment.urls.serviceBase}getAllEvtRprt?path=${path}&associateEmpId=${associate}`, {}, httpOptions);
  }

  pocAllReport(empId, path, associate): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}getindEvtRprt?empId=${empId}&path=${path}&associateEmpId=${associate}`, {}, httpOptions);
  }

  XLSubmit(filePath): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}generateXL?xlPath=${filePath}`, {}, httpOptions);
  }

  editRole(empId, empRole): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.put(`${environment.urls.serviceBase}updateRole?empRole=${empRole}&empId=${empId}`, {}, httpOptions);
  }
  deleteRole(empId): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.put(`${environment.urls.serviceBase}deleteRole?empId=${empId}`, {}, httpOptions);
  }
  addRole(empId, empRole): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}addRole?empRole=${empRole}&empId=${empId}`, {}, httpOptions);
  }
  generateXL(xlPath): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}generateXL?xlPath=${xlPath}`, {}, httpOptions);
  }
  getEmployeeAtnDetails(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}findAllVolentierSendTheResponse`, {}, httpOptions);
  }
  getEmployeeNotAtnDetails(): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}findAllNotSendedResponse`, {}, httpOptions);
  }
  sendMail(empId, status): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}sendMail?empId=${empId}&status=${status}`, {}, httpOptions);
  }
  deleteFeedback(elem): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}deleteFedback?eventId=${elem.eventId}&rating=${elem.rating}&empId=${elem.empId}&description=${elem.description}`, {}, httpOptions);
  }

  editFeedback(elem,userFeedback): Observable<any> {
    const headerKey = JSON.parse(localStorage.getItem('accessToken'));
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': headerKey
      })
    };
    return this.http.post(`${environment.urls.serviceBase}updateFedback?eventId=${elem.eventId}&rating=${userFeedback}&empId=${elem.empId}&description=${elem.description}`, {}, httpOptions);
  }
}
