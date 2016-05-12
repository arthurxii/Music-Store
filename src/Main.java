

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		String linha;
		FileInputStream fis = new FileInputStream("arquivo.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		List<Musicas> music = new ArrayList<Musicas>();
		while( (linha = br.readLine()) != null ){
			music.add(new Musicas(linha));
		}
		System.out.println(music);
	}
}
