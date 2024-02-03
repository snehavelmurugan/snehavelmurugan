import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entity } from '../model/entity.model';
@Injectable({
  providedIn: 'root'
})
export class EntityService {
  private apiUrl = 'http://localhost:9002/api';
  constructor(private http: HttpClient) { }
  getEntities(): Observable<Entity[]> {
    return this.http.get<Entity[]>(this.apiUrl);
  }
  saveEntity(entity: Entity): Observable<Entity> {
    const formData: FormData = new FormData();

    if (entity.id) {
      formData.append('id', entity.id.toString()); // Add the 'id' property if it exists
    }

    formData.append('fileName', entity.fileName);
    formData.append('fileData', entity.file, entity.fileName);
    formData.append('fileType', entity.fileType);
    formData.append('uploadedBy', entity.uploadedBy);


    return this.http.post<Entity>(`${this.apiUrl}/upload`, formData);

  }
  downloadFile(id: number): Observable<Blob> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.get(`${this.apiUrl}/download/${id}`, {
      responseType: 'blob',
      headers: headers,
    });
  }

  fetchDocumentContent(id: number): Observable<Blob> {
    // const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.get(`${this.apiUrl}/view/${id}`, {
      responseType: 'blob',
    });
  }

  deleteEntity(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }
}


