import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  ADD_PRODUCT  = "/ACart/item/add";
  SEARCH_PRODUCT = "/ACart/item/search/";
  GET_ALL = "/ACart/item/getAll";
  DELETE_PRODUCT = "/ACart/item/delete/";
  UPDATE_PRODUCT = "/ACart/item/update";
  GET_RECENT = "/ACart/item/getRecentItems";

  constructor(private http: HttpClient) { }

  addProduct(payload: any): Observable<any> {
    return this.http.post<any>(this.ADD_PRODUCT, payload);
  }

  searchProduct(keyText: String) : Observable<any> {
    return this.http.get(`${this.SEARCH_PRODUCT}${keyText}`);
  }

  getAllProduct(): Observable<any> {
    return this.http.get(this.GET_ALL);
  }

  deleteProduct(id: any) {
    return this.http.get(`${this.DELETE_PRODUCT}${id}`)
  }

  updateProduct(payload: any): Observable<any> {
    return this.http.post(this.UPDATE_PRODUCT, payload);
  }

  getRecentProduct(): Observable<any> {
    return this.http.get(this.GET_RECENT);
  }

}

interface Product {
  name: string;
  description: string;
  category: string;
  imageUrl: string;
  price: number;
}
