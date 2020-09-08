import { Component, OnInit } from '@angular/core';
import { LocationService } from './services/location.service';
import {ResponseLocation} from './model/responseLocation';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app-web-location';
  locations: Array<ResponseLocation>;
  peticion: ResponseLocation = new ResponseLocation();
  
  constructor(private locationService: LocationService, private router: Router) {
  }

  newEmployee(): void {
    this.peticion = new ResponseLocation();
  }

  ngOnInit() {
    this.locationService.getLocations()
    .subscribe(
      (data) => { // Success
        this.locations = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  save() {
    this.locationService
    .createLocation(this.peticion).subscribe(data => {
      console.log(data)
      this.peticion = new ResponseLocation();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.save();    
  }

  gotoList():void {
    window.location.reload();
  }

  deleteLocation ( id :  number ) {
    this.locationService.deleteLocation(id)
    .subscribe(
      (data) => { // Success
        this.locations = data;
        this.gotoList();
      },
      (error) => {
        console.error(error);
      }
    );
  }



}

