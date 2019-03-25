import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChartModule } from 'angular-highcharts';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatToolbarModule} from '@angular/material/toolbar';
import { ReportComponent } from './report/report.component';
import { UploadComponent } from './upload/upload.component';
import { EventsComponent } from './events/events.component';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSelectModule} from '@angular/material/select';
import {MatDialogModule} from '@angular/material/dialog';
import { FeedbackComponent } from './feedback/feedback.component';
import { RegisterComponent } from './register/register.component';
import { NotregisterComponent } from './notregister/notregister.component';
import { ConfigComponent } from './config/config.component';
import { FeedbacklistComponent } from './feedbacklist/feedbacklist.component';
import { EmployeeComponent } from './employee/employee.component';
import { NotattendComponent } from './notattend/notattend.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SidebarComponent,
    DashboardComponent,
    ReportComponent,
    UploadComponent,
    EventsComponent,
    FeedbackComponent,
    RegisterComponent,
    NotregisterComponent,
    ConfigComponent,
    FeedbacklistComponent,
    EmployeeComponent,
    NotattendComponent
  ],
  imports: [
    BrowserModule,
    MatSidenavModule,
    MatInputModule,
    AppRoutingModule,
    ChartModule,
    MatToolbarModule,
    MatTableModule,
    MatPaginatorModule,
    MatSelectModule,
    MatDialogModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
