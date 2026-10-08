import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login';
import { DashboardAdminComponent } from './components/dashboard-admin/dashboard-admin';
import { DashboardOperativoComponent } from './components/dashboard-operativo/dashboard-operativo';
import { ClientesComponent } from './components/clientes/clientes';
import { ProductosComponent } from './components/productos/productos';
import { PedidosComponent } from './components/pedidos/pedidos';
import { MovimientosComponent } from './components/movimientos/movimientos';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: DashboardAdminComponent },
  { path: 'operativo', component: DashboardOperativoComponent },
  { path: 'clientes', component: ClientesComponent },
  { path: 'productos', component: ProductosComponent },
  { path: 'pedidos', component: PedidosComponent },
  { path: 'movimientos', component: MovimientosComponent },
  { path: '**', redirectTo: 'login' }
];