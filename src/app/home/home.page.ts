import { Component, ViewChild } from '@angular/core';
import { IonSlides } from '@ionic/angular';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  @ViewChild('mySlide')  slides: IonSlides;

  slideOpts = {
    allowTouchMove: false
    };
  url = 'http://localhost:9898/api/users';
  number:number;
  phoneNumberVerified:boolean = true;
  verificationCodeVerified:boolean = true;
  verificationCode:any;
  phoneNumber ;
  postData = {
    phoneNumber:''
  }
  response:any ;
  // = {
  // timeStamp: "2022-04-28T12:53:24.4726141",
  // statusCode: 201,
  // status: "CREATED",
  // reason: null,
  // message: "user created successfully",
  // description: null,
  // developerMessage: null,
  // data: {
  //     user: {
  //         id: 21,
  //         phoneNumber: "+21627623178",
  //         verificationCode: "798480",
  //         verified: false
  //     }
  // }};
  

  constructor(private http: HttpClient,private router: Router) {}
  async ngOnInit(): Promise<void> {
    
    
  }

  phoneNumberLengthValidation(currentValuePhoneNumber: number) {    
    this.phoneNumber = currentValuePhoneNumber;
    if (this.phoneNumber.length === 8) {
      this.phoneNumberVerified =false;
    }
    else {
      this.phoneNumberVerified =true;
    }
  }
  
  swipeNext(){
    this.slides.lockSwipes(false);
    this.slides.slideNext(); 
    this.slides.lockSwipes(false);
  }

  autoMoveNextInput(b:any){
      b.focus();
  }

  verificationCodeLengthValidation(a:any,b:any,c:any,d:any,e:any,f:any){
    this.verificationCode = a.value+b.value+c.value+d.value+e.value+f.value;
    if (this.verificationCode.length === 6) {
      this.verificationCodeVerified=false;
    }
    else {
      this.verificationCodeVerified=true;
    }
  }

  getAllUsers(){
    this.http.get(this.url).toPromise().then(data => {
      console.log('data',data);
    });
  }

  async saveUser(){
    
      this.postData.phoneNumber = '+216'+this.phoneNumber;
    console.log(this.postData);
    
    this.http.post(this.url,this.postData).toPromise().then(
      data => {
        this.response = data;
        console.log(this.response);
        
      });
    this.slides.lockSwipes(false);
    this.slides.slideNext(); 
    
    
  } 
  async verifyUser(){
    console.log( this.response.data.user);
    console.log(this.verificationCode);
    console.log(this.response.data.user.verificationCode = this.verificationCode);
    
    if (this.response.data.user.verificationCode == this.verificationCode) {
      this.response.data.user.verificationCode = this.verificationCode;
      this.http.put(this.url,this.response.data.user).toPromise().then(
        data => {
         console.log(data);
         
        });
        this.router.navigate(['/list-product']);
        
   
  }
}


}
