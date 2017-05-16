package grafoMaior;

import java.util.HashMap;
import java.util.Map;

public class Grafo {

	public Nodo [] nodos;
	Map<String, String> arestas = new HashMap<String,String>();
	
	Grafo(Nodo[] nodos) {
		super();
		this.nodos = nodos;
	}
	
	public Nodo getNodo(int i){
		for(Nodo nodo:nodos){
			if(nodo.getPos()==i) return nodo;
		}		
		System.out.println("Nodo não existe");
		return null;
	}
	
	public void caminha(int inicio){
		Nodo u = getNodo(inicio);
		u.marca();
		for(Nodo v:u.getVizinhos()){
			if(arestas.get(u.toString()+","+v.toString()).equals("1")){
				if(v.getValor()<=u.getValor()){
					v.setValor(u.getValor()+1);
					caminha(v.getPos());
			
					
				}
				
			}else if(arestas.get(u.toString()+","+v.toString()).equals("2")){
				if(v.getValor()!=u.getValor()){
					if(v.isMarca() && u.isMarca()){
						System.out.println("O grafo apresenta problema de loop e talvez inconsistencia.");
						return;
					}
					v.setValor(u.getValor());
					caminha(v.getPos());
				}
			}	
			
		}
		u.desMarca();
	}
}
