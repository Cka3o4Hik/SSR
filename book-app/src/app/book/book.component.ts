import {Component, OnInit, OnChanges} from '@angular/core';
import {Router} from '@angular/router';
import {BookService} from './book.service';
import {book} from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit, OnChanges {

  books: book[] = [];
  statusMessage: string = "";
  book = new book();

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

  addBook(): void {
    console.log('1 - ', this.book)
    this._bookService.addBook(this.book).subscribe((data) => {
      const d = JSON.parse(<string>data);
      console.log(typeof (d));

    });
  }

  private reset() {
    console.log("inside the reset():::::::");
    this.book.id = "0";
    this.book.name = "null";
    this.book.author = "null";
    this.book.series = "null";
    this.book.isbn = "0";
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
