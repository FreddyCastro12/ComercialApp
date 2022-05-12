import { TestBed } from '@angular/core/testing';

import { ServiceShoppingCart } from './ServiceShoppingCart';

describe('ServiceService', () => {
  let service: ServiceShoppingCart;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceShoppingCart);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});