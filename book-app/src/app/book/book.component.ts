import {Component, OnInit, OnChanges} from '@angular/core';
import {Router} from '@angular/router';
import {BookService} from './book.service';
import {Book} from './book';
import {Author} from "../author/author";
import {Publisher} from "../publisher/publisher";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit, OnChanges {
  displayedColumns: string[] = ['id', 'createdDate', 'isbn', 'name', 'series', 'author', 'publisher'];
  books: Book[] = [];
  statusMessage: string = "";
  book = new Book();

  constructor(private _bookService: BookService,
              private _router: Router) {
  }

  ngOnInit(): void {
    console.log("calling ngOnInit()::::");
    this.getbooks();
  }

  getbooks(): void {
    console.log("Inside getbooks():::::")
    this._bookService.getAllbooks()
      .subscribe((bookData) => this.books = bookData,
        (error) => {
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
    console.log("end of getbooks():::::");
  }

  saveBook(): void {
    console.log('1 - ', this.book)
    this._bookService.saveBook(this.book).subscribe((data) => {
      this.books.push(<Book>data);
      this.books = this.books.map((data) => data);
    });
  }

  private reset() {
    console.log("inside the reset():::::::");
    this.book.id = "0";
    this.book.name = "null";
    this.book.authors = [];
    this.book.publisher = new Publisher();
    this.book.series = "null";
    this.book.isbn = -1;
    console.log("end of reset():::::::");
  }

  ngOnChanges(changes: any) {
    console.log("calling ngOnChanges()::::::::");
  }

  deletebook(bookId: string) {
    console.log("Inside the deletebook()::::book id::::" + bookId);
    this.reset();
    console.log("end of deletebook():::::::");
  }

  getbook(bookId: string) {
    console.log('1');
    console.log("Inside the updatebook()::::::book id::::" + bookId);
    this._bookService.getbookById(bookId)
      .subscribe((bookData) => {
        this.book = bookData;
        this.getbooks();
      })
    this.reset();
    console.log("end of updatebook()::::::");
  }
}
