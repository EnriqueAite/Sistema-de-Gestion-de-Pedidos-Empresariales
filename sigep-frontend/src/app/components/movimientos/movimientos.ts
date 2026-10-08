import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MovimientoService } from '../../services/movimiento';
import { AuthService } from '../../services/auth';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-movimientos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './movimientos.html'
})
export class MovimientosComponent implements OnInit {
  movimientos: any[] = [];
  productos: any[] = [];
  movimiento: any = { tipo: 'ENTRADA' };
  nombre: string;

  constructor(
    private movimientoService: MovimientoService,
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {
    this.nombre = this.authService.obtenerNombre();
  }

  ngOnInit() {
    this.cargar();
    this.http.get<any[]>('http://localhost:8080/api/productos').subscribe((d: any[]) => this.productos = d);
  }

  cargar() {
    this.movimientoService.listar().subscribe((data: any[]) => this.movimientos = data);
  }

  guardar() {
    this.movimientoService.guardar(this.movimiento).subscribe({
      next: () => { this.cargar(); this.limpiar(); },
      error: (e: any) => alert(e.error)
    });
  }

  eliminar(id: number) {
    this.movimientoService.eliminar(id).subscribe(() => this.cargar());
  }

  limpiar() { this.movimiento = { tipo: 'ENTRADA' }; }

  volver() { this.router.navigate(['/operativo']); }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}