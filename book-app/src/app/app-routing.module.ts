import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./book/home.component";
import {BookListComponent} from "./book/bookList.component";
import {BookComponent} from "./book/book.component";
import {PublisherListComponent} from "./publisher/publisherList.component";
import {PublisherComponent} from "./publisher/publisher.component";
import {AuthorListComponent} from "./author/authorList.component";
import {AuthorComponent} from "./author/author.component";
import {PageNotFoundComponent} from "./others/pageNotFound.component";
import {NgModule} from "@angular/core";

const appRoutes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'book', component: BookListComponent},
  {path: 'addBook', component: BookComponent},
  {path: 'publisher', component: PublisherListComponent},
  {path: 'addpublisher', component: PublisherComponent},
  {path: 'author', component: AuthorListComponent},
  {path: 'addauthor', component: AuthorComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, {
    useHash: false,
    enableTracing: false,
    scrollPositionRestoration: 'top'
  })],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
