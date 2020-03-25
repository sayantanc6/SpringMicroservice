import { Component, OnInit } from '@angular/core';
import { CentralizedService } from '../centralized.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.scss']
})
export class BodyComponent implements OnInit {

  public value: string;

  constructor(private service: CentralizedService) { }

  ngOnInit() {
    this.service.mySubject.subscribe((data) => {
      this.value = data;
    });
  }

}
