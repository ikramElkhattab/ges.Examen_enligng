package ma.fichier.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class ProblemB {
	public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/bin.in.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("Files/bin.out.txt"))) {
            
            int N = Integer.parseInt(reader.readLine().trim()); 
            
            for (int i = 1; i <= N; i++) {
                String[] parts = reader.readLine().split(" ");
                
               
                BigInteger num1 = new BigInteger(parts[0], 2);
                BigInteger num2 = new BigInteger(parts[1], 2);
                
                
                BigInteger sum = num1.add(num2);
                
              
                String result = sum.toString(2);
            
                writer.println(i + " " + result);
            }
            
            System.out.println("Résultat écrit dans bin.out");

        } catch (IOException e) {
            System.err.println("Erreur de lecture/écriture : " + e.getMessage());
        }
    }
}
