package com.projetopilha;

public class Pilha {
   private No refNoEntradaPilha;
   public Pilha(){
       this.refNoEntradaPilha=null;
   }

   public No pop(){
       if(isEmpty())
           return null;
       No toReturn = refNoEntradaPilha;
       //refNoEntradaPilha.setReference(refNoEntradaPilha.getReference().getReference());
       refNoEntradaPilha = refNoEntradaPilha.getReference();
       return toReturn;
   }
   public void push(No novoNo){
        No noAux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setReference(noAux);
    }
    public No top(){
        return refNoEntradaPilha;
    }
   public boolean isEmpty(){
       return this.refNoEntradaPilha==null?true:false;
   }

    @Override
    public String toString() {
       No aux = refNoEntradaPilha;
       String toReturn="Pilha{ ";
       while(aux!= null){
           toReturn+=aux.getDado()+", ";
           aux=aux.getReference();
       }
       return toReturn+" }";
    }
}
