import {Component, Input, OnInit} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  constructor(private contactService: ContactService) {
  }

  // tslint:disable-next-line:variable-name
  _contact: Contact;

  isAddingState: boolean;

  get contact() {
    return this._contact;
  }


  @Input()
  set contact(value: Contact) {
    if (value) {
      this.isAddingState = false;
      this._contact = value;
    }
  }

  ngOnInit(): void {
    this.contact = new Contact();
    this.isAddingState = true;
  }

  onClickAdd() {
    this.contactService.add(this.contact);
  }
}
