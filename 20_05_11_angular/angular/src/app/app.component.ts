import {Component} from '@angular/core';
import {ContactService} from './service/contact.service';
import {Contact} from './model/contact';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ContactService]
})
export class AppComponent {
  // contactService: ContactService;
  //
  // constructor(contactService: ContactService) {
  //   this.contactService = contactService;
  // }

  constructor(public contactService: ContactService) {
  }

  contactToEdit: Contact;

  title = 'Contacts';

  // editContact($event: Contact) {
  //   console.log($event);
  //   this.contactToEdit = $event;
  // }

  onEditContact($event: Contact) {
    this.contactToEdit = $event;
  }
}
