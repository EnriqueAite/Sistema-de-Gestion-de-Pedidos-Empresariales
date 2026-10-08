import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth';

@Component({
  selector: 'app-dashboard-admin',
  standalone: true,
  templateUrl: './dashboard-admin.html'
})
export class DashboardAdminComponent {
  nombre: string;

  constructor(private authService: AuthService, private router: Router) {
    this.nombre = this.authService.obtenerNombre();
  }

  cerrarSesion() {
    this.authService.cerrarSesion();
    this.router.navigate(['/login']);
  }

  ir(ruta: string) {
    this.router.navigate([ruta]);
  }
}