import {Component, OnInit, OnChanges} from '@angular/core';
import {Router} from '@angular/router';
import {AuthorService} from './author.service';
import {Author} from './author';
import {Book} from "../book/book";

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit, OnChanges {

  authors: Author[] = [];
  statusMessage: string = "";
  author = new Author();

  constructor(private _authorService: AuthorService,
              private _router: Router) {
  }

  ngOnInit(): void {
    console.log("calling ngOnInit()::::");
    this.getAuthors();
  }

  getAuthors(): void {
    console.log("Inside getauthors():::::")
    this._authorService.getAllAuthors()
      .subscribe((authorData) => this.authors = authorData,
        (error) => {
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
    console.log("end of getauthors():::::");
  }

  addAuthor(): void {
    console.log('1 - ', this.author)
    this._authorService.addAuthor(this.author).subscribe((data) => {
      const d = JSON.parse(<string> data);
      console.log(typeof (d));

    });
  }

  private reset() {
    console.log("inside the reset():::::::");
    this.author.id = "0";
    this.author.birth = "null";
    this.author.createdDate = "null";
    this.author.email = "null";
    this.author.firstName = "0";
    this.author.lastName = "0";
    this.author.book= new Book();
    console.log("end of reset():::::::");
  }

  ngOnChanges(changes: any) {
    console.log("calling ngOnChanges()::::::::");
  }

  deleteAuthor(authorId: string) {
    console.log("Inside the deleteauthor()::::author id::::" + authorId);
    this.reset();
    console.log("end of deleteauthor():::::::");
  }

  getAuthor(authorId: string) {
    console.log('1');
    console.log("Inside the updateauthor()::::::author id::::" + authorId);
    this._authorService.getAuthorById(authorId)
      .subscribe((authorData) => {
        this.author = authorData;
        this.getAuthors();
      })
    this.reset();
    console.log("end of updateauthor()::::::");
  }
}