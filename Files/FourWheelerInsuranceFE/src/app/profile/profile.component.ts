import { HttpErrorResponse, HttpEvent, HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,Validators, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import { Profile } from '../models/profile.model';
import { ProfileService } from '../services/profile.service';
import { saveAs } from 'file-saver';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  msg:string;
Hiuser:string;
 files:File[]=[];
registerForm : FormGroup;
submitted = false;
  successMessage: string;
  errorMessage: string;
  // router: any;
  filenames: string[] = [];
  fileStatus = { status: '', requestType: '', percent: 0 };

  constructor(private profileService:ProfileService,
    private router:Router,
    private userService:UserService) {}
      // get f() { return this.registerForm.controls; }
ngOnInit(): void {
  if(sessionStorage.getItem("isUserLoggedIn")!=="true"){
    this.router.navigate(["/"]);
  }
  else{
  this.registerForm = new FormGroup({
    "aplyname" : new FormControl("",Validators.required),
     "aplyaddress" : new FormControl("",Validators.required),
     "aplydate" : new FormControl("",Validators.required),
     "aplyvehno" : new FormControl("",Validators.required),
     "aplyvehmodel" : new FormControl("",Validators.required),
     "aplynumber": new FormControl("",[Validators.required,Validators.pattern("^[0-9]{10}$")]),
    
    });
  }
     
}
    
     sentProfile(){

     let profileData : Profile = {
      customerId : Number(sessionStorage.getItem("customerId")),
       aplyname: this.registerForm.value.aplyname,
       aplyaddress: this.registerForm.value.aplyaddress,
      aplydate: this.registerForm.value.aplydate,
       aplyvehno: this.registerForm.value.aplyvehno,
       aplyvehmodel: this.registerForm.value.aplyvehmodel,
       aplynumber: this.registerForm.value.aplynumber,
     }
      this.userService.sentProfile(profileData).subscribe((response)=>{
        this.successMessage = "Profile Successfully submitted";
      },(error)=>{ 
        this.errorMessage = "Profile Not submitted"; 
      });
     }
     onUploadFiles(files: File[]): void {
      const formData = new FormData();
      for (const file of files) { formData.append('files', file, file.name); }
      this.profileService.upload(formData).subscribe(
        event => {
          console.log(event);
          this.resportProgress(event);
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      );
    }
   
    // define a function to download files
    onDownloadFile(filename: string): void {
      this.profileService.download(filename).subscribe(
        event => {
          console.log(event);
          this.resportProgress(event);
        },
        (error: HttpErrorResponse) => {
          console.log(error);
        }
      );
    }
   
    private resportProgress(httpEvent: HttpEvent<string[] | Blob>): void {
      switch(httpEvent.type) {
        case HttpEventType.UploadProgress:
          this.updateStatus(httpEvent.loaded, httpEvent.total!, 'Uploaded ');
          break;
        case HttpEventType.DownloadProgress:
          this.updateStatus(httpEvent.loaded, httpEvent.total!, 'Downloaded ');
          break;
        case HttpEventType.ResponseHeader:
          console.log('Header returned', httpEvent);
          break;
        case HttpEventType.Response:
          if (httpEvent.body instanceof Array) {
            this.fileStatus.status = 'done';
            for (const filename of httpEvent.body) {
              this.filenames.unshift(filename);
            }
          } else {
            saveAs(new File([httpEvent.body!], httpEvent.headers.get('File-Name')!, 
                    {type: `${httpEvent.headers.get('Content-Type')};charset=utf-8`}));
          }
          this.fileStatus.status = 'done';
          break;
          default:
            console.log(httpEvent);
            break;
        
      }
    }
   
    private updateStatus(loaded: number, total: number, requestType: string): void {
      this.fileStatus.status = 'progress';
      this.fileStatus.requestType = requestType;
      this.fileStatus.percent = Math.round(100 * loaded / total);
    }
  }
    

