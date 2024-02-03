import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntityComponent } from './entity.component';

import { EntityService } from 'src/app/services/entity.service';

import { DomSanitizer } from '@angular/platform-browser';

import { Router } from '@angular/router';

import { of } from 'rxjs';



describe('EntityComponent', () => {

  let component: EntityComponent;

  let fixture: ComponentFixture<EntityComponent>;

  let entityService: EntityService;

  let sanitizer: DomSanitizer;

  let router: Router;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [EntityComponent],

      providers: [EntityService, DomSanitizer, Router],

    }).compileComponents();



    fixture = TestBed.createComponent(EntityComponent);

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

    component.saveEntity();



    expect(entityService.saveEntity).toHaveBeenCalledWith(entity);

    // Add assertions for handling success, if needed

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

    // Add more assertions as needed

  });



  it('should delete an entity', () => {

    const id = 1;



    spyOn(entityService, 'deleteEntity').and.returnValue(of({}));



    component.deleteEntity(id);



    expect(entityService.deleteEntity).toHaveBeenCalledWith(id);

    // Add assertions for handling success, if needed

  });



  // Add more test cases for other component methods



  // Cleanup after testing

  afterEach(() => {

    TestBed.resetTestingModule();

  });

});