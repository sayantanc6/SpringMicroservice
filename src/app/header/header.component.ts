import { Component, OnInit } from '@angular/core';
import { CentralizedService } from '../centralized.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public value: string;

  constructor(private service: CentralizedService) { }

  ngOnInit() {
  }

  onPubish(): void{
    this.service.mySubject.next(this.value);

  }
}
