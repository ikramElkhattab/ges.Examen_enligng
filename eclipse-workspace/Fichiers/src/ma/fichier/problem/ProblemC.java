package ma.fichier.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemC {
	 public static void main(String[] args) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("Files/good.in.txt"));
	             PrintWriter writer = new PrintWriter(new FileWriter("Files/good.out.txt"))) {

	            int N = Integer.parseInt(reader.readLine().trim()); 

	            for (int i = 1; i <= N; i++) {
	                int n = Integer.parseInt(reader.readLine().trim());

	               
	                long weightedSum = 0;
	                for (int k = 1; k <= n; k++) {
	                    long Tk1 = ((k + 1L) * (k + 2)) / 2; 
	                    weightedSum += k * Tk1;
	                }

	               
	                writer.println(i + " " + n + " " + weightedSum);
	            }

	            System.out.println("Résultat écrit dans good.out");

	        } catch (IOException e) {
	            System.err.println("Erreur de lecture/écriture : " + e.getMessage());
	        }
	    }
}
