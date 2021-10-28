import {Book} from "../book/book";

export class Author {
  id: string;
  birth: string;
  createdDate: string;
  email: string;
  firstName: string;
  lastName: string;
  books:Book[];


  constructor() {
    this.id = "";
    this.birth = ""
    this.createdDate = ""
    this.email = ""
    this.firstName= "";
    this.lastName= "";
    this.books = [];

  }
}
