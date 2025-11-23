
AdharApp (Hibernate Console Project)

```
# AdharApp (Console Based Hibernate Project)

AdharApp is a simple **console-based CRUD application** built using  
**Java**, **Hibernate ORM**, and **MySQL**.  
The application manages **Person** and **Adhar** records.

---

## 🚀 Features

### Person & Adhar Operations
The app supports the following functions:

1️⃣ **Add Person with Adhar**  
2️⃣ **Get Person by Person ID**  
3️⃣ **Get Adhar by Adhar ID**  
4️⃣ **Get all Person + Adhar records**  
5️⃣ **Update Person details using Person ID**  
6️⃣ **Update only Adhar number using Person ID**  
7️⃣ **Delete Person using Person ID (Adhar also deleted due to Cascade)**  
8️⃣ **Delete only Adhar using Person ID (Person remains)**  

## 🧱 Project Structure

```
src/
├── com.Entity
│     ├── Person.java
│     └── Adhar.java
│
├── com.Service
│     ├── PersonAdharService.java  (abstract)
│     └── PersonAdharServiceIMPL.java
│
├── com.Controller
│     └── HomeController.java
│
└── resources
└── hibernate.cfg.xml

````

This means:

* Adding a Person also adds their Adhar
* Deleting a Person deletes their Adhar
* But you can delete only Adhar if required

---

## ▶ How to Run

1. Install MySQL & create a database:

```sql
CREATE DATABASE mydb;
```
2. Update DB credentials in `hibernate.cfg.xml`

3. Compile & Run in IntelliJ or terminal:

```bash
java com.Controller.HomeController
```
4. Uncomment desired method in `HomeController`:

```java
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

## 🔧 Technologies Used

* **Java 17+**
* **Hibernate ORM 6.x**
* **MySQL / MariaDB**
* **Maven**
* **IntelliJ IDEA**

---

## 📌 Concepts Demonstrated

* Hibernate Session & Transaction handling
* Dirty Checking
* One-to-One mapping
* Cascade operations
* CRUD operations
* HQL (`from Person`)
* Console input handling

---

## 📎 Future Enhancements

* Convert project to Spring Boot
* Add menu-driven interactive console
* Add exception handling
* Add logging (SLF4J)
* Add bidirectional mapping (Person ↔ Adhar)

---

## 📄 License

This project is for educational purposes.
Feel free to fork and modify.

---

## 👨‍💻 Author

**Manoj Bachhav**
GitHub: [ManozBachhav](https://github.com/ManozBachhav)

```
