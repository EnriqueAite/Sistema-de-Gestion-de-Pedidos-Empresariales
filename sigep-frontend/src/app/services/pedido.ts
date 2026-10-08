import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class PedidoService {

  private url = 'http://localhost:8080/api/pedidos';

  constructor(private http: HttpClient) {}

  listar(): Observable<any[]> {
    return this.http.get<any[]>(this.url);
  }

  guardar(pedido: any): Observable<any> {
    return this.http.post(this.url, pedido);
  }

  actualizar(id: number, pedido: any): Observable<any> {
    return this.http.put(`${this.url}/${id}`, pedido);
  }

  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }
}