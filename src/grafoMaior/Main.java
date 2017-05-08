package grafoMaior;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static String mFilename = "z5.txt";
	private static String line;
	
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mFilename));
			line = br.readLine();
			int qtdArestas = Integer.parseInt(line);
			int [] nodos = new int[qtdArestas];
			int [] entradas = new int[qtdArestas];
			Map<String, String> arestas = new HashMap<String,String>();
			
			for (int i = 0; i < qtdArestas; i++){
				line = br.readLine();
				System.out.println(line);
				String [] relacao = line.split(" ");
				if(nodos[Integer.parseInt(relacao[0])]==0)
					nodos[Integer.parseInt(relacao[0])]=1;
				if(nodos[Integer.parseInt(relacao[2])]==0)
					nodos[Integer.parseInt(relacao[2])]=1;
				if(relacao[1].equals(">")){
					arestas.put(relacao[2]+","+relacao[0], "1");
					entradas[Integer.parseInt(relacao[0])]++;
				} else if(relacao[1].equals("<")){
					arestas.put(relacao[0]+","+relacao[2], "1");
					entradas[Integer.parseInt(relacao[2])]++;
				} else if(relacao[1].equals("=")){
					arestas.put(relacao[0]+","+relacao[2], "2");
					arestas.put(relacao[2]+","+relacao[0], "2");
					entradas[Integer.parseInt(relacao[0])]++;
					entradas[Integer.parseInt(relacao[2])]++;
				}
			}
			for( int nodo : nodos){
				System.out.println(nodo);
			}
			for( int entrada : entradas){
				System.out.println(entrada);
			}
			System.out.println(arestas.keySet());
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
	}

}
