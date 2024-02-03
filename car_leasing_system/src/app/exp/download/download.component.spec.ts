import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DownloadComponent } from './download.component';

import { EntityService } from 'src/app/services/entity.service';

import { DomSanitizer } from '@angular/platform-browser';

import { Router } from '@angular/router';

import { of } from 'rxjs';

import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';



describe('DownloadComponent', () => {

  let component: DownloadComponent;

  let fixture: ComponentFixture<DownloadComponent>;

  let entityService: EntityService;

  let sanitizer: DomSanitizer;

  let router: Router;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [DownloadComponent],

      providers: [EntityService, DomSanitizer, Router],

      imports: [ReactiveFormsModule],

    }).compileComponents();



    fixture = TestBed.createComponent(DownloadComponent);

    component = fixture.componentInstance;

    entityService = TestBed.inject(EntityService);

    sanitizer = TestBed.inject(DomSanitizer);

    router = TestBed.inject(Router);

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should save an entity', () => {

    const entity = {

      id: 1,

      fileName: 'test.pdf',

      fileType: 'application/pdf',

      uploadedBy: 'user1',

      file: new Blob(['test file content'], { type: 'application/octet-stream' }),

    };



    spyOn(entityService, 'saveEntity').and.returnValue(of(entity));



    component.newEntity = entity;

    component.myForm = new FormBuilder().group({

      // Define your form controls here

    });



    component.saveEntity();



    expect(entityService.saveEntity).toHaveBeenCalledWith(entity);

    expect(component.formIsValid).toBeTruthy();

  });



  it('should download a file', () => {

    const id = 1;

    const filename = 'test.pdf';

    const data = new Blob(['test file content'], { type: 'application/octet-stream' });



    spyOn(entityService, 'downloadFile').and.returnValue(of(data));

    const createElementSpy = spyOn(document, 'createElement').and.callThrough();

    const clickSpy = spyOn(HTMLElement.prototype, 'click');



    component.downloadFile(id, filename);



    expect(createElementSpy).toHaveBeenCalledWith('a');

    expect(clickSpy).toHaveBeenCalled();

  });



  // Add more test cases for other component methods



  // Cleanup after testing

  afterEach(() => {

    TestBed.resetTestingModule();

  });

});