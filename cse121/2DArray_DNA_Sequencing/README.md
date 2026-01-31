# 2D Array DNA Sequencing (Java)

This project analyzes DNA sequences using 2D arrays to determine:

- The count of each nucleotide (A, C, G, T) at each position  
- The probability of each nucleotide occurring at each position  
- The most likely nucleotide(s) for each position

This was built for **CSE 121 (P3: 2DNArray Sequencing)**.

---

## Features

### Count nucleotides per position  
Given a list of DNA sequences (equal length), the program produces a 2D `int[][]` array representing how often each nucleotide appears.

### Compute probability distribution  
A `double[][]` array gives the probability of A/C/G/T appearing at each position.

### Determine most probable nucleotide(s)  
Returns a `String[]` showing the most likely nucleotide(s) at each index.

---

## Example Input

```java
