import { Component, OnInit } from '@angular/core';
import { Search } from '../search';
import { Router } from '@angular/router';
import { faInfoCircle, faSearch } from '@fortawesome/free-solid-svg-icons';
import { MRDBService } from '../mrdb.service';
import { faGithub } from '@fortawesome/free-brands-svg-icons';
import { CookieService } from 'ngx-cookie-service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  faSearch = faSearch;
  faGithub = faGithub;
  faInfoCircle = faInfoCircle
  search: Search[];
  formerror: String;

  constructor(private mrdbService: MRDBService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {
  }

  onSubmit(data: any) {

    this.btnLoader(true);

    if (data.search == "") {

      this.formerror = "Field is required";
      this.btnLoader(false);

    } else if (localStorage.getItem(data.search) !== null) {

      this.search = JSON.parse(localStorage.getItem(data.search)!);

      this.routing(this.search, data);

    } else {

      this.mrdbService.getSearch(data).subscribe(
        (reponse) => {

          if (reponse == null) {

            this.formerror = "No results for \"" + data.search + "\"";
            this.btnLoader(false);

          } else if (this.mrdbService.errorAPI != undefined && this.mrdbService.errorAPI != "") {

            this.formerror = this.mrdbService.errorAPI;
            this.mrdbService.errorAPI = "";
            this.btnLoader(false);

          } else {

            this.search = reponse;
            localStorage.setItem(data.search, JSON.stringify(this.search));
            this.routing(this.search, data);

          }
        }
      );
    }
  }

  routing(search: Search[], data: any) {
    this.mrdbService.searchReponse = search;
    this.mrdbService.searchRequest = data.search;
    this.cookieService.set('searchRequest', data.search);
    return this.router.navigate(['/search']);
  }

  btnLoader(statut: boolean) {
    var submit_btn = document.getElementById('search_btn');
    if (submit_btn != null) {
      if (statut) {
        submit_btn.classList.add('is-loading');
      } else {
        submit_btn.classList.remove('is-loading');
      }
    }
  }
}

