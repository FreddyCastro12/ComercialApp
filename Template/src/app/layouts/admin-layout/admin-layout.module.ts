import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';

import { ClipboardModule } from 'ngx-clipboard';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ProductoComponent } from 'src/app/pages/producto/producto.component';
import { LocalComponent } from 'src/app/pages/local/local.component';
import { ServicioComponent } from 'src/app/pages/servicio/servicio.component';
import { LoginGuard } from 'src/app/LoginGuard';
import { NoLoginGuard } from 'src/app/no-login.guard';
import { MenuComponent } from 'src/app/pages/menu/menu.component';
import { ClientComponent } from 'src/app/pages/client/client.component';
// import { ToastrModule } from 'ngx-toastr';
import { CoinsComponent } from 'src/app/pages/coins/coins.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
    ClipboardModule,
    ReactiveFormsModule
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    TablesComponent,
    IconsComponent,
    MapsComponent,
    ProductoComponent,
    LocalComponent,
    ServicioComponent,
    MenuComponent,
    ClientComponent,
    CoinsComponent
  ],
  providers: [LoginGuard, NoLoginGuard],
})

export class AdminLayoutModule {}
