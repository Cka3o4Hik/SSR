import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { BookService } from './book.service';
import { book } from './book';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import {Subscription} from "rxjs";


@Component({
    selector: 'book-list',
    templateUrl: './bookList.component.html',
    styleUrls: ['./bookList.component.css']
})
export class BookListComponent implements OnInit{

      statusMessage: string = "";
      books: book[] = [];
      constructor(private _bookService: BookService,
        private _router: Router){
      }

      ngOnInit(): void {
        console.info("calling ngOnInit()::::");
        this.getBooks();
      }

      getBooks(): Subscription {
        console.info("Inside getbooks():::::")
        return this._bookService.getAllbooks()
          .subscribe((bookData) => this.books = bookData,
            (error) =>{
              console.error(error);
              this.statusMessage = "Problem with service. Please try again later!";
            }
          );
        console.log("end of getbooks():::::");
    }
}
