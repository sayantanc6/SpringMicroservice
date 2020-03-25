import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, 
          FormGroupName, FormControlName, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {

  f: FormGroup;
  

  constructor(private fb: FormBuilder, 
              private http: HttpClient) { }

  ngOnInit() {
    this.f = this.fb.group({
      group1: this.fb.group({
        firstName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(5)]],
        lastName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(5)]]
      })
    });
  }

  onSubmit(f: FormGroup): void {
    console.log(f.value);
    console.log(f);
  }

}
