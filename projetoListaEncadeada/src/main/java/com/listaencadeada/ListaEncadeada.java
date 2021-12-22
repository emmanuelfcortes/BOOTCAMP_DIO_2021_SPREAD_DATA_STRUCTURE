package com.listaencadeada;

public class ListaEncadeada<T>{
    //FIFO - First In First Out
    private No<T> primeiroNo= null;
    private int size=0;
    public void ListaEncadeada(){

    }
    public int length(){
        return this.size;
    }


    public boolean isEmpty(){
        return this.primeiroNo==null;
    }
    public void add(T novoConteudo){
        No<T> novoNo = new No<>(novoConteudo);
        int index = 0;
        this.atualizarLength("add");
        if(isEmpty()){
            primeiroNo=novoNo;
            primeiroNo.setIndex(index);
        }

        else{
            No ultimo=primeiroNo;
            do {
                index++;
                if(ultimo.getProximoNo()!=null){
                    ultimo = ultimo.getProximoNo();
                }
                else{
                    novoNo.setIndex(index);
                    ultimo.setProximoNo(novoNo);
                    break;
                }
            }
            while(true);
        }

    }
    public void add( T novoConteudo, int novoIndex){
        No<T> novoNo= new No<>(novoConteudo);
        this.atualizarLength("add");
        if(isEmpty()){
            primeiroNo=novoNo;
            primeiroNo.setIndex(0);
            System.out.println("Lista vazia. No adicionado ao primeiro elemento.");

        }
        else if(novoIndex==0){
            novoNo.setProximoNo(primeiroNo);
            primeiroNo = novoNo;
            primeiroNo.setIndex(0);
            this.atualizarIndex(this.primeiroNo.getProximoNo(),"add");

        }
        else{
            No aux=primeiroNo;
            while(true){
                if(aux.getProximoNo()==null && aux.getIndex()!= novoIndex){
                    System.out.println("O índice informado é inválido. O Nó foi adicionado ao final da lista");
                    this.atualizarLength("remove");// desfazendo a atualização feita no inicio do metodo
                    this.add(novoNo.getConteudo());
                    break;
                }
                else if(aux.getProximoNo().getIndex()==novoIndex){
                    No noAlvo = aux.getProximoNo();
                    novoNo.setIndex(novoIndex);
                    aux.setProximoNo(novoNo);
                    novoNo.setProximoNo(noAlvo);
                    this.atualizarIndex(noAlvo,"add");
                    break;
                }


                else{
                    aux=aux.getProximoNo();
                }
            }
        }
    }
    public No<T> remove(int index){
        if(isEmpty()){
            System.out.println("A lista já está vazia.");
            return null;
        }
        else if(index==0){
            No<T> noReturn = this.primeiroNo;
            this.primeiroNo=this.primeiroNo.getProximoNo();
            this.atualizarIndex(this.primeiroNo,"remove");
            this.atualizarLength("remove");
            return noReturn;
        }
        else{
            No<T> aux = this.primeiroNo;
            while(true){
                    if(aux.getProximoNo().getIndex()==index){
                        No<T> aux2 = aux.getProximoNo();
                        aux.setProximoNo(aux2.getProximoNo());
                        this.atualizarIndex(aux2,"remove");
                        this.atualizarLength("remove");
                        return aux2;
                    }
                    else if(aux.getProximoNo()==null){ //final da lista
                        System.out.println("Não pode remover. Indice inválido");
                        return null;
                    }
                    else{
                        aux=aux.getProximoNo();
                    }
            }

        }
    }
    public T getNo(int index){// retornar o elemento da lista na posição indicada por "index".
        if(isEmpty()){
            System.out.println("A lista está vazia.");
            return null;
        }

        else{
            No<T> aux = this.primeiroNo;
            while(true){
                if(aux.getIndex()==index){
                    return aux.getConteudo();
                }
                else if(aux.getProximoNo()==null){ //final da lista
                    System.out.println("Indice inválido. Não pode encontrar o elemento.");
                    return null;
                }
                else{
                    aux=aux.getProximoNo();
                }
            }

        }
    }
    public T get(){ // retorna o conteudo do primeiro elemento da Lista e apaga-o
        if(isEmpty()){
            System.out.println("A lista está vazia.");
            return null;
        }
        else {
            No<T> noReturn = this.primeiroNo;
            this.primeiroNo=this.primeiroNo.getProximoNo();
            this.atualizarIndex(this.primeiroNo,"remove");
            this.atualizarLength("remove");
            return noReturn.getConteudo();
        }
    }
    @Override
    public String toString(){
        No aux = this.primeiroNo;
        String stringToReturn="Lista{";

        if(aux==null)
            return stringToReturn+" }";
        int i=0;
        while(aux!=null){
            stringToReturn+="No"+i+":"+aux.getConteudo()+", ";
            i++;
            aux=aux.getProximoNo();
        }
        return stringToReturn+" }";
    }

    public String indexes(){
        No aux = this.primeiroNo;
        String stringToReturn="Indexes{";

        if(aux==null)
            return stringToReturn+" }";
        int i=0;
        while(aux!=null){
            stringToReturn+="No"+i+":"+aux.getIndex()+", ";
            i++;
            aux=aux.getProximoNo();
        }
        return stringToReturn+" }";
    }


    private void atualizarIndex(No<T> noDePartida, String operation){
        No aux = noDePartida;
        if(noDePartida==null){
            return;
        }
        int correcao=0;

        if(operation=="add")
            correcao = 1;
        else if (operation=="remove")
            correcao = -1;
        else{
            System.out.println("Erro de atualização do index da fila. Operação desconhecida.");
            return;
        }

        do{
            aux.setIndex(aux.getIndex()+correcao);
            aux=aux.getProximoNo();
        }
        while(aux!=null);

    }
    private void atualizarLength(String operation){
        if(operation =="add")
            this.size++;
        else if(operation == "remove")
            this.size--;
        else
            System.out.println("Não pode atualizar o tamanho da Lista. Operação inválida.");

    }
}
