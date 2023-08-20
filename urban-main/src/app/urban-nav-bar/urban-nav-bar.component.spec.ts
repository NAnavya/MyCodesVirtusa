import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UrbanNavBarComponent } from './urban-nav-bar.component';

describe('UrbanNavBarComponent', () => {
  let component: UrbanNavBarComponent;
  let fixture: ComponentFixture<UrbanNavBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UrbanNavBarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UrbanNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
