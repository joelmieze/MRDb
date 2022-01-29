import { Component, OnInit } from '@angular/core';
import { Search } from '../search';
import { Router } from '@angular/router';
import { MRDBService } from '../mrdb.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit {

  search: Search[];
  searchRequest: string;

  constructor(private mrdbService: MRDBService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {

    const searchRequest = this.cookieService.get('searchRequest');

    if (searchRequest != "" && localStorage.getItem(searchRequest) !== null && (this.mrdbService.searchRequest == undefined || this.mrdbService.searchRequest == searchRequest)) {

      this.searchRequest = searchRequest;
      this.search = JSON.parse(localStorage.getItem(searchRequest)!);

    } else if (this.mrdbService.searchRequest != undefined) {

      this.searchRequest = this.mrdbService.searchRequest;
      this.search = this.mrdbService.searchReponse;

    } else {

      this.router.navigate(['/']);

    }
  }

  btnLoader(imdbid: string) {
    var see_more_btn = document.getElementById(imdbid);
    if (see_more_btn != null) {
      see_more_btn.classList.add('is-loading');
    }
  }

}
