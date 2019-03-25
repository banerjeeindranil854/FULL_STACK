import { Component, OnInit, ViewChild, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { CommonService } from "../service/common.service";
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface DialogData {
  animal: string;
  name: string;
}
export interface Food {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-config',
  templateUrl: './config.component.html',
  styleUrls: ['./config.component.scss']
})
export class ConfigComponent implements OnInit {
  displayedColumns: string[] = ['empId', 'empRole', 'action'];
  ELEMENT_DATA: PeriodicElement[];
  dataSource;
  animal: string;
  name: string;
  userRole: string;
  addEmpId: String;
  userId;
  editMode: boolean;
  deleteMode: boolean;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  foods: Food[] = [
    { value: 'admins', viewValue: 'Admin' },
    { value: 'pocs', viewValue: 'POCS' },
    { value: 'emps', viewValue: 'EMPS' },
    { value: 'pmos', viewValue: 'PMOS' }
  ];
  constructor(private router: Router,private commonService: CommonService, public dialog: MatDialog) {
    this.getRoletList();
    this.editMode = true;
    this.deleteMode = true;
  }
  getRoletList() {
    this.commonService.getRole().subscribe(data => {
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
  ngOnInit() {
  }
  editRole(elem): void {
    this.userId = elem.empId;
    this.editMode = false;
    this.deleteMode = true;
  }
  deleteRole(elem): void {
    this.userId = elem.empId;
    this.deleteMode = false;
    this.editMode = true;
  }

  back() {
    this.editMode = true;
    this.deleteMode = true;
    this.userId = '';
  }
  roleSubmit(elem) {
    if (this.deleteMode) {
      this.commonService.editRole(elem.empId, this.userRole).subscribe(data => {
      },
        (err) => {
          if (err.error.message) {
            alert(err.error.message);
          }
        });
    }
    else {
      this.commonService.deleteRole(elem.empId).subscribe(data => {
      },
        (err) => {
          if (err.error.message) {
            alert(err.error.message);
          }
        });
    }
    this.router.navigate(['/dashboard']);
  }
  addRoleSubmit() {
    this.commonService.addRole(this.addEmpId, this.userRole).subscribe(data => {
      alert('Role added successfully');
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
      this.router.navigate(['/dashboard']);
  }
}
export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}


