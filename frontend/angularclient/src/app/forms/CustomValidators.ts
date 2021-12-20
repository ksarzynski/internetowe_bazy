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

    //TODO: handle chars being interpreted as nums
    static numberValidator(): ValidatorFn{
        return (control: AbstractControl): ValidationErrors | null => {
            
            return control.value <= 0 ? {specialChars: {value: control.value}} : null;
        }
    }

}