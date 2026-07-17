# 🏋️ Gym Membership Management System

A Java-based **Gym Membership Management System** developed using **Java Swing** and **Object-Oriented Programming (OOP)** principles. This desktop application provides a user-friendly graphical interface for managing gym memberships, member records, and workout plans while demonstrating the practical implementation of major OOP concepts such as **Abstraction, Encapsulation, Inheritance, and Polymorphism**.

The project was developed as an academic software engineering project to simulate a real-world gym management application. Unlike traditional console-based applications, this project features a modern GUI that allows administrators to efficiently manage member information, assign membership plans, update memberships, display customized workout plans, and permanently store member records using Java serialization.

---

## ✨ Features

- 👤 Register new gym members
- 📋 View all registered members
- 💳 Select membership type (Basic / Premium)
- 🔄 Update existing memberships
- ❌ Delete member records
- 🏋️ Display workout plans based on membership type
- 💾 Persistent data storage using Java Serialization
- 📂 Automatic loading of saved member data when the application starts
- 🖥️ Interactive Java Swing graphical user interface
- 🏛️ Modular Object-Oriented architecture

---

## 🚀 Technologies Used

- Java
- Java Swing
- Object-Oriented Programming (OOP)
- Java Collections Framework (ArrayList)
- File Handling
- Object Serialization
- IntelliJ IDEA / Eclipse / NetBeans

---

## 📚 OOP Concepts Implemented

### 🔹 Abstraction
- Implemented using the abstract `Membership` class.
- Common functionality is defined once while allowing subclasses to provide their own implementation.

### 🔹 Encapsulation
- Member data is stored using private variables.
- Controlled access is provided through getter and setter methods.

### 🔹 Inheritance
- `BasicMembership` inherits from `Membership`.
- `PremiumMembership` inherits from `Membership`.

### 🔹 Polymorphism
- Runtime polymorphism is achieved through method overriding.
- Different membership types implement their own version of the `calculateFee()` method.

---

## 📂 Collections Used

The project uses the Java Collections Framework for dynamic data management.

```java
ArrayList<Member> members;
```

The `ArrayList` stores all registered members, allowing efficient addition, deletion, updating, and retrieval of member records.

---

## 💾 File Handling

Member information is permanently stored using Java Object Serialization.

- ObjectOutputStream
- ObjectInputStream

This ensures that all member data remains available even after closing and reopening the application.

---

## 🖥️ Project Functionalities

- Add Member
- View Members
- Update Membership
- Delete Membership
- Select Membership Type
- Display Membership-Specific Workout Plans
- Save Member Data
- Automatically Load Saved Data

---

## 📁 Project Structure

```
GymMembershipManagementSystem
│
├── GymGUI.java
├── Member.java
├── Membership.java
├── BasicMembership.java
├── PremiumMembership.java
├── WorkoutPlan.java
├── MemberFileManager.java
└── members.dat
```

---

## ⚙️ How the Application Works

1. Launch the application.
2. Register a new member by entering personal details.
3. Choose a membership type (Basic or Premium).
4. The application automatically assigns the corresponding workout plan.
5. Member information is stored in an `ArrayList`.
6. All records are serialized and saved locally.
7. When the application is reopened, all previously saved member records are automatically restored.

---

## 🎯 Learning Outcomes

This project demonstrates practical implementation of:

- Object-Oriented Programming principles
- Java Swing GUI development
- Collections Framework
- File Handling
- Serialization
- Modular software design
- Desktop application development

---

## 🔮 Future Enhancements

- Admin Login System
- Trainer Management Module
- Attendance Tracking
- BMI Calculator
- Diet Plan Management
- Payment Gateway Integration
- Database Connectivity (MySQL)
- Monthly Reports and Analytics
- Search and Filter Members
- Export Reports to PDF/Excel
- Cloud Data Storage

---

## 📸 Screenshots

Screenshots of the application's GUI can be added below:

- Home Screen
- Add Member Window
- View Members
- Update Membership
- Workout Plan Display

---

## 🎓 Academic Purpose

This project was developed as part of an academic coursework submission to demonstrate Java programming concepts, Object-Oriented Programming, GUI development using Java Swing, collections, file handling, and serialization through the implementation of a practical Gym Membership Management System.

---

## 📄 License

This project is intended for educational and learning purposes. Feel free to fork, modify, and use it for personal or academic projects.
