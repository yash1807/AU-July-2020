import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  searchText: string;
  products: Array<any> = [];

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  searchProduct() {
    this.productService.searchProduct(this.searchText).subscribe(
      res => {
        this.products = [];
        this.products.push(res);
      },
      err => {
        console.log(err);
      },
      () => {});
  }

  viewProduct(product: any) {
    this.router.navigate(['viewProduct', product.id]);
  }

}
