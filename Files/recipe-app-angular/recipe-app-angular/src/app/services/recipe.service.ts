import { RecipeModel } from "../models/recipe.model";

export class RecipeService{
    private recipes: RecipeModel[]=[
        {recipeID: 1, recipeName: 'Paneer Korma', recipeType: 'Veg', recipeCost: 120},
        {recipeID: 2, recipeName: 'Uttapam', recipeType: 'Veg', recipeCost: 40},
        {recipeID: 3, recipeName: 'Butter Chicken', recipeType: 'Non-Veg', recipeCost: 140},
        {recipeID: 4, recipeName: 'Fish curry', recipeType: 'Non-Veg', recipeCost: 100},
        {recipeID: 5, recipeName: 'Dosa', recipeType: 'Veg', recipeCost: 50}
    ];
    getRecipes(): RecipeModel[]{
        return this.recipes;
    } 
    getRecipe(recipeID: number): RecipeModel{
        return this.recipes.find(recipe=>recipe.recipeID===recipeID);
    }
    updateRecipe(recipeID: number, recipeInfo:{recipeName: string, recipeType: string, recipeCost: number}){
        let recipeIndex=this.recipes.findIndex(recipe=>recipe.recipeID===recipeID);
        let recipe=this.recipes[recipeIndex];
        recipe.recipeName=recipeInfo.recipeName;
        recipe.recipeType=recipeInfo.recipeType;
        recipe.recipeCost=recipeInfo.recipeCost;

    }
}