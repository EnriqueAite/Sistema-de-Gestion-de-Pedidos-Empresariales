import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html'
})
export class LoginComponent {
  credenciales = { usuario: '', clave: '' };
  error = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.credenciales).subscribe({
      next: (data: any) => {
        this.authService.guardarSesion(data);
        if (data.usuario === 'admin') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/operativo']);
        }
      },
      error: () => {
        this.error = 'Usuario o clave incorrecta.';
      }
    });
  }
}