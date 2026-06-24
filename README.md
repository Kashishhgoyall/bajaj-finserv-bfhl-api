# BFHL API – Spring Boot

## 1. Before you start — fill in YOUR details

Open `src/main/java/com/chitkara/bfhl/service/BfhlServiceImpl.java`
and update the three constants at the top:

```java
private static final String FULL_NAME   = "john_doe";       // your name, lowercase with underscore
private static final String DOB         = "17091999";        // your DOB ddmmyyyy
private static final String EMAIL       = "john@xyz.com";    // your email
private static final String ROLL_NUMBER = "ABCD123";         // your college roll number
```

---

## 2. Run locally

```bash
# Build
mvn clean package -DskipTests

# Run
java -jar target/bfhl-0.0.1-SNAPSHOT.jar
```

API will be live at `http://localhost:8080/bfhl`

**Test with curl:**
```bash
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["a", "1", "334", "4", "R", "$"]}'
```

---

## 3. Run tests

```bash
mvn test
```

---

## 4. Deploy to Render (free, recommended)

1. Push your code to a **GitHub repo**
2. Go to https://render.com → New → **Web Service**
3. Connect your GitHub repo
4. Set:
   - **Environment**: `Java`
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/bfhl-0.0.1-SNAPSHOT.jar`
5. Click **Deploy**
6. Your URL will be: `https://your-app-name.onrender.com/bfhl`

---

## 5. Deploy to Railway (alternative)

1. Install Railway CLI: `npm install -g @railway/cli`
2. `railway login`
3. `railway init` inside this project folder
4. `railway up`

---

## Project Structure

```
src/
├── main/java/com/chitkara/bfhl/
│   ├── BfhlApplication.java          ← Entry point
│   ├── controller/
│   │   └── BfhlController.java       ← POST /bfhl
│   ├── service/
│   │   ├── BfhlService.java          ← Interface
│   │   └── BfhlServiceImpl.java      ← All logic here
│   ├── dto/
│   │   ├── BfhlRequest.java          ← Input DTO
│   │   └── BfhlResponse.java         ← Output DTO
│   └── exception/
│       └── GlobalExceptionHandler.java
└── test/java/com/chitkara/bfhl/
    └── BfhlServiceTest.java          ← 10 test cases
```
