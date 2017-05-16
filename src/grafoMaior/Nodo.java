package grafoMaior;
import java.util.LinkedList;
import java.util.List;

public class Nodo {

	private int entradas;
	private boolean marca;
	private int valor;
	private int pos;
	private List<Nodo> vizinhos= new LinkedList<Nodo>();
	
	public void addVizinho(Nodo vizinho){
		this.vizinhos.add(vizinho);
	}
	
	public void addEntrada(){
		this.entradas++;
	}
	
	public int getEntrada(){
		return entradas;
	}
	
	public void setEntradas(int entrada){
		this.entradas = entrada;
	}

	public boolean isMarca() {
		return marca;
	}

	public void setMarca(boolean marca) {
		this.marca = marca;
	}
	
	public void marca(){
		this.marca=true;
	}
	
	public void desMarca(){
		this.marca=false;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	Nodo(int entradas, boolean marca, int valor) {
		super();
		this.entradas = entradas;
		this.marca = marca;
		this.valor = valor;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public List<Nodo> getVizinhos() {
		return vizinhos;
	}
	
	public int [] indVizinhos(Nodo u){
		int [] viz = new int [u.vizinhos.size()];
		int i = 0;
		for(Nodo v:u.getVizinhos()){
			viz[i] = v.getPos();
			i++;
		}
		return viz;
	}

	@Override
	public String toString() {
		return ""+pos;
	}
	
	
}
