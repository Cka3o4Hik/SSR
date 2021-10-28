import {Publisher} from "../publisher/publisher";
import {Author} from "../author/author";

export class Book {
  id: string;
  createdDate: Date;
  name: string;
  series: string;
  isbn: number;
  author: Author;
  publisher: Publisher;

  constructor() {
    this.id = "";
    this.name = ""
    this.author = new Author();
    this.publisher = new Publisher();
    this.series = ""
    this.isbn = -1;
    this.createdDate = new Date();
  }
}
