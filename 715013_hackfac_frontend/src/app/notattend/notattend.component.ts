import { Component, OnInit,ViewChild } from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { CommonService } from "../service/common.service";

@Component({
  selector: 'app-notattend',
  templateUrl: './notattend.component.html',
  styleUrls: ['./notattend.component.scss']
})
export class NotattendComponent implements OnInit {
  displayedColumns: string[] = ['empId','eventId', 'baseLocation','action'];
  ELEMENT_DATA: PeriodicElement[];
  dataSource;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private commonService: CommonService) {  
    this.getEmployeeNotAtnDetails();
    }
    getEmployeeNotAtnDetails(){
    this.commonService.getEmployeeNotAtnDetails().subscribe(data => {
      console.log("all employee data",data);
      this.ELEMENT_DATA = data;
      this.dataSource = new MatTableDataSource<PeriodicElement>(this.ELEMENT_DATA);            
      this.dataSource.paginator = this.paginator;   
    },
    (err) => 
    { 
      if(err.error.message){
        alert(err.error.message);
    }
  }); 
  }
  ngOnInit() {
  }
  sendMail(elem){
    this.commonService.sendMail(elem.empId,'N').subscribe(data => {
      console.log("all employee data",data);
      alert('Mail sent successfully');
      this.ELEMENT_DATA = data;
      this.dataSource = new MatTableDataSource<PeriodicElement>(this.ELEMENT_DATA);            
      this.dataSource.paginator = this.paginator;   
    },
    (err) => 
    { 
      if(err.error.message){
        alert(err.error.message);
    }
  }); 
  }
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}