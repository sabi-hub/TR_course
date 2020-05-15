import {Component, OnInit} from '@angular/core';
import {Hero} from '../model/hero';
import {HEROES} from '../service/mock-heroes';
import {HeroService} from '../service/hero.service';
import {Observable} from 'rxjs';
import {MessageService} from '../service/message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css'],
  providers: [HeroService]
})
export class HeroesComponent implements OnInit {
  // heroes = HEROES;
  heroes: Hero[];
  selectedHero: Hero;

  constructor(private heroService: HeroService, private messageService: MessageService) {
  }

  // hero: Hero = {
  //   id: 1,
  //   name: 'Windstorm'
  // };


  ngOnInit(): void {
    const observableHeroes: Observable<Hero[]> = this.heroService.getHeroes();
    observableHeroes.subscribe(value => this.heroes = value);
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
    this.messageService.add(`HeroService: Selected hero id=${hero.id}`);
  }
}
