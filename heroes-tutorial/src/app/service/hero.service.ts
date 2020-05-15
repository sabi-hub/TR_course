import { Injectable } from '@angular/core';
import {HEROES} from './mock-heroes';
import {Observable, of} from 'rxjs';
import {Hero} from '../model/hero';
import {delay} from 'rxjs/operators';

@Injectable()
export class HeroService {

  constructor() { }

  getHeroes(): Observable<Hero[]> {
    return of(HEROES).pipe(delay(5000));
  }
}
