import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  userRole
  constructor(private router:Router) {
    this.userRole = JSON.parse(localStorage.getItem('userRole'));
   }

  ngOnInit() {
  }
  logOut(){
    localStorage.clear();
    this.router.navigate(['/home']); 
  }
}