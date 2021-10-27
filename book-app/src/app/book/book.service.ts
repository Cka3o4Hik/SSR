import {Injectable} from '@angular/core';
import {Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {book} from './book';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BookService {

  constructor(private _httpService: HttpClient) {
  }

  getAllbooks() : Observable<book[]> {
    console.log("inside the service getAllbooks():::::::");
    return this._httpService.get<book[]>("http://localhost:8080/api/book");
  }

  getbookById(bookId: string): Observable<book> {
    console.log("Inside the getbookById() service::::::");
    return this._httpService.jsonp<book>("http://localhost:8080/api/book/" + bookId,
      'callback');
  }

  addBook(book: book) {
    let body = JSON.parse(JSON.stringify(book));
    // let body = book;
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    if (book.id) {
      console.log("Inside addbook update service():::::::");
      return this._httpService.put("http://localhost:8080/api/book/" + book.id, body);
    } else {
      console.log("Inside addbook add service():::::::");
      return this._httpService.post("http://localhost:8080/api/book", body);
    }
  }
  ///Gradle___ua_nic___SSR_1_0_SNAPSHOT_war
  deleteBook(bookId: string) {
    console.log("Inside the service deletebook():::::book id:::" + bookId);
    return this._httpService.delete("http://localhost:8080/api/book/" + bookId);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error);
  }
}
