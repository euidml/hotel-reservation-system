# Hotel Reservation System

A Java-based concurrent hotel room booking system that demonstrates safe multi-user reservations using advanced concurrency techniques and object-oriented programming principles.

## Project Overview
This project implements a hotel reservation system where multiple users can book rooms concurrently. The system ensures thread safety and data consistency by leveraging Java's concurrency utilities, making it suitable for scenarios where multiple clients interact with the booking system simultaneously.

## Key Features
- **Concurrent Multi-User Booking:** Supports multiple users booking rooms at the same time without data races or inconsistencies.
- **Thread Safety:** Utilizes `synchronized`, `ReentrantLock`, `Condition`, and `Thread` to manage concurrent access and ensure safe operations.
- **Object-Oriented Design:** Combines OOP principles with concurrent programming for a modular, maintainable, and extensible codebase.

## How to Compile and Run
1. **Compile the Source Code:**
   Navigate to the project root and run:
   ```sh
   javac -d bin src/lab10/*.java
   ```
2. **Run the Application:**
   Execute the main tester class (e.g., `HotelTester`) from the `bin` directory:
   ```sh
   java -cp bin lab10.HotelTester
   ```

## Documentation
- Javadoc-generated documentation is available in the `doc/` directory. Open `doc/index.html` in your browser for detailed API information.

---

*This project demonstrates mastery of Java concurrency and object-oriented programming in the context of a real-world application scenario.*
