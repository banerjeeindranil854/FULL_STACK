import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotattendComponent } from './notattend.component';

describe('NotattendComponent', () => {
  let component: NotattendComponent;
  let fixture: ComponentFixture<NotattendComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotattendComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotattendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
