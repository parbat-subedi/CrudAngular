import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminNavBarComponent } from './admin-nav-bar/admin-nav-bar.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { FormComponent } from './form/form.component';
import { ListUserComponent } from './list-user/list-user.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ViewUserComponent } from './view-user/view-user.component';

const routes: Routes = [
  {
    path: 'admin-nav-bar', component: AdminNavBarComponent
  },
  {
    path: 'form', component: FormComponent
  },
  {
    path:'list-user', component:ListUserComponent
  },
  {
    path:'editUser', component:EditUserComponent
  },
  {
    path:'deleteUser', component:DeleteUserComponent
  },
  {
    path:'viewUser/id', component:ViewUserComponent
  },
  {
    path:'sidebar' , component: SidebarComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
