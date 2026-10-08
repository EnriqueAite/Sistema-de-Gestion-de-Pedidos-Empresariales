import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ProductoService } from '../../services/producto';
import { AuthService } from '../../services/auth';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './productos.html'
})
export class ProductosComponent implements OnInit {
  productos: any[] = [];
  empresas: any[] = [];
  categorias: any[] = [];
  producto: any = {};
  editando = false;
  nombre: string;

  constructor(
    private productoService: ProductoService,
    private authService: AuthService,
    private router: Router,
    private http: HttpClient
  ) {
    this.nombre = this.authService.obtenerNombre();
  }

  ngOnInit() {
    this.cargar();
    this.http.get<any[]>('http://localhost:8080/api/empresas').subscribe((d: any[]) => this.empresas = d);
    this.http.get<any[]>('http://localhost:8080/api/categorias').subscribe((d: any[]) => this.categorias = d);
  }

  cargar() {
    this.productoService.listar().subscribe((data: any[]) => this.productos = data);
  }

  guardar() {
    if (this.editando) {
      this.productoService.actualizar(this.producto.id_producto, this.producto)
        .subscribe(() => { this.cargar(); this.limpiar(); });
    } else {
      this.productoService.guardar(this.producto)
        .subscribe(() => { this.cargar(); this.limpiar(); });
    }
  }

  editar(p: any) {
    this.producto = { ...p, id_empresa: p.id_empresa, id_categoria: p.id_categoria };
    this.editando = true;
  }

  eliminar(id: number) {
    this.productoService.eliminar(id).subscribe(() => this.cargar());
  }

  limpiar() {
    this.producto = {};
    this.editando = false;
  }

  volver() { this.router.navigate(['/admin']); }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}