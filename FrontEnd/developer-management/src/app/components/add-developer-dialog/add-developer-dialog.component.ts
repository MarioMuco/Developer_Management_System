import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { DeveloperService } from '../../service/developer.service';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-add-developer-dialog',
  templateUrl: './add-developer-dialog.component.html',
  styleUrls: ['./add-developer-dialog.component.scss'] ,
  standalone: true,
  imports: [
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ]
})
export class AddDeveloperDialogComponent {
  addDeveloperForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddDeveloperDialogComponent>,
    private developerService: DeveloperService
  ) {
    this.addDeveloperForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      skills: [''],
      experience: [''],
      profilePhoto: ['']
    });
  }

  onSubmit() {
    if (this.addDeveloperForm.valid) {
      const newDeveloper = this.addDeveloperForm.value;
      this.developerService.postDevelopers(newDeveloper).subscribe(() => {
        this.dialogRef.close(true);
      });
    }
  }

  onCancel() {
    this.dialogRef.close(false);
  }
}
