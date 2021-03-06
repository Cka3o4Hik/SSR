import {Injectable} from '@angular/core';
import {Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {Publisher} from './publisher';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class PublisherService {

  constructor(private _httpService: HttpClient) {
  }

  getAllPublishers() : Observable<Publisher[]> {
    console.log("inside the service getAllpublishers():::::::");
    return this._httpService.get<Publisher[]>("http://localhost:8080/api/publisher");
  }

  getPublisherById(publisherId: string): Observable<Publisher> {
    console.log("Inside the getpublisherById() service::::::");
    return this._httpService.jsonp<Publisher>("http://localhost:8080/api/publisher/" + publisherId,
      'callback');
  }

  savePublisher(publisher: Publisher) {
    if (publisher.id) {
      console.log("Inside addpublisher update service():::::::");
      return this._httpService.put("http://localhost:8080/api/publisher/" + publisher.id, publisher);
    } else {
      console.log("Inside addpublisher add service():::::::");
      return this._httpService.post("http://localhost:8080/api/publisher", publisher);
    }
  }
  ///Gradle___ua_nic___SSR_1_0_SNAPSHOT_war

  deletePublisher(publisherId: string) {
    console.log("Inside the service deletepublisher():::::publisher id:::" + publisherId);
    return this._httpService.delete("http://localhost:8080/api/publisher/" + publisherId);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error);
  }
}
