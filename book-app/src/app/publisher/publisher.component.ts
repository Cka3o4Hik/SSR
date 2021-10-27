import {Component, OnInit, OnChanges} from '@angular/core';
import {Router} from '@angular/router';
import {PublisherService} from './publisher.service';
import {Publisher} from './publisher';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit, OnChanges {

  publishers: Publisher[] = [];
  statusMessage: string = "";
  publisher = new Publisher();

  constructor(private _publisherService: PublisherService,
              private _router: Router) {
  }

  ngOnInit(): void {
    console.log("calling ngOnInit()::::");
    this.getPublishers();
  }

  getPublishers(): void {
    console.log("Inside getpublishers():::::")
    this._publisherService.getAllPublishers()
      .subscribe((publisherData) => this.publishers = publisherData,
        (error) => {
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
    console.log("end of getpublishers():::::");
  }

  addPublisher(): void {
    console.log('1 - ', this.publisher)
    this._publisherService.addPublisher(this.publisher).subscribe((data) => {
      const d = JSON.parse(<string>data);
      console.log(typeof (d));

    });
  }

  private reset() {
    console.log("inside the reset():::::::");
    this.publisher.id = "0";
    this.publisher.city = "null";
    this.publisher.name = "null";
    console.log("end of reset():::::::");
  }

  ngOnChanges(changes: any) {
    console.log("calling ngOnChanges()::::::::");
  }

  deletePublisher(publisherId: string) {
    console.log("Inside the deletepublisher()::::publisher id::::" + publisherId);
    this.reset();
    console.log("end of deletepublisher():::::::");
  }

  getPublisher(publisherId: string) {
    console.log('1');
    console.log("Inside the updatepublisher()::::::publisher id::::" + publisherId);
    this._publisherService.getPublisherById(publisherId)
      .subscribe((publisherData) => {
        this.publisher = publisherData;
        this.getPublishers();
      })
    this.reset();
    console.log("end of updatepublisher()::::::");
  }
}
