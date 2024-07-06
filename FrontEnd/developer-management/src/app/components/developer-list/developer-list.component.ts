import { Component, OnInit } from '@angular/core';
import { DeveloperService } from '../../service/developer.service';
import { CommonModule } from '@angular/common';
import { Developer } from '../../interface/Developer';

@Component({
  selector: 'app-developer-list',
  templateUrl: './developer-list.component.html',
  styleUrls: ['./developer-list.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class DeveloperListComponent implements OnInit {

  developers: Developer[] = [];

  constructor(private developerService: DeveloperService) { }

  ngOnInit() {
    this.loadDevelopers();
  }

  loadDevelopers(): void {
    this.developerService.getDevelopers().subscribe(data => {
      this.developers = data;
    });
  }

  deleteDeveloper(developerId: number): void {
    if (confirm("Are you sure you want to delete this developer?")) {
      this.developerService.deleteDeveloper(developerId).subscribe(
        () => {
          console.log('Developer deleted successfully');
          this.developers = this.developers.filter(dev => dev.id !== developerId);
        },
        error => {
          console.error('Error deleting developer', error);
        }
      );
    }
  }
}
