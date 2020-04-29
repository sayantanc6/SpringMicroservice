import { Directive, Input } from '@angular/core';
import { Validator, AbstractControl, ValidationErrors, NG_VALIDATORS } from '@angular/forms';

@Directive({
  selector: '[ngModel],[appNameAllowed]',
  providers: [{ provide: NG_VALIDATORS, 
                useExisting: FirstnameValidatorDirective, 
                multi: true
              }]
})
export class FirstnameValidatorDirective implements Validator {

  @Input('appNameAllowed')
  nameAllowed: string;

  
  validate(control: AbstractControl): {[key: string]: any}| null {
    const Allowed = new RegExp(this.nameAllowed).test(control.value);
    if (Allowed){
      return null;
    }else{
      return {'appNameAllowed': false};
    }
  }

}
