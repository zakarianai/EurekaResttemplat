import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservervoitureComponent } from './reservervoiture.component';

describe('ReservervoitureComponent', () => {
  let component: ReservervoitureComponent;
  let fixture: ComponentFixture<ReservervoitureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ReservervoitureComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservervoitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
