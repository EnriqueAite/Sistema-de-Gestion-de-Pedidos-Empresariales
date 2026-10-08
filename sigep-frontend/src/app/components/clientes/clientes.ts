import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { ClienteService } from '../../services/cliente';
import { AuthService } from '../../services/auth';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './clientes.html'
})
export class ClientesComponent implements OnInit {
  clientes: any[] = [];
  cliente: any = {};
  editando = false;
  nombre: string;

  constructor(
    private clienteService: ClienteService,
    private authService: AuthService,
    private router: Router
  ) {
    this.nombre = this.authService.obtenerNombre();
  }

  ngOnInit() { this.cargar(); }

  cargar() {
    this.clienteService.listar().subscribe((data: any[]) => this.clientes = data);
  }

  guardar() {
    if (this.editando) {
      this.clienteService.actualizar(this.cliente.id_cliente, this.cliente)
        .subscribe(() => { this.cargar(); this.limpiar(); });
    } else {
      this.clienteService.guardar(this.cliente)
        .subscribe(() => { this.cargar(); this.limpiar(); });
    }
  }

  editar(c: any) {
    this.cliente = { ...c };
    this.editando = true;
  }

  eliminar(id: number) {
    this.clienteService.eliminar(id).subscribe(() => this.cargar());
  }

  limpiar() {
    this.cliente = {};
    this.editando = false;
  }

  volver() { this.router.navigate(['/admin']); }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }
}