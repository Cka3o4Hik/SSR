import {Publisher} from "../publisher/publisher";
import {Author} from "../author/author";

export class Book {
  id: string;
  createdDate: Date;
  name: string;
  series: string;
  isbn: number;
  authors: Author[];
  publisher: Publisher | null;

  constructor() {
    this.id = "";
    this.name = ""
    this.authors = [];
    this.publisher = null;
    this.series = ""
    this.isbn = -1;
    this.createdDate = new Date();
  }
}
