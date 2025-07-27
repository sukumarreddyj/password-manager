Here’s the **complete README.md** in one single block so you can copy-paste directly into your project:

---

```markdown
# Password Manager (Java 17 + Spring Boot)

A secure password manager built using **Java 17** and **Spring Boot**.  
It provides REST APIs to store credentials securely, generate strong random passwords, and persist data with AES encryption in a local file.

---

## Features
- Add credentials (service, username, password, notes)
- View all stored credentials
- Generate strong random passwords
- Data encrypted with **AES** before saving to disk (`vault.json`)
- Built with modern Java 17 features (records, SecureRandom)

---

## Tech Stack
- **Java 17**
- **Spring Boot 3.x**
- **Maven**
- **Jackson** (JSON handling)
- **AES Encryption**

---

## Project Structure
```

src/main/java/com/myapp/passwordmanager/
├─ PasswordManagerApplication.java
├─ controller/
│    └─ CredentialController.java
├─ service/
│    ├─ PasswordService.java
│    ├─ FileStorageService.java
│    └─ EncryptionService.java
├─ model/
│    └─ Credential.java
└─ util/
└─ PasswordGenerator.java

````

---

## API Endpoints

### 1. Add Credential
**POST** `/api/credentials`  
**Body (JSON)**:
```json
{
  "service": "Gmail",
  "username": "user@gmail.com",
  "password": "MyP@ssword!",
  "notes": "personal account"
}
````

**Response**:

```
"Credential saved successfully."
```
<img width="1013" height="851" alt="Screenshot 2025-07-27 at 5 24 00 PM" src="https://github.com/user-attachments/assets/cedb3bfe-783c-4dcd-8f17-e62351b9bfd4" />


---

### 2. View Credentials

**GET** `/api/credentials`
**Response (example)**:

```json
[
  {
    "service": "Gmail",
    "username": "user@gmail.com",
    "password": "MyP@ssword!",
    "notes": "personal account"
  }
]
```
<img width="821" height="818" alt="Screenshot 2025-07-27 at 5 24 26 PM" src="https://github.com/user-attachments/assets/42292952-822d-47b3-8e13-f0c053153827" />


---

### 3. Generate Random Password

**GET** `/api/credentials/generate?length=16`
**Response (example)**:

```
"Vx@1r6JmQd#LpT0s"
```
<img width="1009" height="843" alt="Screenshot 2025-07-27 at 5 24 48 PM" src="https://github.com/user-attachments/assets/76f6451b-bf4c-47db-92c9-c1c86e9d838c" />

---

## How to Run Locally

### Prerequisites

* Java 17 or higher
* Maven 3.8+
* VS Code or IntelliJ IDEA

### Steps

```bash
# Clone the repo
git clone https://github.com/your-username/password-manager-api.git
cd password-manager-api

# Build and run
mvn spring-boot:run
```

The app will start on **`http://localhost:8080`**.

---

## Testing

### Using Postman

1. Import endpoints:

   * POST `/api/credentials` (add credential)
   * GET `/api/credentials` (view credentials)
   * GET `/api/credentials/generate?length=16` (generate password)
2. Send requests and check responses.

### Using cURL

```bash
curl -X POST http://localhost:8080/api/credentials \
  -H "Content-Type: application/json" \
  -d '{"service":"Gmail","username":"test@gmail.com","password":"MyP@ssword!","notes":"personal account"}'

curl -X GET http://localhost:8080/api/credentials
curl -X GET "http://localhost:8080/api/credentials/generate?length=16"
```

---

## Data Storage

* Credentials are stored in **`vault.json`** in the project root.
* Data is AES encrypted before saving.

---

## Future Improvements

* Add search & delete endpoints
* Add master password & authentication (Spring Security + JWT)
* Migrate storage to a database (MySQL/PostgreSQL)
* Add frontend (React/Angular)
* Dockerize & deploy to cloud

---

## License

This project is licensed under the MIT License.
