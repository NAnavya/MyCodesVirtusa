import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { RecipeModel } from 'src/app/models/recipe.model';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.css'],
})
export class RecipeComponent implements OnInit {
  recipe: RecipeModel;
  constructor(
    private recipeService: RecipeService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params) => {
      let id = +params['id'];
      this.recipe = this.recipeService.getRecipe(id);
    });
  }
  onEditTemplate() {
    this.router.navigate(['editrecipetemplate'], {
      relativeTo: this.activatedRoute,
      queryParamsHandling: 'preserve',
    });
  }
  onEditReactive() {
    this.router.navigate(['editrecipereactive'], {
      relativeTo: this.activatedRoute,
      queryParamsHandling: 'preserve',
    });
  }
}
