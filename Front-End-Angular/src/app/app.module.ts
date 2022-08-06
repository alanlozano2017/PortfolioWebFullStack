import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EncabezadoComponent } from './componentes/encabezado/encabezado.component';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { HttpClientModule } from '@angular/common/http';
import { EducacionComponent } from './componentes/educacion/educacion.component';
import { LogosComponent } from './componentes/logos/logos.component';
import { BannerComponent } from './componentes/banner/banner.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { SkillsComponent } from './componentes/skills/skills.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProyectosComponent } from './componentes/proyectos/proyectos.component';


@NgModule({
  declarations: [
    AppComponent,
    EncabezadoComponent,
    ExperienciaComponent,
    EducacionComponent,
    LogosComponent,
    BannerComponent,
    FooterComponent,
    SkillsComponent,
    ProyectosComponent

    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgCircleProgressModule.forRoot({})
    

  ],
  providers: [
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
