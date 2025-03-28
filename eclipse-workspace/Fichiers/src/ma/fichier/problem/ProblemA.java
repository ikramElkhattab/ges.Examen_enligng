package ma.fichier.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


public class ProblemA {
	 public static void main(String[] args) {
	        try (BufferedReader reader = new BufferedReader(new FileReader("Files/in.txt"));
	             PrintWriter writer = new PrintWriter(new FileWriter("Files/out.txt"))) {

	            String firstLine = reader.readLine();
	            if (firstLine == null) {
	                System.err.println("Erreur : fichier d'entrée vide !");
	                return;
	            }

	            int N = Integer.parseInt(firstLine.trim());
	            String secondLine = reader.readLine();
	            if (secondLine == null || secondLine.trim().isEmpty()) {
	                System.err.println("Erreur : pas de nombres dans le fichier !");
	                return;
	            }

	            String[] tokens = secondLine.split(" ");
	            Set<Integer> all = new HashSet<>();
	            Set<Integer> result = new HashSet<>();

	            for (int i = 0; i < N; i++) {
	                int x = Integer.parseInt(tokens[i]);
	                if (all.contains(-x)) {
	                    result.add(Math.abs(x));
	                }
	                all.add(x);
	            }

	            writer.println(result.size());
	            System.out.println("Résultat écrit dans files/out.txt");

	        } catch (NumberFormatException e) {
	            System.err.println("Erreur : format de nombre invalide dans le fichier !");
	        } catch (IOException e) {
	            System.err.println("Erreur de lecture/écriture : " + e.getMessage());
	        }
	    }
}
