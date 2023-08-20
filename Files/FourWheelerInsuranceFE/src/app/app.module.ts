import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProductListComponent } from './home/product-list/product-list.component';
import { ProductItemComponent } from './home/product-list/product-item/product-item.component';
import { ProductService } from './services/product.service';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserComponent } from './user/user.component';
import { EditUserComponent } from './user/edit-user/edit-user.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditCartitemComponent } from './edit-cartitem/edit-cartitem.component';
import { AdminComponent } from './admin/admin.component';
import { AdminheaderComponent } from './admin/adminheader/adminheader.component';
import { AdminProductComponent } from './admin/admin-product/admin-product.component';
import { AdminCustomerComponent } from './admin/admin-customer/admin-customer.component';
import { OrderRecievedComponent } from './admin/order-recieved/order-recieved.component';
import { AdminEditProductComponent } from './admin/admin-edit-product/admin-edit-product.component';
import { AddNewProductComponent } from './admin/add-new-product/add-new-product.component';
import { AuthInterceptor } from './services/httpinterceptor';
import { ProfileDetailsService } from './services/profiledetails.service';
import { AdminFeedbackComponent } from './admin/admin-feedback/admin-feedback.component';
import { MyordersComponent } from './myorders/myorders.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ProfileComponent } from './profile/profile.component';
import { AdminhomeComponent } from './admin/adminhome/adminhome.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductListComponent,
    ProductItemComponent,
    CartComponent,
    CheckoutComponent,
    PageNotFoundComponent,
    UserComponent,
    EditUserComponent,
    ContactComponent,
    LoginComponent,
    SignupComponent,
    OrderDetailsComponent,
    ThankyouComponent,
    EditCartitemComponent,
    AdminComponent,
    AdminheaderComponent,
    AdminProductComponent,
    AdminCustomerComponent,
    OrderRecievedComponent,
    AdminEditProductComponent,
    AddNewProductComponent,
    AdminFeedbackComponent,
    MyordersComponent,
    ForgotPasswordComponent,
    ProfileComponent,
    AdminhomeComponent,
    AdminProfileComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [ProductService,ProfileDetailsService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
