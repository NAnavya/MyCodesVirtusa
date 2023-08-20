import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { EditCartitemComponent } from './edit-cartitem/edit-cartitem.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SignupComponent } from './signup/signup.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { EditUserComponent } from './user/edit-user/edit-user.component';
import { UserComponent } from './user/user.component';
import { AdminCustomerComponent } from './admin/admin-customer/admin-customer.component';
import { AdminProductComponent } from './admin/admin-product/admin-product.component';
import { OrderRecievedComponent } from './admin/order-recieved/order-recieved.component';
import { AdminEditProductComponent } from './admin/admin-edit-product/admin-edit-product.component';
import { AddNewProductComponent } from './admin/add-new-product/add-new-product.component';
import { AdminFeedbackComponent } from './admin/admin-feedback/admin-feedback.component';
import { MyordersComponent } from './myorders/myorders.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ProductListComponent } from './home/product-list/product-list.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { ProfileComponent } from './profile/profile.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';


const routes: Routes = [
  //user commponents
  {path:'',component:LoginComponent},
  {path:"forgot-password",component:ForgotPasswordComponent},
  {path:'home',component:HomeComponent},

  {path:'user',component:UserComponent},
  {path:'edit-user',component:EditUserComponent},
  {path:'contact',component:ContactComponent},
  {path:'cart',component:CartComponent},
  {path:'edit-cart',component:EditCartitemComponent},
  {path:'checkout',component:CheckoutComponent},
  {path:'signup',component:SignupComponent},
  {path:'order-details',component:OrderDetailsComponent},
  {path:'myOrders',component:MyordersComponent},
  {path:'thankyou',component:ThankyouComponent},
  {path:'product-list',component:ProductListComponent },
  {path:'profile',component:ProfileComponent },
  //admin components
  {path:'admin',component:AdminhomeComponent},
  {path:'admin-product',component:AdminProductComponent},
  {path:'admin-customer',component:AdminCustomerComponent},
  {path:'admin-orders',component:OrderRecievedComponent},
  {path:"edit-product",component:AdminEditProductComponent},
  {path:"add-product",component:AddNewProductComponent},
  {path:'page-not-found',component:PageNotFoundComponent},
  {path:'user-feedbacks',component:AdminFeedbackComponent},
  {path:'user-profiles',component:AdminProfileComponent},
  {path:'**',redirectTo:"login"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
