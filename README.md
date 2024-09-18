# Store Management System 📦

![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.0-green) ![Java](https://img.shields.io/badge/Java-17-orange) ![API Integration](https://img.shields.io/badge/API-3rd--Party-blue)

> A powerful, user-friendly system for managing store inventories, sales, and customer data using **Spring Boot** and integrated with a **3rd-party API** for product details and inventory management.

---

## 🚀 Features

- **Inventory Management**: Seamlessly fetch product details and inventory data from a third-party API.
- **Customer Management**: Store customer information, purchase history, and contact details.
- **Sales Tracking**: Manage sales records, invoices, and payments effortlessly.
- **Reporting**: Generate detailed sales and inventory reports.
- **Authentication & Authorization**: Secure system with role-based access controls.
- **REST API**: Expose system functionality via a robust REST API for external integration.

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot (Java 17)
- **Frontend**: Thymeleaf (HTML, CSS, JavaScript)
- **API Integration**: 3rd-party API for product details & inventory management
- **Build Tool**: Maven 3.8.4
- **Security**: Spring Security
- **API**: REST API

---

## ⚙️ Installation & Setup

### Prerequisites

- Java 17+
- Maven 3.8.4+

### Steps to Run Locally

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/store-management-system.git
   cd store-management-system

   ---

## 🏗️ Build and Run

To build and run the application, follow these commands:

```bash
# Clean and install dependencies
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run



---

## 📡 API Endpoints

### 🛒 Product & Inventory Management

- **GET** `/products`  
  Fetch all products from the third-party API.


---

### 👥 Product Management

- **GET** `/products`  
  Retrieve all customers.

- **POST** `/products/{id}`  
  Add a new customer.
