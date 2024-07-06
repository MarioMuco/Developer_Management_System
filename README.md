# Developer Management System
## Lufthansa Industry Solutions Hackathon

### Profile Management
- Manage developer profiles with funcionalities to add, remove, edit and delete.
- Design the profile addition form with fields like name, skills, experience, and profile photo.
- Implement the API to submit new profile data to the database.
- Create validations for the input fields to ensure data integrity.
- Design the edit profile form pre-populated with existing data.
- Implement the API to update profile data in the database.
- Ensure fields are validated similarly to the profile addition.
- Implement a delete option in the UI.
- Add a confirmation dialog to prevent accidental deletions.
- Implement the API to remove profile data from the database.
- Design and implement a UI to list developer profiles.
- Implement pagination to handle large numbers of profiles.

### Search Funcionality
- Ability to search for developers by name, skills and experience.
- Design and implement a search bar and advanced filters in the UI.
- Implement the API to fetch filtered data based on the search criteria.

### Project History
- Maintain a history of projects each developer has worked on.
- Update the profile data model to include project history
- Design UI components to display and add project history in profiles.
- Implement the API to handle adding and updating project history.
 


### Entity Relationship Diagram

![image](https://github.com/MarioMuco/Developer_Management_System/assets/45602326/7f407bfb-bbbb-4dfc-a414-d1fa5807dcdf)

```
CREATE DATABASE management;
USE management;

CREATE TABLE Developer (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    First_Name VARCHAR(255) NOT NULL,
    Last_Name VARCHAR(255) NOT NULL,
    Skills VARCHAR(255),
    Experience VARCHAR(255),
    Profile_Photo VARCHAR(255)
);

CREATE TABLE Project (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Technology VARCHAR(255),
    Added_At DATETIME
);

CREATE TABLE Developer_Project (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Developer_ID INT,
    Project_ID INT,
    FOREIGN KEY (Developer_ID) REFERENCES Developer(ID),
    FOREIGN KEY (Project_ID) REFERENCES Project(ID)
);
```

