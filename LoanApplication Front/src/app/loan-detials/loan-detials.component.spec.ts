import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanDetialsComponent } from './loan-detials.component';

describe('LoanDetialsComponent', () => {
  let component: LoanDetialsComponent;
  let fixture: ComponentFixture<LoanDetialsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanDetialsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanDetialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
