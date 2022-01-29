import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faGithub } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  faGithub = faGithub;
  
  constructor(public router: Router) { }

  ngOnInit(): void {
  }

}
