import { TestBed } from '@angular/core/testing';

import { MRDBService } from './mrdb.service';

describe('MRDBService', () => {
  let service: MRDBService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MRDBService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
