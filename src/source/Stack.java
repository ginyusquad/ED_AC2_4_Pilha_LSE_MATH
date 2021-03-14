package source;


public interface Stack<E> {
	// Retorna o número de elementos na pilha. 
	public int size(); 
	
	// @return True se a pilha é vazia, False em caso contrário. 
	public boolean isEmpty();
	
	// @return o elemento que está no topo da pilha.
	// @exception EmptyStackException se a pilha estiver vazia.
	public E top() throws EmptyStackException;
	
	 // @param elemento a ser inserido.
	public void push(E elemento); 
	
	 // @return elemento removido. 
	 // @exception EmptyStackException se a pilha estiver vazia. 
	public E pop() throws EmptyStackException; 

	// Limpa o conteudo do vetor
	public void clear();
	// Adicona todos os dados do vetor
	public void addArray(E[] vetor);
	// Verifica se as conchetes e parentese 
	// Dentro do vetor estão corretas!
	public boolean verifyMath();
}
