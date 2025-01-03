import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientComponent } from './client/client.component';
import { VoitureComponent } from './voiture/voiture.component';
import { ReservervoitureComponent } from './reservervoiture/reservervoiture.component';
import { ClientavecvoitureComponent } from './clientavecvoiture/clientavecvoiture.component';

const routes: Routes = [
  { path: '', redirectTo: '/client', pathMatch: 'full' },
  { path: 'client', component: ClientComponent },
  { path: 'voiture', component: VoitureComponent },
  { path: 'reservervoiture', component: ReservervoitureComponent },
  { path: 'clientavecvoiture', component: ClientavecvoitureComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
