# 📚 **BookReview Application**

Welcome to **BookReview**, a user-friendly platform built with Spring Boot and Thymeleaf, allowing users to explore and review books while administrators manage the catalog. Dive into a world of books, share your opinions, and connect with others!  


## 🛠️ **Features**

### 👤 User Features
- **📖 View Books**: Explore our entire catalog.
- **✍️ Add Reviews**: Share your thoughts and rate your favorite books.

### 🔑 Admin Features
- **➕ Add Books**: Expand the catalog by adding new books.
- **✏️ Update Books**: Modify book details.
- **🗑️ Delete Books**: Remove outdated or irrelevant books.



---

## 📂 **Project Structure**

```plaintext
BookReview/
├── src/
│   ├── main/
│   │   ├── java
│   │   │   └── code.app.books     # Application's Java source code
│   │   └── resources/
│   │       ├── templates/         # Thymeleaf templates for the UI
│   │       └── application.properties
│   │       └── schema.sql               # SQL file to create initial database schema
├── Dockerfile                      # Docker configuration
├── docker-compose.yml              # Docker Compose for multi-container setup
├── pom.xml                         # Maven dependencies and plugins
└── README.md                       # Project documentation
```

---


---

## 🚀 **Getting Started**

### 📋 Prerequisites
- **Java 11** or higher
- **Maven** for building and dependency management
- **Docker** and **Docker Compose** for containerized deployment

### ⚙️ Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/harshil-padasala/bookreview.git
   cd bookreview
   ```

2. **Configure the Database**:
   - In `src/main/resources/application.properties`, update your database settings as needed.

3. **Run the Application**:
   - **Without Docker**:
     ```bash
     ./mvnw spring-boot:run
     ```
   - **With Docker**:
     ```bash
     docker-compose up --build
     ```

4. **Access the Application**:
   - Open [http://localhost:8080](http://localhost:8080) in your web browser.


## 🎉 **Usage**

### 📜 User Experience
- **Home Page**: Lists all available books in an easy-to-navigate format.
- **Review Page**: Allows users to add and view reviews for specific books.

### 🔐 Admin Console
- Admins have full access to manage the book catalog, with options to add, update, and delete books.

---

## 🐳 **Docker Usage**

### 🛠️ Building the Image
To build the Docker image manually:
```bash
docker build -t bookreview-app .
```

### 🚢 Running with Docker Compose
To start the application and its dependencies in Docker:
```bash
docker-compose up --build
```

### 🛑 Stopping the Application
To stop the running containers:
```bash
docker-compose down
```

---

## 🧪 **Testing**

Run tests to verify the application's functionality:
```bash
./mvnw test
```

---

## 🖥️ **Technologies Used**
- **Spring Boot** - Backend framework
- **Thymeleaf** - Templating engine
- **H2 Database** - In-memory database for development (configurable to other DBs)
- **Docker** - Containerization for seamless deployment
- **Docker Compose** - Orchestrate multi-container applications

---

## 📜 **License**

This project is licensed under the MIT License.

---

Enjoy exploring and sharing your favorite books with **BookReview**! 😊
