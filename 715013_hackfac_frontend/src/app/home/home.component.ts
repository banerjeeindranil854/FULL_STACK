import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators, FormControl, FormGroupDirective, NgForm } from '@angular/forms';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  username: FormControl;
  password: FormControl;
  loginForm = this.fb.group({
    'username': ['', Validators.required, Validators.maxLength(6)],
    'password': ['', Validators.required, Validators.minLength(6), Validators.maxLength(20)]

  });
  constructor(private router:Router,private authService: AuthService, private fb: FormBuilder) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      username: this.username,
      password: this.password
    });
  }
  login(data): void {
  this.authService.checkAuthentication(data).subscribe((response) => {
        localStorage.setItem('accessToken', JSON.stringify(response.tokenType+response.accessToken));
        this.tokenValidate(response.accessToken);
            
    },
    (err) => 
    { 
      if(err.error.message){
        alert(err.error.message);
    }
  }
  );
  }
  tokenValidate(token){
    let data = {
      "token":token
    }
    this.authService.validAuthentication(data).subscribe((response) => {
      console.log('test',response);
      localStorage.setItem('userRole', JSON.stringify(response.role));
      localStorage.setItem('empId', JSON.stringify(response.message));
      if(response.role == 'emps'){
        this.router.navigate(['/feedback']); 
      }
      else if(response.role == 'admins'){
        this.router.navigate(['/dashboard']); 
        this.router.navigate(['/report']);
        this.router.navigate(['/upload']);
        this.router.navigate(['/feedback']);
        this.router.navigate(['/registernnotparticipate']);
        this.router.navigate(['/registerncancel']);
        this.router.navigate(['/home']);
        this.router.navigate(['/config']);
        this.router.navigate(['/feedbacklist']);
        this.router.navigate(['/employee']);
        this.router.navigate(['/employe']);
      }
      else if(response.role == 'pmos'){
        this.router.navigate(['/dashboard']); 
        this.router.navigate(['/report']);
      }
      else if(response.role == 'pocs'){
        this.router.navigate(['/dashboard']);
        this.router.navigate(['/event']); 
      }
      else{
        this.router.navigate(['/dashboard']); 
      }
              
  },
  (err) => 
  { 
    if(err.error.message){
      alert(err.error.message);
  }
}
);
  }

}
