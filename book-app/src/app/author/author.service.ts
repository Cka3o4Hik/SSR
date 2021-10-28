import {Injectable} from '@angular/core';
import {Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Author} from './author';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthorService {

  constructor(private _httpService: HttpClient) {
  }

  getAllAuthors() : Observable<Author[]> {
    console.log("inside the service getAllauthors():::::::");
    return this._httpService.get<Author[]>("http://localhost:8080/api/author");
  }

  getAuthorById(authorId: string): Observable<Author> {
    console.log("Inside the getauthorById() service::::::");
    return this._httpService.jsonp<Author>("http://localhost:8080/api/author/" + authorId,
      'callback');
  }

  saveAuthor(author: Author) {
    if (author.id) {
      console.log("Inside addauthor update service():::::::");
      return this._httpService.put("http://localhost:8080/api/author/" + author.id, author);
    } else {
      console.log("Inside addauthor add service():::::::");
      return this._httpService.post("http://localhost:8080/api/author", author);
    }
  }
  ///Gradle___ua_nic___SSR_1_0_SNAPSHOT_war
  deleteAuthor(authorId: string) {
    console.log("Inside the service deleteauthor():::::author id:::" + authorId);
    return this._httpService.delete("http://localhost:8080/api/author/" + authorId);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error);
  }
}
