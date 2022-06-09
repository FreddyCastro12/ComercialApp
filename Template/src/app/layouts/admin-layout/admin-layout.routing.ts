import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { ProductoComponent } from 'src/app/pages/producto/producto.component';
import { LocalComponent } from 'src/app/pages/local/local.component';
import { ServicioComponent } from 'src/app/pages/servicio/servicio.component';
import { LoginGuard } from 'src/app/LoginGuard';
import { MiCarritoComponent } from 'src/app/pages/mi-carrito/mi-carrito.component';
import { MenuComponent } from 'src/app/pages/menu/menu.component';
import { ClientComponent } from 'src/app/pages/client/client.component';
import { CoinsComponent } from 'src/app/pages/coins/coins.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent, canActivate: [LoginGuard] },
    { path: 'tables',         component: TablesComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'producto',       component: ProductoComponent, canActivate: [LoginGuard] },
    { path: 'local',          component: LocalComponent, canActivate: [LoginGuard] },
    { path: 'servicio',       component: ServicioComponent, canActivate: [LoginGuard] },
    { path: 'mi-carrito',     component: MiCarritoComponent, canActivate: [LoginGuard] },
    { path: 'menu',           component: MenuComponent, canActivate: [LoginGuard] },
    { path: 'client',         component: ClientComponent, canActivate: [LoginGuard] },
    { path: 'coins',          component: CoinsComponent, canActivate: [LoginGuard] },
];
