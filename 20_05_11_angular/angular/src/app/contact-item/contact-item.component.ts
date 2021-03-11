import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Contact} from '../model/contact';
import {ContactService} from '../service/contact.service';
import {ContactEventService} from '../service/contact-event.service';

@Component({
  selector: 'app-contact-item',
  templateUrl: './contact-item.component.html',
  styleUrls: ['./contact-item.component.css']
})
export class ContactItemComponent implements OnInit {

  @Input()
  childContact: Contact;

  // @Output()
  // edit: EventEmitter<Contact> = new EventEmitter<Contact>();

  constructor(private contactService: ContactService,
              private contactEventService: ContactEventService) {
  }

  ngOnInit(): void {
  }

  onClickDelete() {
    this.contactService.remove(this.childContact);
  }

  // onClickEdit() {
  //   this.edit.emit(Object.assign({}, this.childContact));
  // }

  onClickEdit() {
    this.contactEventService.emitEditContact(this.childContact);
  }
}
