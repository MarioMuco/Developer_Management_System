# Developer Management System
## Lufthansa Industry Solutions Hackathon

### Profile Management
- Manage developer profiles with funcionalities to add, remove, edit and delete.

### Search Funcionality
- Ability to search for developers by name, skills and experience.

### Project History
- Maintain a history of projects each developer has worked on.
 







### Entity Relationship Diagram

![image](https://github.com/MarioMuco/Developer_Management_System/assets/45602326/7f407bfb-bbbb-4dfc-a414-d1fa5807dcdf)

`
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
`

