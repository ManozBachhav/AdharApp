```
# AdharApp (Console Based Hibernate Project)

AdharApp is a simple **console-based CRUD application** built using  
**Java**, **Hibernate ORM**, and **MySQL**.  
The application manages **Person** and **Adhar** records with a One-to-One relationship.

---

## 🚀 Features

### Person & Adhar Operations
The app supports the following functions:

1. **Add Person with Adhar**  
2. **Get Person by Person ID**  
3. **Get Adhar by Adhar ID**  
4. **Get all Person + Adhar records**  
5. **Update Person details using Person ID**  
6. **Update only Adhar number using Person ID**  
7. **Delete Person using Person ID** (Adhar also deleted due to Cascade)  
8. **Delete only Adhar using Person ID** (Person remains)

---

## 🧱 Project Structure

```

src/
├── com.Entity
│   ├── Person.java
│   └── Adhar.java
│
├── com.Service
│   ├── PersonAdharService.java     (abstract)
│   └── PersonAdharServiceIMPL.java
│
├── com.Controller
│   └── HomeController.java
│
└── resources
└── hibernate.cfg.xml

````

### Relationship Meaning:
- Adding a Person also adds their Adhar  
- Deleting a Person deletes their Adhar  
- You can delete only Adhar without deleting the Person  

---

## ▶ How to Run

### 1. Create MySQL database:
```sql
CREATE DATABASE mydb;
````

### 2. Update your DB credentials in `hibernate.cfg.xml`

### 3. Compile & Run in IntelliJ or terminal:

```
java com.Controller.HomeController
```

### 4. Uncomment desired method inside `HomeController`:

```
pas.addPersonWithAdhar();
pas.updatePersonDetailonlyUsingPID();
pas.getallData();
```

---

## 🧪 Example Operations

### Add Person

```
Enter the person name : Manoj
Enter the person address : Pune
Enter the adhar number : 123456789012

Person added successfully
```

---

## 🔧 Technologies Used

* **Java 17+**
* **Hibernate ORM 6.x**
* **MySQL / MariaDB**
* **Maven**
* **IntelliJ IDEA**

---

## 📌 Concepts Demonstrated

* Hibernate Session & Transaction Management
* One-to-One Mapping
* Cascade Operations
* CRUD Operations
* HQL (`from Person`)
* First-Level Cache & Dirty Checking
* Console Input Handling

---

## 📎 Future Enhancements

* Convert to Spring Boot
* Add Menu-Driven Interactive Console
* Add Exception Handling
* Add Logging (SLF4J)
* Add Bidirectional Mapping (Person ↔ Adhar)

---

## 📄 License

This project is for educational purposes.
Feel free to fork and modify.

---

## 👨‍💻 Author

**Manoj Bachhav**
GitHub: [ManozBachhav](https://github.com/ManozBachhav)

```
