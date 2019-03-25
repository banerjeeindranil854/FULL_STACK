import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReportComponent } from './report/report.component';
import { UploadComponent } from './upload/upload.component';
import { EventsComponent } from './events/events.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { RegisterComponent } from './register/register.component';
import { NotregisterComponent } from './notregister/notregister.component';
import { ConfigComponent } from './config/config.component';
import { FeedbacklistComponent } from './feedbacklist/feedbacklist.component';
import { EmployeeComponent } from './employee/employee.component';
import { NotattendComponent } from './notattend/notattend.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'event', component: EventsComponent },
  { path: 'report', component: ReportComponent },
  { path: 'upload', component: UploadComponent },
  { path: 'feedback', component: FeedbackComponent },
  { path: 'registernnotparticipate', component: RegisterComponent },
  { path: 'registerncancel', component: NotregisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'config', component: ConfigComponent },
  { path: 'feedbacklist', component: FeedbacklistComponent },
  { path: 'employee', component: EmployeeComponent },
  { path: 'employe', component: NotattendComponent },
  { path: '**',
  redirectTo: '/home',
  pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
