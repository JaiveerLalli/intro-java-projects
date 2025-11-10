# Patient Prioritizer
This was one of my first Java projects from CSE 121. It’s a program that helps figure out how urgently a patient 
should be seen based on different health factors. I built it to practice using methods, loops, conditionals, and
user input in a real-world style scenario.

# How it Works
The program asks for details like a patient’s name, age, zip code, insurance info, pain level, and temperature. 
It then gives the patient a priority score and classifies them as high, medium, or low priority. When you type 
“quit,” it shows overall stats like how many patients were entered and the highest score of the day.

# How to Run
Make sure you have Java installed.
Compile the program:
javac PatientPrioritizer.java
Run the program:
java PatientPrioritizer

# Features
Uses loops and conditionals to calculate scores
Handles user input through the console
Demonstrates method decomposition and code organization
Gives feedback and statistics at the end of the session

# Example Output
Please enter the next patient's name or "quit" to end the program.
Patient's name: John Doe
Patient age: 68
Patient zip code: 12345
Is our hospital "in network" for the patient's insurance? yes
Patient pain level (1-10): 8
Patient temperature (in degrees Fahrenheit): 101.2

We have found patient John Doe to have a priority score of: 271
We have determined this patient is high priority,
and it is advised to call an appropriate medical provider ASAP.

# What I Learned
This project taught me how to:
Break down a big problem into smaller, reusable methods
Work with user input and validation
Apply logic to simulate a realistic process
