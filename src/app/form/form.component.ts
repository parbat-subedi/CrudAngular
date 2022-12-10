import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from './user-service.service';
import { User } from './user.model';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  submitted: boolean = false;
  login: FormGroup = new FormGroup({});
  user = new User();
  router: any;
  isSubmitting:boolean = false;


  constructor( private formbuilder: FormBuilder , private userService : UserServiceService) { }

  ngOnInit(): void {
    this.initForm();
  }

  get form(): { [key: string]: AbstractControl } {
    return this.login.controls;
  }

  onSubmit(loginData: any){
    this.submitted = true;

    if(this.login.invalid){
      return;
    }

    console.log(this.login.value);
    this.user.username = loginData.username;
    this.user.contactNumber = loginData.contactNumber;
    this.user.email = loginData.email;
    this.user.password = loginData.password;

    if(this.login.valid){
      this.addUser(this.user);
    }

  }
  addUser(user: any): void {
    this.userService.onAddUser(user).subscribe(
    (response:any)=>{
      this.isSubmitting=true;
      // this.addUser.reset;
      // this.router.navigate(['auth/login'])
      console.log("data inserted successfully");
    },
    (error:any)=>{
      this.isSubmitting=false;
      console.error("error in data insertion");
    }
    );
  }

  initForm(){
    this.login= this.formbuilder.group({
      name: [undefined ,Validators.required],
      email: [undefined,Validators.required],
      password: [undefined,Validators.required],
      contact: [undefined,Validators.required],
      address: [undefined,Validators.required],
    })

  }

}
