import { ValidatorFn, AbstractControl, ValidationErrors } from '@angular/forms';
import { Key } from 'protractor';

export class EmailValidator {

     static emailDomainValidator(): ValidatorFn {
       return (control: AbstractControl): {[Key: string]: any}| null =>{
           if(control.value == "")
            return null;
           let email_regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/
           email_regex.test(control.value) ? null : { emailDomain : true };
        }
        
    }
}
