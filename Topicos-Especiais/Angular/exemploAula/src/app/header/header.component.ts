import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `<h1>{{title}}</h1>
              <p>Bem vindo, {{user.name}}</p>`
})
export class HeaderComponent implements OnInit {
  title = 'Meu primeiro componente';
  user = {name: 'Henrique'};
  constructor() { }

  ngOnInit(): void {
  }

}
