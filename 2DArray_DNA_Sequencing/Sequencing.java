// Jaiveer Lalli
// 12-2-2025
// CSE 121
// P3: 2DNArray Sequencing
// TA: Nhan Truong

// This class builds a program to analyze DNA sequences with 2D Arrays.
// We count the amount of nucleotides occuring at each position 
// and calculate the probabilities at nucleotides per position.
// We can then print out the probable nucleotide at each position.

import java.util.*;

public class Sequencing {

    public static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};


    // 
    public static void main(String[] args) {
        
        String[] test = {"ACGT", "ACCG", "ACCT"};
        int[][] aTest = counts(test);
        System.out.println("Counts: ");
        for (int i = 0; i < aTest.length; i++) {
            System.out.println(Arrays.toString(aTest[i]));
        }
        double[][] pTest = probabilities(aTest);
        System.out.println("Probabilities");
        for (int i = 0; i < pTest.length; i++) {
            System.out.println(Arrays.toString(pTest[i]));
        }
        System.out.println("Results:");
        // System.out.println(Arrays.toString(result(pTest)));
        String res[] = result(pTest);
        for (int i = 0; i < res.length; i++) {
            System.out.println("Position: " + i + ": " + res[i]);
        }
  
    }

    // This method takes in a char parameter that provides us a nucleotide
    // which we use to find the index of and return the index
    public static int indexOfNucleotide(char nucleotide) {
        nucleotide = Character.toUpperCase(nucleotide);

        for (int i = 0; i < NUCLEOTIDES.length; i++) {
            if (nucleotide == NUCLEOTIDES[i]) {
                return i;
            }
        }
        return -1;
    }


    // This method takes in a parameter of an array of strings which we use to
    // find the frequency of each nucleotide at each position. We then return
    // a 2D array of integers that represents how many nucleotides are at each position
    public static int[][] counts(String[] sequences) {
        int[][] frequencyDNA = new int[sequences[0].length()][NUCLEOTIDES.length];
        for (int i = 0; i < sequences.length; i++) {
            for (int j = 0; j < sequences[0].length(); j++) {
                char nucleotide = sequences[i].charAt(j);
                int index = indexOfNucleotide(nucleotide);
                if (index != -1) {
                    frequencyDNA[j][index]++;
                }
            }
        }
        return frequencyDNA; 
    }


    // This method takes a parameter of a 2D array of ints which we found from the
    // counts method and goes through and calculates the probability of each nucleotide
    // at each position. We then return a double 2D array that shows the probabilities
    // of the chances of the nucleotides at the positions.
    public static double[][] probabilities(int[][] counts) {
        double[][] probableNucleotides = new double[counts.length][counts[0].length];
        for (int i = 0; i < counts.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < counts[0].length; j++) {
                rowSum += counts[i][j];
            }
            if (rowSum == 0) {
                for (int j = 0; j < counts[0].length; j++) {
                    probableNucleotides[i][j] = 0;
                }
            } else {
                for (int j = 0; j < counts[0].length; j++) {
                    probableNucleotides[i][j] = (double) counts[i][j] / rowSum;
                }
            }
        }
        return probableNucleotides;
    }

    
    // This method takes in a 2D double array of the probablities we found in the
    // previous method and then assigns the nucleotide that is most probable 
    // in that position. We then return an array of strings that tell us 
    // which nucleotide is likely at each position.
    public static String[] result(double[][] probs) {
        String[] nucleotidesAtPosition = new String[probs.length];
        for (int i = 0; i < probs.length; i++) {
            double max = -1.0;
            String nucleotidesProb = "";
            for (int j = 0; j < probs[i].length; j++) {                
                if (probs[i][j] > max) {
                    max = probs[i][j];
                } 
            }
            for (int j = 0; j < probs[i].length; j++) {                
                if (probs[i][j] == max) {
                    nucleotidesProb += NUCLEOTIDES[j];
                }
            }
            nucleotidesAtPosition[i] = nucleotidesProb;
        }
        return nucleotidesAtPosition;
    }  
} 
