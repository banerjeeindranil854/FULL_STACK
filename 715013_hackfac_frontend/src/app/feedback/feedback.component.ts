import { Component, OnInit } from '@angular/core';
import { CommonService } from "../service/common.service";
import { Router } from '@angular/router';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {
  feedbackVal:number;
  eventId;
  empId;
  isComment:boolean;
  description:string = "";
  constructor(private router:Router,private commonService: CommonService) { 
    this.eventId = "EVNT00047261";
    this.empId =  localStorage.getItem(JSON.stringify('empId'));
  }

  ngOnInit() {
  }
  feedbackSubmit(){
  this.commonService.feedBackSubmit(this.eventId,this.empId,this.feedbackVal,this.description).subscribe(data => {
    console.log("all event data",data);
    alert("Feedback submitted successfully.");
    this.router.navigate(['/home']); 
  },
  (err) => 
  { 
    if(err.error.message){
      alert(err.error.message);
  }
}); 
}
feedbackSelected(n:number){
 this.feedbackVal = n; 
 if(this.feedbackVal <3){
   this.isComment = true;
 }
}
}
