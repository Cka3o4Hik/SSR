import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthorService } from './author.service';
import { Author } from './author';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import {Subscription} from "rxjs";


@Component({
    selector: 'author-list',
    templateUrl: './authorList.component.html',
    styleUrls: ['./authorList.component.css']
})
export class AuthorListComponent implements OnInit{

      displayedColumns: string[] = ['id', 'birth', 'createdDate','email','firstName','lastName', 'book'];
      statusMessage: string = "";
      authors: Author[] = [];
      constructor(private _authorService: AuthorService,
        private _router: Router){
      }

      ngOnInit(): void {
        console.info("calling ngOnInit()::::");
        this.getAuthors();
      }

      getAuthors(): Subscription {
        console.info("Inside getauthors():::::")
        return this._authorService.getAllAuthors()
          .subscribe((authorData) => this.authors = authorData,
            (error) =>{
              console.error(error);
              this.statusMessage = "Problem with service. Please try again later!";
            }
          );
        console.log("end of getauthors():::::");
    }
}
