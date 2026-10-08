import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ProductoService {

  private url = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {}

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }

  guardar(producto: any): Observable<any> {
    return this.http.post(this.url, producto);
  }

  actualizar(id: number, producto: any): Observable<any> {
    return this.http.put(`${this.url}/${id}`, producto);
  }

  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}