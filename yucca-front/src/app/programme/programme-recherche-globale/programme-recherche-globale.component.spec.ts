import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammeRechercheGlobaleComponent } from './programme-recherche-globale.component';

describe('ProgrammeRechercheGlobaleComponent', () => {
  let component: ProgrammeRechercheGlobaleComponent;
  let fixture: ComponentFixture<ProgrammeRechercheGlobaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProgrammeRechercheGlobaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgrammeRechercheGlobaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
