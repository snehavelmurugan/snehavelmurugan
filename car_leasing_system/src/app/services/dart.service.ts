import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehicle } from '../model/vehicle';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class DartService {
  [x: string]: any;
  url = "http://localhost:9002/cls/vehicle";
  //url1="http://localhost:8094/vehicle"
  // loggedIn:boolean=false;
  constructor(private solar: HttpClient) { }
  getdata() {
    return this.solar.get(this.url);
  }
  postdata(data: any) {
    return this.solar.post(this.url, data);
  }
  getdataById(id: number) {
    return this.solar.get<Vehicle>(`${this.url}/${id}`)
  }


deletedata(id: number){

  const url = `${this.url}/${id}`;

  return this.solar.delete(url);

}

  updateVehicle(id: number, updatedData: any) {
    const url = `${this.url}/${id}`;

    return this.solar.put(url, updatedData);
  }

  submitForm(data: FormData): Observable<any> {
    const headers = { 'Accept': 'application/json', };
    return this.solar.post(this.url, data, { headers });



  }
}
