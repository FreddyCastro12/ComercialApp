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

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent, canActivate: [LoginGuard] },
    { path: 'tables',         component: TablesComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    { path: 'producto',       component: ProductoComponent, canActivate: [LoginGuard] },
    { path: 'local',          component: LocalComponent, canActivate: [LoginGuard] },
    { path: 'servicio',       component: ServicioComponent, canActivate: [LoginGuard] },
];
