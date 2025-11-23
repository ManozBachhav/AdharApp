# AdharApp (Console Based Hibernate Project)

AdharApp is a simple **console-based CRUD application** built using  
**Java**, **Hibernate ORM**, and **MySQL**.  
The application manages **Person** and **Adhar** records with a One-to-One relationship.

---

## 🚀 Features

The app supports the following operations:

1. **Add Person with Adhar**  
2. **Get Person by Person ID**  
3. **Get Adhar by Adhar ID**  
4. **Get all Person + Adhar records**  
5. **Update Person details using Person ID**  
6. **Update only Adhar number using Person ID**  
7. **Delete Person using Person ID** (Adhar automatically deleted due to Cascade)  
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
```

### Relationship Meaning
- Adding Person ➝ Adhar is saved automatically  
- Updating Person ➝ Only Person updated  
- Deleting Person ➝ Adhar also deleted (Cascade = ALL)  
- Deleting only Adhar ➝ Person stays  

---

## ▶ How to Run

### 1. Create a MySQL database:
```sql
CREATE DATABASE mydb;
```

### 2. Update database credentials inside `hibernate.cfg.xml`.

### 3. Run the application:
```bash
java com.Controller.HomeController
```

### 4. Choose desired operation inside `HomeController`:
```java
pas.addPersonWithAdhar();
pas.updatePersonDetailonlyUsingPID();
pas.getallData();
```

---

## 🧪 Example Output

### Adding Person
```
Enter the person name : Manoj
Enter the person address : Pune
Enter the adhar number : 123456789012

Person added successfully
```

---

## 🔧 Technologies Used

- **Java 17+**
- **Hibernate ORM 6.x**
- **MySQL / MariaDB**
- **Maven**
- **IntelliJ IDEA**

---

## 📌 Concepts Demonstrated

- Hibernate Session & Transaction Management  
- One-to-One Mapping  
- Cascade Handling  
- CRUD Operations  
- HQL (`from Person`)  
- Dirty Checking Mechanism  
- Console Input Handling  
- Entity Relationships  

---

## 📎 Future Enhancements

- Convert to Spring Boot  
- Add menu-based interactive console  
- Add exception handling  
- Add logging with SLF4J  
- Add bidirectional mapping (Person ↔ Adhar)  

---

## 📄 License

This project is for educational purposes.  
Feel free to fork and improve.

---

## 👨‍💻 Author

**Manoj Bachhav**  
GitHub: [ManozBachhav](https://github.com/ManozBachhav)
