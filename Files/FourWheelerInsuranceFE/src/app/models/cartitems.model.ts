import { Policy } from "./product.model";


export class CartItems{
    
    id:number;
    custid:number;
   
    policyName:string;
    policyPrice:number;
 
  numberOfYearsPlan:number;
    claimAmount:string;

    constructor(policy:Policy,customerId:number){
       this.custid = customerId;
       this.id = policy.id;
       this.policyName = policy.policyName
       this.policyPrice = policy.policyPrice;
       this.numberOfYearsPlan = policy.numberOfYearsPlan;
       this.claimAmount= policy.claimAmount;
      
    }
}