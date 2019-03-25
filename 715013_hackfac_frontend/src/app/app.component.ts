import { Component } from '@angular/core';
import { CommonService } from "./service/common.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private cmnSvc: CommonService) {
    this.cmnSvc.Loader.get().subscribe((data: boolean) => {
      this.loading = data;
    });
  }
  title = 'FeedbackApp';
  private loading = false;
  private preLoading = false;
  showFiller = true;
  ngOnInit() {
   //this.cmnSvc.Loader.start();
    //this.cmnSvc.Loader.stop();
  }
}
