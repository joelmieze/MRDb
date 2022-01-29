import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Movie } from '../movie';
import { MRDBService } from '../mrdb.service';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.scss']
})
export class MovieComponent implements OnInit {

  movie: Movie[];
  isLoaded: boolean = false;

  constructor(private router: Router, private route: ActivatedRoute, private mrdbService: MRDBService) { }

  ngOnInit(): void {

    const imdbid = this.route.snapshot.paramMap.get('imdbid');

    if (imdbid != undefined) {

      if (localStorage.getItem(imdbid) !== null) {

        this.movie = JSON.parse(localStorage.getItem(imdbid)!);
        this.isLoaded = true;

      } else {

        this.mrdbService.getMovie(imdbid).subscribe(
          reponse => {
            if (reponse == null || (this.mrdbService.errorAPI != undefined && this.mrdbService.errorAPI != "")) {
              this.router.navigate(['/']);
            } else {
              this.movie = reponse;
              this.isLoaded = true;
              localStorage.setItem(imdbid, JSON.stringify(this.movie));
            }
          }
        );

      }
    } else {
      this.router.navigate(['/']);
    }

  }

  formatRating(value: string) {
    return parseInt(value) / 10;
  }

  getAverage(imdb: string, rottenTomatoes: string, metacritic: string) {
    return Math.round(((parseFloat(imdb) + this.formatRating(rottenTomatoes) + this.formatRating(metacritic)) / 3) * 10);
  }

  hasRating(value: string) {
    if (value != null && value != "N/A") {
      return true;
    } else {
      return false;
    }
  }
}