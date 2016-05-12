
import java.io.*;
public class EscritaNaLista {
	public static void main(String[] args) throws Exception{
		File file = new File("arquivo.txt");
		
		PrintWriter writer = new PrintWriter(file);
		
		writer.println("Linkin Park - In The End");
		writer.println("Linkin Park - New Divide");
		writer.println("The Weeknd - The Hills");
		writer.println("The Weeknd - Often");
		writer.println("Iron Maiden - Aces High");
		writer.println("Iron Maiden - The Number Of The Beast");
		writer.println("Slipknot - Psychosocial");
		writer.println("Slipknot - Before I Forget");
		writer.println("Young The Giant - Cough Syrup");
		writer.println("Young The Giant - Apartment");
		
		writer.close();
	}
}
