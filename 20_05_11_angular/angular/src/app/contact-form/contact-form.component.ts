import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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
    this._contact = new Contact();
    this.isAddingState = true;
  }

  onClickAdd(): void {
    this.contactService.add(this.contact);
    this.clearForm();
  }

  onClickEdit(): void {
    this.contactService.edit(this.contact);
    this.clearForm();
    this.isAddingState = true;
  }

  onClickCancel(): void {
    this.contactService.getAll();
    this.clearForm();
    this.isAddingState = true;
  }

  clearForm(): void {
    this._contact = new Contact();
  }
}
