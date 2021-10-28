import {Component, OnInit, Output, EventEmitter, AfterViewInit, ViewChild} from '@angular/core';
import { BookService } from './book.service';
import {Book} from './book';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import {Subscription} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";

@Component({
    selector: 'book-list',
    templateUrl: './bookList.component.html',
    styleUrls: ['./bookList.component.css']
})
export class BookListComponent implements OnInit, AfterViewInit{

      displayedColumns: string[] = ['id', 'createdDate', 'isbn', 'name', 'series', 'author', 'publisher'];
      statusMessage: string = "";
      books: Book[] = [];
      /*dataSource = new MatTableDataSource<Book>(this.books)*/
      constructor(private _bookService: BookService,
        private _router: Router){
      }

      ngOnInit(): void {
        console.info("calling ngOnInit()::::");
        this.getBooks();
      }

      /*@ViewChild(MatPaginator) paginator: MatPaginator;*/
      ngAfterViewInit() {
        /*this.dataSource.paginator = this.paginator;*/
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
