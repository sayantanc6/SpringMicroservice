import { Component, OnInit } from '@angular/core';
import { CentralizedService } from '../centralized.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {

  public value: string;

  constructor(private service: CentralizedService) { }

  ngOnInit() {
    this.service.mySubject.subscribe((data) => {
      this.value = data;
    });
  }

}
