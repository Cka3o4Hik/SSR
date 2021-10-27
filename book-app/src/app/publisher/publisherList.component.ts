import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PublisherService } from './publisher.service';
import { Publisher } from './publisher';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import {Subscription} from "rxjs";


@Component({
    selector: 'publisher-list',
    templateUrl: './publisherList.component.html',
    styleUrls: ['./publisherList.component.css']
})
export class PublisherListComponent implements OnInit{

      statusMessage: string = "";
      publishers: Publisher[] = [];
      constructor(private _publisherService: PublisherService,
        private _router: Router){
      }

      ngOnInit(): void {
        console.info("calling ngOnInit()::::");
        this.getPublishers();
      }

      getPublishers(): Subscription {
        console.info("Inside getpublishers():::::")
        return this._publisherService.getAllPublishers()
          .subscribe((publisherData) => this.publishers = publisherData,
            (error) =>{
              console.error(error);
              this.statusMessage = "Problem with service. Please try again later!";
            }
          );
        console.log("end of getpublishers():::::");
    }
}
