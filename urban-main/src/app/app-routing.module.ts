import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { BundlesComponent } from './bundles/bundles.component';
import { CartsComponent } from './carts/carts.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { LoginComponent } from './login/login.component';
import { ProductsComponent } from './products/products.component';
import { SignupComponent } from './signup/signup.component';
import { UrbanNavBarComponent } from './urban-nav-bar/urban-nav-bar.component';

const routes: Routes = [
  {path:'signup', component: SignupComponent},
  {path:'aboutus', component: AboutusComponent},
  {path:'bundles', component: BundlesComponent},
  {path:'favorites', component: FavoritesComponent},
  {path:'carts', component: CartsComponent},
  {path:'home',component:UrbanNavBarComponent},
  {path:'login',component:LoginComponent},
  {path:'products',component:ProductsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

