import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeComponent } from './recipe-list/recipe/recipe.component';
import { EditRecipeComponent } from './recipe-list/edit-recipe/edit-recipe.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RecipeService } from './services/recipe.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditRecipeReactiveComponent } from './recipe-list/edit-recipe-reactive/edit-recipe-reactive.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RecipeListComponent,
    RecipeComponent,
    EditRecipeComponent,
    PageNotFoundComponent,
    EditRecipeReactiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [RecipeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
