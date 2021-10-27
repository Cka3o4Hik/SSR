import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {BookService} from './book/book.service';
import {BookComponent} from './book/book.component';
import {BookListComponent} from './book/bookList.component';
import {AuthorComponent} from './author/author.component';
import {AuthorListComponent} from './author/authorList.component';
import {PublisherComponent} from './publisher/publisher.component';
import {PublisherListComponent} from './publisher/publisherList.component';
import {PageNotFoundComponent} from './others/pageNotFound.component';
import {HomeComponent} from './book/home.component';
import {HttpClientModule} from "@angular/common/http";
import {PublisherService} from "./publisher/publisher.service";
import {AuthorService} from "./author/author.service";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'book', component: BookListComponent},
  {path: 'addbook', component: BookComponent},
  {path: 'publisher', component: PublisherListComponent},
  {path: 'addpublisher', component: PublisherComponent},
  {path: 'author', component: AuthorListComponent},
  {path: 'addauthor', component: AuthorComponent},
  {path: '**', component: PageNotFoundComponent}
];


@NgModule({
  declarations: [
    AppComponent, BookComponent, BookListComponent, AuthorComponent, AuthorListComponent,
    PublisherComponent, PublisherListComponent, HomeComponent, PageNotFoundComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, RouterModule.forRoot(appRoutes), BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [BookService, PublisherService, AuthorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
