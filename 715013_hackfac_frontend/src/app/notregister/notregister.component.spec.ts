import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotregisterComponent } from './notregister.component';

describe('NotregisterComponent', () => {
  let component: NotregisterComponent;
  let fixture: ComponentFixture<NotregisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotregisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
