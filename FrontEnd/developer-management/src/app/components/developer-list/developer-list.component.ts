import { Component, OnInit } from '@angular/core';
import { DeveloperService } from '../../service/developer.service';
import { CommonModule } from '@angular/common';
import { Developer } from '../../interface/Developer';
import { AddDeveloperDialogComponent } from '../add-developer-dialog/add-developer-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-developer-list',
  templateUrl: './developer-list.component.html',
  styleUrls: ['./developer-list.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
  ]
})
export class DeveloperListComponent implements OnInit {

  developers: Developer[] = [];

  constructor(private developerService: DeveloperService, private dialog: MatDialog) { }

  ngOnInit() {
    this.loadDevelopers();
  }

  loadDevelopers(): void {
    this.developerService.getDevelopers().subscribe(data => {
      this.developers = data;
    });
  }

  openAddDeveloperDialog() {
    const dialogRef = this.dialog.open(AddDeveloperDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadDevelopers();
      }
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
