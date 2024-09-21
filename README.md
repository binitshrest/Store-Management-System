# Store Management System 📦

![Spring Boot](https://img.shields.io/badge/SpringBoot-2.7.0-green) ![Java](https://img.shields.io/badge/Java-17-orange) ![API Integration](https://img.shields.io/badge/API-3rd--Party-blue)

> A powerful, user-friendly system for managing store inventories, sales, and customer data using **Spring Boot** and integrated with a **3rd-party API** for product details and inventory management.

---

## 🚀 Features

- **Inventory Management**: Fetch product details and inventory data from a third-party API.
- **Customer Management**: Store customer information, purchase history, and contact details.
- **Sales Tracking**: Manage sales records, invoices, and payments.
- **Reporting**: Generate detailed sales and inventory reports.
- **Authentication & Authorization**: Secure system with role-based access controls.
- **REST API**: Expose system functionality via a robust REST API.

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot (Java 17)
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


## 📡 API Endpoints

### 🛒 Product & Inventory Management

1. **GET** `/products`  
   *Fetch all products from the third-party API.*

2. **GET** `/products/{id}`  
   *Fetch a specific product by its ID.*

3. **POST** `/products`  
   *Create a new product.*

4. **PUT** `/products/{id}`  
   *Update an existing product.*

5. **DELETE** `/products/{id}`  
   *Delete a product.*

6. **GET** `/products/category/{category}`  
   *Retrieve products filtered by category.*

### 🛒 Cart Management

1. **GET** `/cart/{id}`  
   *Fetch details of a single cart by its ID.*  
   **Parameters**:
   - `id` (path) - The unique identifier of the cart.  

### 🛒 User Management

1. **GET** `/users/{id}`  
   *Fetch details of a single user by its ID.*  
   **Parameters**:
   - `id` (path) - The unique identifier of the user.  
