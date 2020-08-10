import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { AddProductComponent } from './add-product/add-product.component';
import { SearchComponent } from './search/search.component';
import { ViewProductComponent } from './view-product/view-product.component';

const routes: Routes = [
  {path: 'home', component: HomepageComponent, pathMatch: 'full'},
  {path: 'addProduct', component: AddProductComponent, pathMatch: 'full'},
  {path: 'searchProduct', component: SearchComponent, pathMatch: 'full'},
  {path: 'viewProduct/:id', component: ViewProductComponent, pathMatch: 'full'},
  {path: '**', redirectTo: '/home'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
