import { TestBed } from '@angular/core/testing';

import { ContactEventService } from './contact-event.service';

describe('ContactItemService', () => {
  let service: ContactEventService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContactEventService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
