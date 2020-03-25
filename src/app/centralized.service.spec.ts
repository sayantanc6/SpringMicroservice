import { TestBed } from '@angular/core/testing';

import { CentralizedService } from './centralized.service';

describe('CentralizedService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CentralizedService = TestBed.get(CentralizedService);
    expect(service).toBeTruthy();
  });
});
