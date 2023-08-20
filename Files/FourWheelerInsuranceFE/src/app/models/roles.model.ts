import { UserModel } from "./user.model";

export interface Role{
    id?:number,
    roleName:string,
    customer:UserModel
}