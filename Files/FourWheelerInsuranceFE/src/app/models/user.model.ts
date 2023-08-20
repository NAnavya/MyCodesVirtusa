import { Role } from "./roles.model";

export interface UserModel{
    id?:number,
    name:string,
    emailId:string,
    phoneNumber:number,
    username:string,
    password:string,
    roles:Set<Role>
}