
# 💱 Currency Converter

## 📌 Description

The **Currency Converter** is a Java-based application that converts an amount from one currency to another using exchange rates.
It can work with **real-time data via API** or **predefined conversion rates**.

This project demonstrates API integration, JSON parsing, and exception handling in Java.

---

## 🎯 Objectives

* To convert currency values accurately
* To integrate external APIs *(if implemented)*
* To handle user input and errors effectively
* To build a real-world financial utility

---

## 🚀 Features

* Convert between multiple currencies (USD, INR, EUR, etc.)
* Real-time exchange rates *(API-based)*
* Manual conversion option *(offline mode)*
* Input validation
* Error handling for invalid data/API issues

---

## 🛠️ Technologies Used

* Java ☕
* APIs *(Exchange Rate API if used)*
* JSON Parsing
* Exception Handling

---

## ⚙️ How It Works

1. User selects:

   * Base currency
   * Target currency
   * Amount
2. Program fetches exchange rate:

   * From API *(if connected)* OR
   * Uses predefined rates
3. Conversion is calculated
4. Result is displayed to the user

---

## ▶️ How to Run

### 1️⃣ Compile the Program

```bash id="yhl4h6"
javac CurrencyConverter.java
```

### 2️⃣ Run the Program

```bash id="cm7i0h"
java CurrencyConverter
```

--
