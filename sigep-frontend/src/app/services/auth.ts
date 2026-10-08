import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {

  private url = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}

  login(credenciales: any): Observable<any> {
    return this.http.post(`${this.url}/login`, credenciales);
  }

  guardarSesion(data: any) {
    localStorage.setItem('usuario', data.usuario);
    localStorage.setItem('nombre',  data.nombre);
  }

  obtenerUsuario(): string {
    return localStorage.getItem('usuario') || '';
  }

  obtenerNombre(): string {
    return localStorage.getItem('nombre') || '';
  }

  cerrarSesion() {
    localStorage.clear();
  }

  estaLogueado(): boolean {
    return localStorage.getItem('usuario') !== null;
  }
}