package com.ListaDuplamenteEncadeada;


public class ListaDupla<T> {
    private NoDuplo<T> primeiroNo= null;
    private int size=0;
    public void ListaEncadeada(){

    }
    public int length(){
        return this.size;
    }


    public boolean isEmpty(){

        return primeiroNo==null;
    }
    public void add(T novoConteudo){
        NoDuplo<T> novoNo = new NoDuplo<T>(novoConteudo);
        int index = 0;
        if(isEmpty()){
            primeiroNo=novoNo;
            primeiroNo.setAnteriorNo(null);
            primeiroNo.setProximoNo(null);
        }

        else{
            NoDuplo ultimo=primeiroNo;
            while(true) {
                index++;
                if(ultimo.getProximoNo()!=null){
                    ultimo = ultimo.getProximoNo();
                }
                else{

                    ultimo.setProximoNo(novoNo);
                    novoNo.setAnteriorNo(ultimo);
                    break;
                }
            }
        }
        this.atualizarLength("add");

    }
    public void add( T novoConteudo, int novoIndex){
        NoDuplo<T> novoNo= new NoDuplo<T>(novoConteudo);

        if(!indexValido(novoIndex)){

            throw new IndexOutOfBoundsException("Indice "+novoIndex+" inválido. O tamanho da Lista é de "+ this.length());
        }


        else if(isEmpty()){
            primeiroNo = novoNo;
            primeiroNo.setProximoNo(null);
            primeiroNo.setAnteriorNo(null);
        }
        else{
            NoDuplo<T> noAlvo=primeiroNo;
            for(int i=0; i< novoIndex; i++) {
                noAlvo=noAlvo.getProximoNo();
            }
            if(noAlvo==primeiroNo){
                    NoDuplo<T> noAux = primeiroNo;
                    primeiroNo = novoNo;
                    primeiroNo.setAnteriorNo(null);
                    primeiroNo.setProximoNo(noAux);
                    noAux.setAnteriorNo(primeiroNo);
                    noAux.setProximoNo(null);
            }
            else if(noAlvo.getProximoNo()==null){// último no
                noAlvo.setProximoNo(novoNo);
                novoNo.setAnteriorNo(noAlvo);
                novoNo.setProximoNo(null);
            }
            else if(noAlvo.getProximoNo()!=null && noAlvo.getAnteriorNo()!= null){
                /*INSERÇÃO FEITA DESLOCANDO O NÓ ALVO PARA A DIREITA (POSICAO MAIOR) DA LISTA*/

                NoDuplo<T> noAlvoAnterior = noAlvo.getAnteriorNo();
                noAlvoAnterior.setProximoNo(novoNo);
                novoNo.setAnteriorNo(noAlvoAnterior);
                novoNo.setProximoNo(noAlvo);
                noAlvo.setAnteriorNo(novoNo);
            }


        }
        this.atualizarLength("add");

    }
    public T remove(int index){
        T toReturn = null;

        if(indexValido(index)==false){

            throw new IndexOutOfBoundsException("Indice "+index+" inválido. O tamanho da Lista é de "+ this.length());
        }


        else if(isEmpty()){

            throw new IndexOutOfBoundsException("Erro ao remover. A lista já está vazia.");
        }
        else{
            NoDuplo<T> noAlvo = primeiroNo;
            for( int i=0 ; i < index ; i++ ) {
                noAlvo = noAlvo.getProximoNo();
            }

            toReturn=noAlvo.getConteudo();

            if(noAlvo==primeiroNo && primeiroNo.getProximoNo()==null){

                primeiroNo = null;
            }
            else if(noAlvo==primeiroNo){
                primeiroNo=primeiroNo.getProximoNo();
            }
            else if( noAlvo.getProximoNo() == null ){// ÚLTIMO NÓ

                NoDuplo<T> novoNoUltimo= noAlvo.getAnteriorNo();
                novoNoUltimo.setProximoNo(null);
            }
            else if( noAlvo.getProximoNo()!= null && noAlvo.getAnteriorNo()!= null ){

                NoDuplo<T> noAlvoAnterior = noAlvo.getAnteriorNo();
                NoDuplo<T> noAlvoProximo = noAlvo.getProximoNo();
                noAlvoAnterior.setProximoNo(noAlvoProximo);
                noAlvoProximo.setAnteriorNo(noAlvoAnterior);
            }
        }
        this.atualizarLength("remove");
        return toReturn;
    }

    public T getNo(int index){// retornar o elemento da lista na posição indicada por "index".

        if(!indexValido(index)){

            throw new IndexOutOfBoundsException("Indice "+index+" inválido. O tamanho da Lista é de "+ this.length());
        }

        if(isEmpty()){
            throw new IndexOutOfBoundsException("Fila vazia. Não pode retornar um elemento");
        }

        else{
            NoDuplo<T> noAux = this.primeiroNo;
            for( int i=0 ; i < index ; i++ ) {
                noAux = noAux.getProximoNo();
            }
            return noAux.getConteudo();

        }
    }
    public T get(){ // retorna o conteudo do primeiro elemento da Lista e apaga-o
        if(isEmpty()){
            System.out.println("A lista está vazia.");
            return null;
        }
        else {
            NoDuplo<T> noReturn = primeiroNo;
            primeiroNo=primeiroNo.getProximoNo();
            primeiroNo.setAnteriorNo(null);
            atualizarLength("remove");
            return noReturn.getConteudo();
        }
    }
    @Override
    public String toString(){
        NoDuplo aux = this.primeiroNo;
        String stringToReturn="ListaDupla{";

        if(aux==null)
            return stringToReturn+" }";

        for(int i=0; aux!= null; i++){
            stringToReturn+="NoDuplo"+i+":"+aux.getConteudo()+" <=> ";
            aux=aux.getProximoNo();
        }
        return stringToReturn+"null }";
    }



    private void atualizarLength(String operation){
        if(operation =="add")
            this.size++;
        else if(operation == "remove")
            this.size--;
        else
            System.out.println("Não pode atualizar o tamanho da Lista. Operação inválida.");

    }
    private boolean indexValido(int novoIndex){
        int sizeNow = this.length();

        if(sizeNow==0)
            return novoIndex==0;
        else
            return novoIndex>=0 && novoIndex<sizeNow;
    }
}
