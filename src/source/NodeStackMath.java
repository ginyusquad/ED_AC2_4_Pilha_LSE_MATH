package source;

import java.util.HashMap;

public class NodeStackMath<E> implements Stack<E>{


	private Node<E> cabeca =  null;
	private int size = 0;
	
	@Override
	public int size() {
		return size;
	}
	// Limpa o conteudo do vetor de Nodes
	public void clear(){
		size = 0;
		cabeca.setNext(null);
		cabeca.setPrev(null);
		cabeca = null;
	}
	// Adicona todos os dados ao vetor
	public void addArray(E[] vetor){
		
		for(E eleemnto : vetor){
			this.push(eleemnto);
		}
		
	}
	// Vericia se as aspas e colchetes estão ok
	public boolean verifyMath(){
		
		
		HashMap<String, String> charDoMapa = new HashMap<String, String>() {{
													        put("(", ")");
													        put("{", "}");
													        put("[", "]");
													    }};
		
		// Vetor Reverso com os nodes contendo ({[ de onde 
		// empilhamos ou desempilhamos os elementos
		NodeStackMath<E> vetorConchetesParenteses = new NodeStackMath<E>();
		
		Node<E> nodeAtual = new Node<E>();
		nodeAtual.setNext(cabeca);
		
		do{//[(5+x)/4–2* @(y+z)@ ]
			
			nodeAtual = nodeAtual.getNext();
			
			// Empinha se for uma chave   )} ]  
			if(charDoMapa.containsValue(nodeAtual.getDado().toString())){
				vetorConchetesParenteses.push(nodeAtual.getDado());
			}
			// Desempinha se for uma chave   ( { [
			if(charDoMapa.containsKey(nodeAtual.getDado().toString())){
				// Se for um ( { [ solto então é um erro!
				if(vetorConchetesParenteses.isEmpty()){
					return false;				
				}else if(vetorConchetesParenteses.top().toString().equals(charDoMapa.get(nodeAtual.getDado().toString()))){
					E elementoDesempilhado = vetorConchetesParenteses.top();
					vetorConchetesParenteses.pop();
				}else return false;// Se for um ( { [ solto então é um erro!
			}
									
		}while(nodeAtual.hasNext());
		
		return  vetorConchetesParenteses.isEmpty();
	}

	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public E top() throws EmptyStackException {
		if(isEmpty())throw new EmptyStackException(" Stack is empty");
		return cabeca.getDado();
	}

	@Override
	public void push(E elemento){
		
		
		
		// Cria um node e atribui o valor ao elemento
		Node<E> node =  new Node<E>();
		node.setDado(elemento);

		// Verifica se o trail já foi definido
		if(cabeca != null){
			// Definindo que a cabeça tera como elemento anterior
			// o novo elemento
			cabeca.setPrev(node);
			node.setPrev(null);
			node.setNext(cabeca);
		}
		
		// Definindo novo node como o cabeça
		cabeca = node;
		size++;
	}

	@Override
	public E pop() throws EmptyStackException {
		
		E elemento =  null;
		
		if (isEmpty()) throw new EmptyStackException("Stack is empty.");
		
				
		elemento = cabeca.getDado();
		
		
		if(cabeca.hasNext()){
			// Retirando ultimo node 
			cabeca.getNext().setPrev(null);
			cabeca = cabeca.getNext();
			
		}else cabeca = null;
		
		size--;
		
		return elemento;
	}
	
	public String toString() {
		String s;
		Node<E> p = cabeca;

		s = "[";
		while (p != null) {
			s += p.getDado();
			s += ", ";
			p = p.getNext();
		}
		if (s.length() > 1) 
			s = s.substring(0, s.length() - 2);
		return s + "]";
	}

}
