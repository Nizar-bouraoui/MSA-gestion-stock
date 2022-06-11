import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.page.html',
  styleUrls: ['./list-product.page.scss'],
})
export class ListProductPage implements OnInit {

  url = ' http://localhost:8087/api/message'
  sharedPositions:any
  filterSharedPositions:any
  searchInput:any
  sharedPositionNameChecker=false;
  response:any;
  postData = {
    name: "test",
    description: "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Itaque, quisquam aperiam! Similique, vel! ",
    price: 250,
  };
  

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit() {
      // get all available shared positions
      this.getAllSharedPosition();
      
    
  }
  async getAllSharedPosition(){
    await this.http.get(this.url).toPromise().then(data => {
      this.sharedPositions = data;
      this.sharedPositions = this.sharedPositions.data.product;
      this.filterSharedPositions = this.sharedPositions
      console.log( this.sharedPositions);
    });
  }
  
  navigateToSharePosition(sharedPositionName:any){
    console.log(sharedPositionName.value);
    if (sharedPositionName.value != '') {
      this.sharedPositionNameChecker = false;
      this.postData.name = sharedPositionName.value;
      console.log(this.postData);
      
      this.http.post("http://localhost:8087/api",this.postData).toPromise().then(
        data => {
            this.response = data;
          });
    } else {
      this.sharedPositionNameChecker = true;
    }
      
    
  }
  filterSharedPosition(searchInput:any){
    this.filterSharedPositions = this.sharedPositions.filter(obj => obj.name.toLowerCase().indexOf(searchInput.toLowerCase())> -1);
    this.searchInput = searchInput;
    if (searchInput != '') {
      this.sharedPositionNameChecker = false;
    }
  }
  doRefresh(event) {
    this.getAllSharedPosition();
    setTimeout(() => {      
      if (this.searchInput != null) {
        this.filterSharedPosition(this.searchInput);
      } 
      event.target.complete();
    }, 2000);
  }

}
