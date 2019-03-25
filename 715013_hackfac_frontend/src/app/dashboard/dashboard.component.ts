import { Component, OnInit } from '@angular/core';
import { Chart } from 'angular-highcharts';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

export class DashboardComponent implements OnInit {
  chart:any;
  barchart;
  constructor() { 
    this.chart = new Chart({
      chart: {
        type: 'line'
      },
      title: {
        text: 'Linechart'
      },
      credits: {
        enabled: false
      },
      series: [
        {
          type:undefined,
          name: 'Line 1',
          data: [1, 2, 3]
        }
      ]
    });
    this.barchart = new Chart({
      chart: {
        type: 'bar'
      },
      title: {
        text: 'Barchart'
      },
      credits: {
        enabled: false
      },
      series: [
        {
          type:undefined,
          name: 'Bar 1',
          data: [1, 2, 3]
        }
      ]
    });
  }

  ngOnInit() {
  }
}
