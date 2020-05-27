import {Injectable} from '@angular/core';
import {HEROES} from './mock-heroes';
import {Observable, of} from 'rxjs';
import {Hero} from '../model/hero';
import {delay, tap} from 'rxjs/operators';
import {MessageService} from './message.service';

@Injectable()
export class HeroService {

  constructor(private messageService: MessageService) {
  }

  getHeroes(): Observable<Hero[]> {
    // this.messageService.add('HeroService: fetched heroes');
    return of(HEROES)
      .pipe(delay(200))
      .pipe(tap(x => this.messageService.add('HeroService: fetched heroes')));
  }

  getHero(id: number): Observable<Hero> {
    this.messageService.add(`HeroService: fetched hero id = ${id}`);
    return of(HEROES.find(hero => hero.id === id));
  }
}
