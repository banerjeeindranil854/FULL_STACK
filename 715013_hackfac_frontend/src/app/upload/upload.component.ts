import { Component, OnInit } from '@angular/core';
import { CommonService } from "../service/common.service";
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.scss']
})
export class UploadComponent implements OnInit {
  filePath:string = "";
  OUTPUT_XL:outputXl;
  OUTPUT_PATH:string;
  constructor(private commonService: CommonService) { 
  }

  ngOnInit() {
  }
  xlSubmit(){
    this.commonService.XLSubmit(this.filePath).subscribe(data => {
      
      console.log("all event data",data);
      this.OUTPUT_XL=data;
      this.OUTPUT_PATH=this.OUTPUT_XL.path;
      console.log("all event data",this.OUTPUT_XL.path);
      alert("Xl genetated successfully");
    },
    (err) => 
    { 
      if(err.error.message){
        alert(err.error.message);
    }
  }); 
  }
}
export interface outputXl {
  path: string;
}
