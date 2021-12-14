import { TestBed } from '@angular/core/testing';

import { SeanceServiceService } from './seance-service.service';

describe('SeanceServiceService', () => {
  let service: SeanceServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeanceServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
