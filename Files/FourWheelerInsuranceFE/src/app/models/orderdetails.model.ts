export interface OrderDetails{
    orderid?: number;
    customerid:number;
    policyName:string;
    claimAmount:string;
    policyPrice:number;
    numberOfYearsPlan:number;
    policydetails:string;
    createdDateTime?: Date;
}