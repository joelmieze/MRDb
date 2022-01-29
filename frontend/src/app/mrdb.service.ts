import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Search } from './search';
import { Movie } from './movie';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MRDBService {

  searchReponse: Search[];
  searchRequest: string;
  errorAPI: string;

  constructor(private httpClient: HttpClient) { }

  getSearch(data: any): Observable<Search[]> {

    let httpParams = new HttpParams().append("search", data.search);
    
    return this.httpClient.post<Search[]>(environment.apiURL+'/search', httpParams).pipe(
      catchError(error => {
        this.errorAPI = "An error has occured, please try later.";
        //console.log(error);
        return of([]);
      })
    );

  }

  getMovie(imdbid: string): Observable<Movie[]> {
    
    let httpParams = new HttpParams().append("imdbid", imdbid);
    
    return this.httpClient.post<Movie[]>(environment.apiURL+'/movie', httpParams).pipe(
      catchError(error => {
        this.errorAPI = "An error has occured, please try later.";
        //console.log(error);
        return of([]);
      })
    );
  }

}
