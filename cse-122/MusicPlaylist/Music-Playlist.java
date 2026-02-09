// Jaiveer Lalli
// 2-5-2026
// CSE 122
// TA: Yang Wu
// P1: Music Playlist

// This class allows a user to customize a music playlist. The user is able to add and 
// play songs, print, view, and delete from the history of songs played, and view their
// playlist.


import java.util.*;
import java.io.*;

public class MusicPlaylist {
    public static void main(String[] args) {
        
        System.out.println("Welcome to the CSE 122 Music Playlist!");
        System.out.println();
        Scanner console = new Scanner(System.in);
        Queue<String> songsQueue = new LinkedList<>();
        Stack<String> stackHistory = new Stack<>();
        String choice = "";

        while (!choice.equalsIgnoreCase("Q")) {
            System.out.println("(A) Add song");
            System.out.println("(P) Play song");
            System.out.println("(H) Print history");
            System.out.println("(V) View playlist");
            System.out.println("(C) Clear history");
            System.out.println("(D) Delete from history");
            System.out.println("(Q) Quit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = console.nextLine();


            if (choice.equalsIgnoreCase("A")) {
                addSong(songsQueue, console);
            } else if (choice.equalsIgnoreCase("P")) {
                playSong(songsQueue, stackHistory);
            } else if (choice.equalsIgnoreCase("H")) {
                printingHistory(stackHistory);
            } else if (choice.equalsIgnoreCase("V")) {
                viewPlaylist(songsQueue);
            } else if (choice.equalsIgnoreCase("C")) {
                clearHistory(stackHistory);
            } else if (choice.equalsIgnoreCase("D")) {
                deleteHistory(console, stackHistory);
            } else if (choice.equalsIgnoreCase("Q")) {

            } else {
                System.out.println();
            }
        }
    }

    

    // This method asks for a song name and adds it to the queue
    // Parameters: 
    //    - queue: The playlist of songs the user has queued
    //    - console: Scanner used to read the song name
    public static void addSong(Queue<String> queue, Scanner console) {
        System.out.print("Enter song name: ");
        String currSong = console.nextLine();
        queue.add(currSong);
        System.out.println("Successfully added " + currSong);
        System.out.println();
    }


    // This method plays a song from the queue
    // Parameters:
    //    - queue: The playlist of songs the user has queued
    //    - stack: used to provide us with the history of songs played (most recent on top)
    // Exceptions:
    //    - IllegalStateException is displayed if there are no songs in the queue
    public static void playSong(Queue<String> queue, Stack<String> stack) {
        if (queue.isEmpty()) {
            throw new IllegalStateException();
        } else {
            String songPlaying = queue.remove();
            System.out.println("Playing song: " + songPlaying);
            stack.push(songPlaying);
            System.out.println();
        }
    }
    

    // This method prints the history of songs played
    // Parameters: 
    //    - stack: used to provide us with the history of songs played (most recent on top)
    // Exceptions: 
    //    - IllegalStateException is displayed if there have been no songs yet played
    public static void printingHistory(Stack<String> stack) {
        if (stack.isEmpty()) {
            throw new IllegalStateException();
        } else {
            Stack<String> placeHold = new Stack<>();
            while (!stack.isEmpty()) {
                String holder = stack.pop();
                System.out.println("    " + holder);
                placeHold.push(holder);
            }
            while (!placeHold.isEmpty()) {
                String backToStack = placeHold.pop();
                stack.push(backToStack);
            }
        }
        System.out.println();
    }

    // This method allows the user to view their current playlist and queue of songs
    // Parameters:
    //    - queue: the playlist of songs the user has queued
    // Exceptions: 
    //    - IllegalStateException is thrown if there are no songs in the playlist
    public static void viewPlaylist(Queue<String> queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException();
        } else {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String holder = queue.remove();
                System.out.println("    " + holder);
                queue.add(holder);
            }
        }
        System.out.println();
    }

    // This method clears the listening history
    // Parameters:
    //    - stack: represents the history of songs played
    public static void clearHistory(Stack<String> stack) {
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println();
    }

    // This method allows the user to delete select portions of their listening history
    // Parameters:
    //    - console: Scanner used to determine the amount of songs to delete and their location
    //    - stack: represents the history of songs played by the user
    // Exceptions:
    //    - IllegalArgumentException is thrown if the amount of songs to delete are greater
    //      than the amount of songs that have been played
    public static void deleteHistory(Scanner console, Stack<String> stack) {
        System.out.println("A positive number will delete from recent history.");
        System.out.println("A negative number will delete from the beginning of history.");
        System.out.print("Enter number of songs to delete: ");
        String delete = console.nextLine();
        int numOfSongDelete = Integer.parseInt(delete);
        int absNumSongDelete = Math.abs(numOfSongDelete);
        
        if (absNumSongDelete > stack.size()) {
            throw new IllegalArgumentException();
        
        } else if (numOfSongDelete > 0) {
            for (int i = 0; i < absNumSongDelete; i++) {
                stack.pop();
            }
        } else if (numOfSongDelete < 0) {
            Stack<String> placeHold = new Stack<>();
            while (!stack.isEmpty()) {
                String holder = stack.pop();
                placeHold.push(holder);
            }
            for (int i = 0; i < absNumSongDelete; i++) {
                placeHold.pop();
            }

            while (!placeHold.isEmpty()) {
                String backToStack = placeHold.pop();
                stack.push(backToStack);
            }
        }
        System.out.println();
    }
}
        



