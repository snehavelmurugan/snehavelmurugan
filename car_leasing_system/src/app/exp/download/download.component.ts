import { Component } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Entity } from 'src/app/model/entity.model';
import { EntityService } from 'src/app/services/entity.service';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.scss']
})
export class DownloadComponent {
  newEntity: Entity = {
    id: 0,
    fileName: '',
    fileType: '',
    uploadedBy: '',
    file: new Blob(),
  }

  downloadedFile: any;
  viewDocument: any;
  formIsValid: any;
  myForm: any;

  constructor(private entityService: EntityService, private sanitizer: DomSanitizer, private router: Router) { }

  saveEntity(): void {
    this.entityService.saveEntity(this.newEntity).subscribe(entity => {
      console.log('Entity saved:', entity);
      // Handle success, if needed
      this.formIsValid = this.myForm.valid;
    });
  }

  downloadFile(id: number, filename: string): void {
    this.entityService.downloadFile(id).subscribe((data: Blob) => {
      const blob = new Blob([data], { type: 'application/octet-stream' });
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = filename; // Set the desired download filename
      document.body.appendChild(a);
      a.click();
      window.URL.revokeObjectURL(url);
    });

  }

  fetchDocumentContent(id: number): void {
    this.entityService.downloadFile(id).subscribe((data: Blob) => {
      const blob = new Blob([data], { type: 'application/pdf' }); // Assuming it's a PDF, change the type accordingly
      const url = window.URL.createObjectURL(blob);
      this.viewDocument = this.sanitizer.bypassSecurityTrustResourceUrl(url);

      // this.router.navigate(['/pdf-viewer', id]);
    });
  }
}



