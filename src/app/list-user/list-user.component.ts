import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './list-user.model';
import { UserListService} from './user-list.service'


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {
  users:User[]=[];
  

  constructor(
    private service: UserListService,
    private router: Router,
    // public id:  
  ) { }

  public getUser(){
    this.service.listAllUsers().subscribe((data:any)=>{
      this.users=data.users;
    });
  }


  ngOnInit(): void {
    this.getUser();
  }

  onViewUser(): void{
    this.router.navigate(['/viewUser']);
  }

}
