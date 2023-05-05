package br.com.KauanPaulino.SetInt;

public class SetInt {
	No primeiro;
	
	//teste lista vazia
	public boolean isEmpty() {
		if(primeiro==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//Tamanho da lista
	public int size() {
		int cont=0;
		if(!isEmpty()) {
			No auxiliar = primeiro;
			while(auxiliar != null) {
				cont +=1;
				auxiliar=auxiliar.proximo;
			}
		}
		return cont;
	}
	
	public No getNo(int pos)throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho=size();
		if(pos < 0 || pos >tamanho-1){
			throw new Exception("Posição Invalida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while(cont<pos) {
			auxiliar=auxiliar.proximo;
			cont += 1;
		}
		return auxiliar;
	}
	
	//Adicionar elemento no inicio
	
	public void addFirst(int valor) {
		int tamanho = size();
		boolean status=true;
		if(tamanho>0) {
			try {
				status=VerificaSeExiste(valor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(status==true) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
		}
	}
	
	//Adicionar elemento no fim
	
	public void addLast(int valor) throws Exception{
		int tamanho = size();
		boolean status=true;
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		try {
			status=VerificaSeExiste(valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==true) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = null;
		No ultimo = getNo(tamanho-1);
		ultimo.proximo=elemento;
		}
	}
	
	// Adicionar elemento em qualquer posicao;
	
	public void add(int valor, int pos) throws Exception {
		int tamanho = size();
		boolean status=true;
		if(pos<0 || pos>tamanho) {
			throw new Exception("Posição Invalida");
		}
		try {
			status=VerificaSeExiste(valor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status==true) {
		if(pos==0) {
			addFirst(valor);
		} else if( pos == tamanho) {
			addLast(valor);
		}else {
			No elemento = new No();
			elemento.dado=valor;
			No anterior = getNo(pos-1);
			elemento.proximo = anterior.proximo;
			anterior.proximo= elemento;
		}
		}
	}
	
	//Remover 1 posicao
	public void removeFirst() throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}
	
	//remove ultima posicao
	public void removeLast() throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho=size();
		if(tamanho==1) {
			removeFirst();
		}else {
			No penultimo = getNo(tamanho-2);
			penultimo.proximo = null;
		}
	}
	
	//remove qualquer posicao
	public void remove(int pos) throws Exception{
		int tamanho=size();
		if(pos < 0 || pos > tamanho-1) {
			throw new Exception("Posicao Invalida");
		}
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		if(pos==0) {
			removeFirst();
		} else if(pos==tamanho-1) {
			removeLast();
		} else {
			No anterior = getNo(pos-1);
			No atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}
	
	//Acessando elemento da lista
	
	public int get(int pos) throws Exception{
		if(isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if(pos < 0 || pos > tamanho-1) {
			throw new Exception("Posicao Invalida");
		}
		int cont=0;
		No auxiliar = primeiro;
		while(cont<pos){
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar.dado;
		
	}
	
	private boolean VerificaSeExiste(int valor) throws Exception {
		int tamanho=size();
		boolean status=true;
		for(int i=0;i<tamanho;i++) {
			int pos;
			try {
				pos = get(i);
				if(valor==pos) {
					status=false;
					throw new Exception("Ja existe o valor:" + valor + " Nessa lista");
				}
				else {
					status=true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
		
	}
}
