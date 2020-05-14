import {Injectable} from '@angular/core';
import {Contact} from '../model/contact';

@Injectable()
export class ContactService {

  contacts: Contact[];

  constructor() {
    this.contacts = contacts;
  }

  add(contact: Contact): void {
    contact.id = this.contacts.length + 1;
    const objectToAdd: Contact = Object.assign({}, contact);
    this.contacts.push(objectToAdd);
  }

  getAll(): Contact[] {
    return this.contacts;
  }

  remove(childContact: Contact) {
    this.contacts = this.contacts.filter(value => value.id !== childContact.id);
  }

  edit(contact: Contact) {
    Object.assign({}, contact);
  }
}

const contacts: Contact[] = [
  {id: 1, name: 'Vasya', lastName: 'Vasin', age: 20},
  {id: 2, name: 'Petya', lastName: 'Petin', age: 25},
  {id: 3, name: 'Masha', lastName: 'Mashina', age: 30},
  {id: 4, name: 'Olya', lastName: 'Olina', age: 22},
  {id: 5, name: 'Stepa', lastName: 'Stepin', age: 10}
];
