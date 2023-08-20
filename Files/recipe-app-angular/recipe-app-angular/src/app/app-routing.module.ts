import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EditRecipeReactiveComponent } from './recipe-list/edit-recipe-reactive/edit-recipe-reactive.component';
import { EditRecipeComponent } from './recipe-list/edit-recipe/edit-recipe.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { RecipeComponent } from './recipe-list/recipe/recipe.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'recipelist',
    component: RecipeListComponent,
    children: [
      { path: ':id', component: RecipeComponent },
      { path: ':id/editrecipetemplate', component: EditRecipeComponent },
      {
        path: ':id/editrecipereactive',
        component: EditRecipeReactiveComponent,
      },
    ],
  },
  { path: 'not-found', component: PageNotFoundComponent },
  { path: '**', redirectTo: 'not-found' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
