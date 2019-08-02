import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorrectionAjouterComponent } from './correction-ajouter.component';

describe('CorrectionAjouterComponent', () => {
  let component: CorrectionAjouterComponent;
  let fixture: ComponentFixture<CorrectionAjouterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorrectionAjouterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorrectionAjouterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
