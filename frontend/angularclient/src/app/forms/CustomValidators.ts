import { AbstractControl, ValidationErrors, ValidatorFn } from "@angular/forms";

export class CustomValidators{
    constructor() {}

    

    static specialCharsValidator(): ValidatorFn{
        return (control: AbstractControl): ValidationErrors | null => {
            const data: string = control.value; 
            let illegal = [];
            illegal = [...data].filter(char => !char.match(/[a-z]/));
            return illegal.length > 0 ? {specialChars: {value: control.value}} : null;
        }
      }
}