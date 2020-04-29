import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, 
          FormGroupName, FormControlName, FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { EmailValidator } from '../shared/email-validator';

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
        lastName: ['',[Validators.required,Validators.minLength(3),Validators.maxLength(5)]],
        email: ['',[EmailValidator.emailDomainValidator(),Validators.required,Validators.email]]
      })
    });
  }

  onSubmit(f: FormGroup): void {
    console.log(f);
    console.log("first name:"+f.controls.group1.value.firstName);
    console.log("last name:"+f.controls.group1.value.lastName);
    console.log("email:"+f.controls.group1.value.email);
  }

}
