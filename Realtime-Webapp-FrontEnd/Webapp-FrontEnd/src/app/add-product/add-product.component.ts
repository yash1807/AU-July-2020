import { Component, OnInit } from '@angular/core';
import { ProductService } from "../product.service";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss']
})
export class AddProductComponent implements OnInit {

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
  }

  addProduct(payload) {
    console.log(payload);
    this.productService.addProduct(payload).subscribe(response => {
      console.log(response);
    },
    (error) => {
      console.log(error);
    },
    () => {

    });
  }

}
