import { Component, OnInit, Output, EventEmitter, Input, OnChanges, SimpleChanges } from '@angular/core';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit, OnChanges {

  @Input('product') ProductFromViewComponent: any;
  @Input('adding') addForm;
  @Output() addProductToDatabase: EventEmitter<any> = new EventEmitter<any>();
  @Output() deleteProduct: EventEmitter<any> = new EventEmitter<any>();
  addProductForm: FormGroup;

  constructor() { }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.ProductFromViewComponent) {
      let newProduct = {};
      newProduct['category'] = this.ProductFromViewComponent.category;
      newProduct['description'] = this.ProductFromViewComponent.description;
      newProduct['imageUrl'] = this.ProductFromViewComponent.imageUrl;
      newProduct['name'] = this.ProductFromViewComponent.name;
      newProduct['price'] = this.ProductFromViewComponent.price;
      this.addProductForm.setValue(newProduct);
    }
  }

  // delete() {
  //   if (confirm('Are you sure you want to delete?')) {
  //     alert("Record Deleted.");
  //     this.deleteProduct.emit(this.ProductFromViewComponent.id);
  //     console.log('Record deleted.');
  //   } else {
  //     alert("Deletion cancelled.");
  //     console.log('Record not deleted.');
  //   }
  // }

  ngOnInit(): void {
    this.buildForm();
  }


  buildForm() {
    this.addProductForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-z ]*')]),
      description: new FormControl('', [Validators.required, Validators.pattern('[a-zA-z ]*'), Validators.maxLength(250)]),
      category: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      imageUrl: new FormControl('', [Validators.required]), //, Validators.pattern('https://*')
      price: new FormControl('', [Validators.required, Validators.pattern('[0-9]*')]),
    });
  }

  addProductProductComponent() {
    console.log(this.addProductForm.value);
    this.addProductToDatabase.emit(this.addProductForm.value);
    this.addProductForm.reset();
  }
}
