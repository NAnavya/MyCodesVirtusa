export interface FeedBack{
    id?:number;
    customerId:number;
    name : string;
    emailId:string;
    phoneNumber:string;
    feedBackgiven : string;
    createdDateTime ?: Date;
}