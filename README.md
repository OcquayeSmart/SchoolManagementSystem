# School Management System

> A console-based Java application that handles the core administrative processes of an educational institution. Built entirely from scratch as part of my #100DaysOfCode journey.

---

## Highlights

- Multi-user login system with role based access control
- Three distinct portals: Admin, Student and Teacher
- Full applicant pipeline: register, review, accept or reject
- Auto-generated login credentials for new students and teachers
- Input validation throughout with no crashes on bad input
- Built with pure Java OOP, no frameworks yet lol

---

## Overview

Schools in Ghana still manage student records, staff data and admissions on paper. This project is a step toward in changing that.

The School Management System is designed to digitize these operations through a clean console interface. An admin can register applicants, review their applications, enrol accepted students into classes and manage teaching and non-teaching staff. Students and teachers also have their own secure portal.

This is version 1. The roadmap leads to a full web based system with a database, REST API and a frontend any school administrator could use without technical knowledge.

---

## Usage

Run the program and log in with the default admin credentials:  
Username: admin  
Password: admin123  

From there the admin can set up the school by adding classes, courses and staff. When a teacher or student is added the system automatically generates their login credentials.  

**Admin Portal**

Register Applicant  
View All Applicants  
Accept Applicant  
Reject Applicant  
View Rejected Applicants  
View All Students  
Add Teaching Staff  
Add Non-Teaching Staff  
View All Staff  
Add Course  
View All Courses  
Add Class  
View All Classes  


**Student Portal**

View My Details  
View Enrolled Courses  
View Class Information  
Change Password  


**Teacher Portal**

View My Details  
View My Courses  
View Students In My Course  
Change Password  


---

## Installation

Requirements: Java 21 or higher

```bash
git clone https://github.com/OcquayeSmart/SchoolManagementSystem.git
```

Open the project in IntelliJ IDEA, navigate to `Main.java` and run it.

---

## Project Structure
SchoolManagementSystem/  
├── Main.java  
├── School.java  
├── Person.java  
├── Student.java  
├── Applicant.java  
├── Staff.java  
├── TeachingStaff.java  
├── NonTeachingStaff.java  
├── Course.java  
├── Classes.java  
├── User.java  
├── Role.java  
├── ClassLevel.java  
├── Department.java  
└── ApplicationStatus.java  

---

## Roadmap

- [x] Console based multi-user system
- [x] Role based access control
- [x] Applicant pipeline
- [x] Auto-generated credentials
- [x] Input validation
- [ ] SQL database integration
- [ ] Spring Boot REST API
- [ ] More to come 

---

## 👤 Author

**Ocquaye Smart Nii Attey**

- GitHub: [github.com/OcquayeSmart](https://github.com/OcquayeSmart)
- LinkedIn: [linkedin.com/in/smart-ocquaye-dev](https://www.linkedin.com/in/smart-ocquaye-dev)

*Built as part of #100DaysOfCode, Day 80+*
