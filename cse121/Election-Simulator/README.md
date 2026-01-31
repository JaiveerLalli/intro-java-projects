# Election Simulator
This was one of my first Java projects from CSE 121. It simulates multiple elections across several 
districts and calculates the turnout, votes, and voting percentages for two parties. I built it to 
practice loops, methods, conditionals, and working with random numbers in a realistic scenario.

# How it Works
The program runs a set number of simulations (NUM_SIMS) across multiple districts (NUM_DISTS). For each district:

It generates a random turnout.

Calculates vote percentages for the Purple Party and Yellow Party with some random variation.

Tracks total votes for each party and prints results for each district.

After each simulation, the program:

Prints total turnout.

Shows vote counts and percentages for each party.

Visualizes results using colored symbols (🟪 for Purple, 🟡 for Yellow).

At the end, it calculates overall averages and declares the winner of the election.

# How to Run
Make sure you have Java installed.
Compile the program:
javac ElectionSimulator.java
Run the program:
java ElectionSimulator

# Features

Simulates multiple elections with random turnout and vote variation

Uses loops, conditionals, and methods to organize the code

Prints vote visualization using symbols

Tracks and reports results for each simulation and overall

# Example Output
Running Simulation 1:
  District #1 - 🟪 510  🟡 490
  District #2 - 🟪 470  🟡 530
  ...
Results for Simulation 1:
  Total Turnout: 10000
  Purple Party's votes: 5050 (50.5%)
  Yellow Party's votes: 4950 (49.5%)
  Visualization: 🟪🟪🟪🟪🟪...
                 🟡🟡🟡🟡🟡...
Election Simulator Results:
🟪 Win = true (51.0%)
🟡 Win = false (49.0%)


Note: The actual numbers will vary each time due to random simulation.

# What I Learned
This project taught me how to:

Use loops and methods to organize repetitive tasks

Work with random numbers to simulate real-world scenarios

Calculate percentages and averages in code

Display simple visualizations in the console
