import { Injectable } from '@angular/core';
import { UserContact } from './usercontact.model';


@Injectable({
  providedIn: 'root'
})
export class UsercontactService {

  usercontacts: UserContact[] = [{
    emp_id: 234,
    firstname: 'Clark',
    lastname: 'Kent',
    age: 26,
    city: 'Hyderabad'
  },
  {
    emp_id: 2345,
    firstname: 'Yash',
    lastname: 'Rai',
    age: 21,
    city: 'Bangalore'
  },
  ];

  create(usercontact: UserContact) {
    const itemIndex = this.usercontacts.length;
    usercontact.emp_id = this.getnextId();
    console.log(usercontact);
    this.usercontacts[itemIndex] = usercontact;
  }

  delete(usercontact: UserContact) {
    this.usercontacts.splice(this.usercontacts.indexOf(usercontact), 1);
  }

  update(usercontact: UserContact) {
    const itemIndex = this.usercontacts.findIndex(item => item.emp_id === usercontact.emp_id);
    console.log(itemIndex);
    this.usercontacts[itemIndex] = usercontact;
  }

  getall(): UserContact[] {
    console.log('usercontactservice:getall');
    console.log(this.usercontacts);
    return this.usercontacts;
  }

  reorderUserContacts(usercontact: UserContact) {
    console.log('Zur Info:', usercontact);
    this.usercontacts = this.usercontacts
      .map(uc => uc.emp_id === usercontact.emp_id ? usercontact : uc)
      .sort((a, uc) => uc.emp_id - uc.emp_id);
  }

  getUserById(id: number) {
    console.log(id);
    const itemIndex = this.usercontacts.findIndex(item => item.emp_id === id);
    console.log(itemIndex);
    return this.usercontacts[itemIndex];
  }

  getnextId(): number {
    let highest = 0;
    this.usercontacts.forEach(function (item) {
      if (highest === 0) {
        highest = item.emp_id;
      }
      if (highest < item.emp_id) {
        highest = item.emp_id;
      }
    });
    return highest + 1;
  }
}
