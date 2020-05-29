import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';
import {ContactEventService} from '../service/contact-event.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit, OnDestroy {

  constructor(private contactService: ContactService,
              private contactEventService: ContactEventService) {
  }


  // tslint:disable-next-line:variable-name
  contact: Contact;

  isAddingState: boolean;
  editContactSubscription: Subscription;

  // @Input()
  // set contactToEdit(value: Contact) {
  //   if (value) {
  //     this.isAddingState = false;
  //     this.contact = value;
  //   }
  // }

  ngOnInit(): void {
    this.clearForm();
    this.editContactSubscription = this.contactEventService.subscribeEditContact(this.onEditContact);
  }

  ngOnDestroy(): void {
    this.editContactSubscription.unsubscribe();
  }

  // TODO: figure out why we placed here the arrow function (https://learn.javascript.ru/object-methods)
  onEditContact = (value: Contact) => {
    this.isAddingState = false;
    this.contact = value;
  }

  onClickAdd(): void {
    this.contactService.add(this.contact);
    this.clearForm();
  }

  onClickEdit(): void {
    this.contactService.edit(this.contact);
    this.clearForm();
  }


  onClickCancel(): void {
    this.contactService.getAll();
    this.clearForm();
    this.isAddingState = true;
  }

  clearForm(): void {
    this.isAddingState = true;
    this.contact = new Contact();
  }

}
