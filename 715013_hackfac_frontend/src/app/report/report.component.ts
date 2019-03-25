import { Component, OnInit } from '@angular/core';
import { Chart } from 'angular-highcharts';
import { CommonService } from "../service/common.service";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.scss']
})
export class ReportComponent implements OnInit {
  chart: any;
  barchart: any;
  piechart: any;
  ariachart: any;
  feedBackData;
  chartData: any;
  reportEmpId:String;
  path:String;
  empId;
  OUTPUT_PATH:string;
  OUTPUT_XL:outputXl;
  constructor(private commonService: CommonService) {
    this.empId =  localStorage.getItem(JSON.stringify('empId'));
  }

  ngOnInit() {
    this.getEventList();
  }
  getEventList() {
    this.commonService.getFeedback().subscribe(data => {
      console.log("all feedback data", data);
      this.feedBackData = data;
      let rat1 = 1, rat2 = 2, rat3 = 3, rat4 = 4, rat5 = 5;
      let count1 = this.feedBackData.filter((obj) => obj.rating == rat1).length;
      let count2 = this.feedBackData.filter((obj) => obj.rating == rat2).length;
      let count3 = this.feedBackData.filter((obj) => obj.rating == rat3).length;
      let count4 = this.feedBackData.filter((obj) => obj.rating == rat4).length;
      let count5 = this.feedBackData.filter((obj) => obj.rating == rat5).length;
      this.chartData = [count1, count2, count3, count4, count5];
      this.createChart();
    },
      (err) => {
        if (err.error.message) {
          alert(err.error.message);
        }
      });
  }
  generateReport() {
    this.commonService.allReport(this.reportEmpId,this.path).subscribe(data => {
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
  createChart() {
    this.chart = new Chart({
      chart: {
        type: 'line'
      },
      title: {
        text: 'Linechart'
      },
      xAxis: {
        categories: [
          '1',
          '2',
          '3',
          '4',
          '5'
        ],
        title: {
          text: 'Rating '
        }
      },
      yAxis: [{ // Primary yAxis

        title: {
          text: 'Number of Event'
        }
      }],
      credits: {
        enabled: false
      },
      series: [
        {
          type: undefined,
          name: 'Line 1',
          data: this.chartData
        }
      ]
    });
    this.barchart = new Chart({
      chart: {
        type: 'column'
      },
      title: {
        text: 'Barchart'
      },
      xAxis: {
        categories: [
          '1',
          '2',
          '3',
          '4',
          '5'
        ],
        title: {
          text: 'Rating '
        }
      },
      yAxis: [{ // Primary yAxis

        title: {
          text: 'Number of Event'
        }
      }],
      credits: {
        enabled: false
      },
      series: [
        {
          type: undefined,
          name: 'Bar 1',
          data: this.chartData
        }
      ]
    });
    this.piechart = new Chart({
      chart: {
        type: 'pie'
      },
      title: {
        text: 'Pai Chart'
      },
      xAxis: {
        categories: [
          '1',
          '2',
          '3',
          '4',
          '5'
        ],
        title: {
          text: 'Rating '
        }
      },
      yAxis: [{ // Primary yAxis

        title: {
          text: 'Number of Event'
        }
      }],
      credits: {
        enabled: false
      },
      series: [{
        type: undefined,
        name: 'Events',
        colorByPoint: true,
        data: [{
          name: '1 Rating',
          y: this.chartData[0],
          sliced: true,
          selected: true
        }, {
          name: '2 Rating',
          y: this.chartData[1]
        }, {
          name: '3 Rating',
          y: this.chartData[2]
        }, {
          name: '4 Rating',
          y: this.chartData[3]
        }, {
          name: '5 Rating',
          y: this.chartData[4]
        }]
      }]
    });
    this.ariachart = new Chart({
      chart: {
        type: 'area'
      },
      title: {
        text: 'Areachart'
      },
      xAxis: {
        categories: [
          '1',
          '2',
          '3',
          '4',
          '5'
        ],
        title: {
          text: 'Rating '
        }
      },
      yAxis: [{ // Primary yAxis

        title: {
          text: 'Number of Event'
        }
      }],
      credits: {
        enabled: false
      },
      series: [
        {
          type: undefined,
          name: 'Area 1',
          data: this.chartData
        }
      ]
    });
  }
}
export interface outputXl {
  path: string;
}
