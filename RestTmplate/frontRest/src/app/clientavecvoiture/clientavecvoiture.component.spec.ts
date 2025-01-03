import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientavecvoitureComponent } from './clientavecvoiture.component';

describe('ClientavecvoitureComponent', () => {
  let component: ClientavecvoitureComponent;
  let fixture: ComponentFixture<ClientavecvoitureComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ClientavecvoitureComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientavecvoitureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
