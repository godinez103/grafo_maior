package grafoMaior;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	private static String mFilename = "z10b.txt";
	private static String line;
	
	
	public static void main(String[] args) throws IOException{
		long tempoInicial = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(mFilename));
		line = br.readLine();
		int maior = 0;
		int qtdArestas = Integer.parseInt(line);
		Nodo [] xnodos = new Nodo[qtdArestas];
		for(int i = 0;i<qtdArestas;i++){
			xnodos[i] = new Nodo(0,false,0);
		}
		Grafo grafo = new Grafo(xnodos);
		
		for (int i = 0; i < qtdArestas; i++){
			line = br.readLine();
			System.out.println(line);
			String [] relacao = line.split(" ");
			if(grafo.nodos[Integer.parseInt(relacao[0])].getValor()==0){
				grafo.nodos[Integer.parseInt(relacao[0])].setPos(Integer.parseInt(relacao[0]));	
				grafo.nodos[Integer.parseInt(relacao[0])].setValor(1);
			}
			if(grafo.nodos[Integer.parseInt(relacao[2])].getValor()==0){
				grafo.nodos[Integer.parseInt(relacao[2])].setPos(Integer.parseInt(relacao[2]));
				grafo.nodos[Integer.parseInt(relacao[2])].setValor(1);
			}
			if(relacao[1].equals(">")){
				grafo.arestas.put(relacao[2]+","+relacao[0], "1");
				grafo.nodos[Integer.parseInt(relacao[0])].addEntrada();
				grafo.nodos[Integer.parseInt(relacao[2])].addVizinho(grafo.nodos[Integer.parseInt(relacao[0])]);
			} else if(relacao[1].equals("<")){
				grafo.arestas.put(relacao[0]+","+relacao[2], "1");
				grafo.nodos[Integer.parseInt(relacao[2])].addEntrada();
				grafo.nodos[Integer.parseInt(relacao[0])].addVizinho(grafo.nodos[Integer.parseInt(relacao[2])]);
			} else if(relacao[1].equals("=")){
				grafo.arestas.put(relacao[0]+","+relacao[2], "2");
				grafo.arestas.put(relacao[2]+","+relacao[0], "2");
				grafo.nodos[Integer.parseInt(relacao[0])].addEntrada();
				grafo.nodos[Integer.parseInt(relacao[2])].addEntrada();
				grafo.nodos[Integer.parseInt(relacao[0])].addVizinho(grafo.nodos[Integer.parseInt(relacao[2])]);
				grafo.nodos[Integer.parseInt(relacao[2])].addVizinho(grafo.nodos[Integer.parseInt(relacao[0])]);
			}
		}
		int indice=0;
		for( Nodo nodo : grafo.nodos){
			if(nodo.getValor()==0){
				grafo.nodos[indice].setValor(-1);
				grafo.nodos[indice].setEntradas(-1);
				grafo.nodos[indice].setPos(-1);
			}
			indice++;
			System.out.println(nodo.getPos());
		}
		int [] inicial = vetorInicial(grafo);
		for (int inicio:inicial)System.out.println(inicio);
		for( Nodo entradas: grafo.nodos)
		System.out.println(entradas.getPos());
		System.out.println(grafo.arestas.keySet());
		for(int i: inicial){
			grafo.caminha(i);
		}
		for( Nodo nodo : grafo.nodos){
			System.out.println(nodo.getPos()+" - "+nodo.getValor());
			if(nodo.getValor()>maior)maior = nodo.getValor();
		}
		System.out.println(maior);
		System.out.println(System.currentTimeMillis() - tempoInicial);
	}
	
	public static int [] vetorInicial(Grafo grafo){
		int count=0;
		int j=0;
		for(Nodo entrada:grafo.nodos){
			if(entrada.getEntrada()==0)count++;
			j++;
		}
		int [] inicial = new int[count];
		count =0;
		for(int i =0;i<j;i++){			
			if(grafo.nodos[i].getEntrada()==0){
				inicial[count]=i;
				count++;
			}
		}
		return inicial;
	}

}
