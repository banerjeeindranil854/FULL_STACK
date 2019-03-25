import { Component, OnInit,ViewChild } from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import { CommonService } from "../service/common.service";

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss']
})
export class EventsComponent implements OnInit {
  displayedColumns: string[] = ['empId','baseLocation', 'eventName','beneficiaryName','councilName'];
  ELEMENT_DATA: PeriodicElement[];
  dataSource;
  reportEmpId:String;
  path:String;
  OUTPUT_PATH:string;
  OUTPUT_XL:outputXl;
  empId;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private commonService: CommonService) {  
    this.empId =  JSON.parse(localStorage.getItem('empId'));
    console.log('tttttttttt',this.empId);
    }
    generateReport() {
      this.commonService.pocAllReport(this.empId,this.reportEmpId,this.path).subscribe(data => {
        this.OUTPUT_XL=data;
        this.OUTPUT_PATH=this.OUTPUT_XL.path;
        alert('XL generated Successfully');
        
      },
        (err) => {
          if (err.error.message) {
            alert(err.error.message);
          }
        });
    }
  getEventList(){
    this.commonService.getEvent().subscribe(data => {
      console.log("all event data",data);
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
   // this.dataSource.paginator = this.paginator;    
  }
 
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
export interface outputXl {
  path: string;
}

