import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { RecipeModel } from 'src/app/models/recipe.model';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-edit-recipe-reactive',
  templateUrl: './edit-recipe-reactive.component.html',
  styleUrls: ['./edit-recipe-reactive.component.css']
})
export class EditRecipeReactiveComponent implements OnInit {

  recipeEditForm: FormGroup;
  name: string;
  type: string;
  cost: number;
  rid: number;
  constructor(private recipeService: RecipeService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params: Params)=>{
      this.rid=+params['id'];
      let recipe: RecipeModel=this.recipeService.getRecipe(this.rid);
      this.name=recipe.recipeName;
      this.type=recipe.recipeType;
      this.cost=recipe.recipeCost;
    });

    this.recipeEditForm=new FormGroup({
      recipeData: new FormGroup({
        recipeName: new FormControl(this.name, Validators.required),
        recipeType: new FormControl(this.type, Validators.required),
        recipeCost: new FormControl(this.cost, Validators.required)
      })
    });
  }

  onSubmit(){
    let recipeInfo: {recipeName: string, recipeType: string, recipeCost: number}={
      recipeName: this.recipeEditForm.value.recipeData.recipeName,
      recipeType: this.recipeEditForm.value.recipeData.recipeType,
      recipeCost: this.recipeEditForm.value.recipeData.recipeCost
    };
    this.recipeService.updateRecipe(this.rid, recipeInfo);
  }
}
