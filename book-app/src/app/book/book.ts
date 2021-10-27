import {Publisher} from "../publisher/publisher";
import {Author} from "../author/author";

export class book {
  id: string;
  createdDate: Date;
  name: string;
  author: Author;
  series: string;
  isbn: number;
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
