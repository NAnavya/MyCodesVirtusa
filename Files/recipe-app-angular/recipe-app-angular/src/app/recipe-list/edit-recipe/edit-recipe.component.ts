import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { RecipeService } from 'src/app/services/recipe.service';

@Component({
  selector: 'app-edit-recipe',
  templateUrl: './edit-recipe.component.html',
  styleUrls: ['./edit-recipe.component.css']
})
export class EditRecipeComponent implements OnInit {
  @ViewChild('f', {static: false}) recipeEditForm: NgForm;
  name: string;
  type: string;
  cost: number;
  rid: number;
  constructor(private recipeService: RecipeService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params:Params)=>{
      this.rid=+params['id'];
      let recipe=this.recipeService.getRecipe(this.rid);
      this.name=recipe.recipeName;
      this.type=recipe.recipeType;
      this.cost=recipe.recipeCost;
    });
  }

  onSubmit(){
    let recipeInfo: {recipeName: string, recipeType: string, recipeCost: number}={
      recipeName: this.recipeEditForm.value.recipeData.recipeName,
      recipeType: this.recipeEditForm.value.recipeData.recipeType,
      recipeCost: this.recipeEditForm.value.recipeData.recipeCost
    };
    // this.activatedRoute.params.subscribe((params: Params)=>{
    //   // let rid=+params['id'];
    //   this.recipeService.updateRecipe(this.rid, recipeInfo);
    // });
    this.recipeService.updateRecipe(this.rid, recipeInfo);
  }
}
