import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Book} from './book';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class BookService {

  constructor(private _httpService: HttpClient) {
  }

  getAllbooks(): Observable<Book[]> {
    console.log("inside the service getAllbooks():::::::");
    return this._httpService.get<Book[]>("http://localhost:8080/api/book");
  }

  getbookById(bookId: string): Observable<Book> {
    console.log("Inside the getbookById() service::::::");
    return this._httpService.jsonp<Book>("http://localhost:8080/api/book/" + bookId,
      'callback');
  }

  saveBook(book: Book) {
    if (book.id) {
      console.log("Inside addbook update service():::::::");
      return this._httpService.put("http://localhost:8080/api/book/" + book.id, book);
    } else {
      console.log("Inside addbook add service():::::::");
      return this._httpService.post("http://localhost:8080/api/book", book);
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
