import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { PedidoService } from '../../services/pedido';
import { AuthService } from '../../services/auth';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pedidos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pedidos.html'
})
export class PedidosComponent implements OnInit {
  pedidos: any[] = [];
  clientes: any[] = [];
  productos: any[] = [];
  pedido: any = {};
  nombre: string;
  usuario: string;

  constructor(
    private pedidoService: PedidoService,
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {
    this.nombre = this.authService.obtenerNombre();
    this.usuario = this.authService.obtenerUsuario();
  }

  ngOnInit() {
    this.cargar();
    this.http.get<any[]>('http://localhost:8080/api/clientes').subscribe((d: any[]) => this.clientes = d);
    this.http.get<any[]>('http://localhost:8080/api/productos').subscribe((d: any[]) => this.productos = d);
  }

  cargar() {
    this.pedidoService.listar().subscribe((data: any[]) => this.pedidos = data);
  }

  guardar() {
    this.pedidoService.guardar(this.pedido).subscribe(() => { this.cargar(); this.limpiar(); });
  }

  pagar(p: any) {
    const actualizado = { ...p, estado: 'PAGADO', fecha_pago: new Date() };
    this.pedidoService.actualizar(p.id_pedido, actualizado).subscribe(() => this.cargar());
  }

  eliminar(id: number) {
    this.pedidoService.eliminar(id).subscribe(() => this.cargar());
  }

  limpiar() { this.pedido = {}; }

  ir(ruta: string) {
    this.router.navigate([ruta]);
  }

  volver() {
    this.router.navigate([this.usuario === 'admin' ? '/admin' : '/operativo']);
  }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}