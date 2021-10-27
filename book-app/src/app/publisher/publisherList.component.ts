import {Component, OnInit, Output, EventEmitter, ViewChild, AfterViewInit} from '@angular/core';
import { PublisherService } from './publisher.service';
import { Publisher } from './publisher';
import { Router, ActivatedRoute, ParamMap  } from '@angular/router';
import {Subscription} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";


@Component({
    selector: 'publisher-list',
    templateUrl: './publisherList.component.html',
    styleUrls: ['./publisherList.component.css']
})
export class PublisherListComponent implements OnInit, AfterViewInit {
      displayedColumns: string[] = ['id', 'city', 'name'];
      statusMessage: string = "";
      publishers: Publisher[] = [];
      dataSource = new MatTableDataSource<Publisher>(this.publishers)
      constructor(private _publisherService: PublisherService,
                  private _router: Router){
      }

      ngOnInit(): void {
        console.info("calling ngOnInit()::::");
        this.getPublishers();
      }

      // @ViewChild(MatPaginator) paginator: MatPaginator;

      ngAfterViewInit() {
        // this.dataSource.paginator = this.paginator;
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
