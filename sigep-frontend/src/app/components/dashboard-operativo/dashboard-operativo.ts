import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth';
import { MovimientoService } from '../../services/movimiento';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard-operativo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './dashboard-operativo.html'
})
export class DashboardOperativoComponent implements OnInit {
  nombre: string;
  productos: any[] = [];
  movimientoEntrada: any = { tipo: 'ENTRADA' };
  movimientoSalida: any = { tipo: 'SALIDA' };

  constructor(
    private authService: AuthService,
    private movimientoService: MovimientoService,
    private router: Router,
    private http: HttpClient
  ) {
    this.nombre = this.authService.obtenerNombre();
  }

  ngOnInit() {
    this.cargarProductos();
  }

  cargarProductos() {
    this.http.get<any[]>('http://localhost:8080/api/productos')
      .subscribe((d: any[]) => this.productos = d);
  }

  registrarEntrada() {
    const mov = { ...this.movimientoEntrada, tipo: 'ENTRADA' };
    this.movimientoService.guardar(mov).subscribe({
      next: () => { this.cargarProductos(); this.movimientoEntrada = { tipo: 'ENTRADA' }; },
      error: (e: any) => alert(e.error)
    });
  }

  registrarSalida() {
    const mov = { ...this.movimientoSalida, tipo: 'SALIDA' };
    this.movimientoService.guardar(mov).subscribe({
      next: () => { this.cargarProductos(); this.movimientoSalida = { tipo: 'SALIDA' }; },
      error: (e: any) => alert(e.error)
    });
  }

  ir(ruta: string) {
    this.router.navigate([ruta]);
  }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}