import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { DeveloperListComponent } from './components/developer-list/developer-list.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { AuthGuard } from './auth/auth.guard';

export const routes: Routes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'developer-list', component: DeveloperListComponent},
    { path: 'not-found', component: NotFoundComponent },
    { path: '**', redirectTo: '/not-found' }
];
