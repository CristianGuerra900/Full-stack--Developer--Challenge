import { TestBed } from '@angular/core/testing';

import { LocationService } from '../services/location.service';

describe('LocationnnService', () => {
  let service: LocationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
