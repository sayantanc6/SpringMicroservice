import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CentralizedService {

  public mySubject = new Subject<any>();

  constructor() { }
}
