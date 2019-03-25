import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CommonService } from "../service/common.service";
import { Router } from '@angular/router';

export interface Rating {
  value: string;
  viewValue: string;

}
@Component({
  selector: 'app-feedbacklist',
  templateUrl: './feedbacklist.component.html',
  styleUrls: ['./feedbacklist.component.scss']
})
export class FeedbacklistComponent implements OnInit {
  displayedColumns: string[] = ['empId', 'description', 'rating', 'action'];
  ELEMENT_DATA: PeriodicElement[];
  dataSource;
  addEmpId: string;
  userFeedback: string;
  addDescription: string;
  eventId: string;
  editMode: boolean;
  deleteMode: boolean;
  userId;
  ratings: Rating[] = [
    { value: '1', viewValue: 'Excellent' },
    { value: '2', viewValue: 'Good' },
    { value: '3', viewValue: 'Average' },
    { value: '4', viewValue: 'Poor' },
    { value: '5', viewValue: 'Very Poor' }
  ];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private router: Router, private commonService: CommonService) {
    this.getFeedbackList();
    this.editMode = true;
    this.deleteMode = true;
  }

  editFeed(elem): void {
    this.userId = elem.empId;
    this.editMode = false;
    this.deleteMode = true;
  }
  deleteFeed(elem): void {
    this.userId = elem.empId;
    this.deleteMode = false;
    this.editMode = true;
  }
  back() {
    this.editMode = true;
    this.deleteMode = true;
    this.userId = '';
  }
  feedSubmit(elem) {
    if (this.deleteMode) {
      this.editFeedback(elem);
    }
    else {
      this.deleteFeedback(elem);
    }
  }
  getFeedbackList() {
    this.commonService.getFeedbackList().subscribe(data => {
      console.log("all event data", data);
      this.ELEMENT_DATA = data;
      this.dataSource = new MatTableDataSource<PeriodicElement>(this.ELEMENT_DATA);
      this.dataSource.paginator = this.paginator;
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
  }
  deleteFeedback(elem) {
    this.commonService.deleteFeedback(elem).subscribe(data => {
      alert('Feedback deleted successfully');
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
    this.router.navigate(['/dashboard']);
  }
  editFeedback(elem) {
    this.commonService.editFeedback(elem, this.userFeedback).subscribe(data => {
      alert('Feedback edited successfully');
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
    this.router.navigate(['/dashboard']);
  }
  addFeedback() {
    this.commonService.feedBackSubmit(this.eventId, this.addEmpId, this.userFeedback, this.addDescription).subscribe(data => {
      alert('Feedback Added successfully');
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
    this.router.navigate(['/dashboard']);
  }
  ngOnInit() {
  }

}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
