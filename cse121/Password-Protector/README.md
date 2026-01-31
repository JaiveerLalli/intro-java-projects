# Password Protector
This was one of my first Java projects from CSE 121. It’s a program that simulates protecting a password 
and testing how quickly a program can guess it. I built it to practice using methods, loops, conditionals,
and working with strings in a real-world style scenario.

# How it Works
The program defines a password and then tries to guess it character by character. It includes methods to:

Login: Checks if the guessed password matches the original password.

Check a character: Verifies if a specific character is correct at a given position.

Password Guesser: Uses a brute-force approach to reconstruct the password.

Generate Complex Password: Creates a random 5-character password from letters, numbers, and special characters.

The program also calculates the time taken to guess the password and prints the results.

# How to Run

Make sure you have Java installed.

Compile the program:
javac PasswordProtector.java

Run the program:
java PasswordProtector

# Features
Demonstrates brute-force password guessing

Uses loops, conditionals, and methods

Handles string operations and randomization

Prints timing and results to the console

# Example Output
Logging in...
PASSWORD cracked in 0.124 milliseconds


Note: The exact timing will vary depending on your system.

# What I Learned
This project taught me how to:

Break down a problem into smaller, reusable methods

Work with strings and character manipulation

Implement a simple brute-force algorithm

Measure and report elapsed time in code
