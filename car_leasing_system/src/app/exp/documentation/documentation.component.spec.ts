import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Router } from '@angular/router';

import { DocumentationComponent } from './documentation.component';

import { EntityService } from 'src/app/services/entity.service';

import { DomSanitizer } from '@angular/platform-browser';

import { of } from 'rxjs';

import { Entity } from 'src/app/model/entity.model';



describe('DocumentationComponent', () => {

  let component: DocumentationComponent;

  let fixture: ComponentFixture<DocumentationComponent>;

  let entityService: EntityService;

  let router: Router;

  let sanitizer: DomSanitizer;



  beforeEach(() => {

    TestBed.configureTestingModule({

      declarations: [DocumentationComponent],

      providers: [EntityService, DomSanitizer, Router],

    }).compileComponents();



    fixture = TestBed.createComponent(DocumentationComponent);

    component = fixture.componentInstance;

    entityService = TestBed.inject(EntityService);

    router = TestBed.inject(Router);

    sanitizer = TestBed.inject(DomSanitizer);



    spyOn(console, 'log');

    // spyOn(window, 'URL').and.returnValue({ createObjectURL: () => '', revokeObjectURL: () => '' });

  });



  it('should create the component', () => {

    expect(component).toBeTruthy();

  });



  it('should save an entity', () => {

    const newEntity: Entity = {

      id: 1,

      fileName: 'TestFile',

      fileType: 'pdf',

      uploadedBy: 'TestUser',

      file: new Blob(),

    };



    spyOn(entityService, 'saveEntity').and.returnValue(of(newEntity));

    component.newEntity = newEntity;

    component.saveEntity();



    expect(entityService.saveEntity).toHaveBeenCalledWith(newEntity);

    expect(console.log).toHaveBeenCalledWith('Entity saved:', newEntity);

  });



  it('should handle file change', () => {

    const file = new File(['test file content'], 'test.pdf', { type: 'application/pdf' });

    const event = {

      target: {

        files: { 0: file, length: 1 },

      },

    } as unknown as Event; // Use type assertion here



    component.onFileChange(event);



    expect(component.newEntity.fileName).toEqual('test.pdf');

    expect(component.newEntity.file.type).toEqual('application/pdf');

  });





  it('should download a file', () => {

    const id = 1;

    const filename = 'test.pdf';

    const data = new Blob(['test file content'], { type: 'application/octet-stream' });



    spyOn(entityService, 'downloadFile').and.returnValue(of(data));

    const anchor = document.createElement('a');

    spyOn(document, 'createElement').and.returnValue(anchor);



    component.downloadFile(id, filename);



    expect(entityService.downloadFile).toHaveBeenCalledWith(id);

    expect(document.createElement).toHaveBeenCalledWith('a');

  });



  it('should fetch document content', () => {

    const id = 1;

    const data = new Blob(['test file content'], { type: 'application/pdf' });



    spyOn(entityService, 'downloadFile').and.returnValue(of(data));

    spyOn(sanitizer, 'bypassSecurityTrustResourceUrl').and.callThrough();



    component.fetchDocumentContent(id);



    expect(entityService.downloadFile).toHaveBeenCalledWith(id);

    expect(sanitizer.bypassSecurityTrustResourceUrl).toHaveBeenCalled();

  });



  it('should delete an entity', () => {

    const id = 1;



    spyOn(entityService, 'deleteEntity').and.returnValue(of({}));

    component.deleteEntity(id);



    expect(entityService.deleteEntity).toHaveBeenCalledWith(id);

    expect(console.log).toHaveBeenCalledWith('Entity deleted:', {});

  });

});



