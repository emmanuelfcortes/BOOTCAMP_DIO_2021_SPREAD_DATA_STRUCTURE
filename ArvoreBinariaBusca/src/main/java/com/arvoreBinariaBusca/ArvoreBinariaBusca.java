package com.arvoreBinariaBusca;

//import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArvoreBinariaBusca<T extends Comparable <T>>{
    private NoArvore<T> raiz;
    private int posicao;
    private class Alvo{
        private NoArvore<T> no = new NoArvore<T>();
        private int posicao;
        public Alvo(){}
        public Alvo(NoArvore<T> no, int posicao){
            this.no = no;
            this.posicao = posicao;
        }

        @Override
        public String toString() {
            return "Alvo{" +
                    "no=" + no +
                    ", posicao=" + posicao +
                    '}';
        }
    }

    public ArvoreBinariaBusca() {
    }

    public void inserir(T conteudo){
        NoArvore<T> novoNo = new NoArvore<T>(conteudo);
        this.raiz = this._inserir(this.raiz,novoNo);
    }

    public void exibirInOrdem(){
        System.out.println("Exibir InOrdem: ");
        this._exibirArvoreInOrdem(raiz);
    }
    public void exibirPreOrdem(){
        System.out.println("Exibir PreOrdem: ");
        this._exibirArvorePreOrdem(raiz);
    }
    public void exibirPosOrdem(){
        System.out.println("Exibir PosOrdem: ");
        this._exibirArvorePosOrdem(raiz);
    }

    public void remove(T conteudo){
        List <NoArvore<T>> nosAvaliacao = new ArrayList();
        NoArvore<T> noAlvo;
        int posicaoNoAlvo = 0;
        nosAvaliacao.add(raiz);

        if(raiz==null)
            System.out.println("Árvore vazia");
        else{
            Alvo alvo = encontrarNo(conteudo);
            noAlvo = alvo.no;
            posicaoNoAlvo = alvo.posicao;
           /*
            noAlvo = null;

            while( noAlvo == null ) { // nó para encontrar o noAlvo a ser removido, a partir do conteúdo
                for (int i = 0; i < nosAvaliacao.size(); i++) {
                    if(nosAvaliacao.get(i)!= null){
                        if(nosAvaliacao.get(i).getConteudo() == conteudo){
                            noAlvo = nosAvaliacao.get(i);
                            //System.out.println("Achou! Posição "+posicaoNoAlvo);
                            break;
                        }
                    }
                    posicaoNoAlvo++;
                }

               if(noAlvo== null)
                    nosAvaliacao=_criarListaFilhos(nosAvaliacao);

            }
            */

            System.out.println("O alvo é o: "+noAlvo.getConteudo()+", na posição "+posicaoNoAlvo);

            NoArvore<T> noAlvoAux = noAlvo;
            NoArvore<T> noSubstituto = new NoArvore<T>();
            boolean condicaoDeSaida=false;
            while(!condicaoDeSaida) {// laço para exclusão do noAlvo e reconstrução da árvore
                if (noAlvoAux.getNoEsq() == null && noAlvoAux.getNoDir() == null) {
                    noAlvoAux = null;
                    condicaoDeSaida = true;
                } else if (noAlvoAux.getNoEsq() != null) {
                    if (noAlvoAux.getNoEsq().getNoDir() != null) {
                        noSubstituto = noAlvoAux.getNoEsq().getNoDir();
                        noAlvoAux.setConteudo(noSubstituto.getConteudo());
                        noAlvoAux = noSubstituto;
                    } else {
                        noSubstituto = noAlvoAux.getNoEsq();
                        noAlvoAux.setConteudo(noSubstituto.getConteudo());
                        noAlvoAux = noSubstituto;
                    }
                } else if (noAlvoAux.getNoDir() != null) {
                    if( noAlvoAux.getNoDir().getNoEsq()!= null ) {
                        noSubstituto = noAlvoAux.getNoDir().getNoEsq();
                        noAlvoAux.setConteudo(noSubstituto.getConteudo());
                        noAlvoAux = noSubstituto;
                    }
                    else{
                        noSubstituto = noAlvoAux.getNoDir();
                        noAlvoAux.setConteudo(noSubstituto.getConteudo());
                        noAlvoAux = noSubstituto;
                    }

                }
            }

        }
    }


    public Alvo encontrarNo(@NotNull T conteudo){
        NoArvore<T> noAlvo= null;
        List<NoArvore<T>> nosAvaliacao = new ArrayList<NoArvore<T>>();
        int posicaoNoAlvo=0;
        nosAvaliacao.add(raiz);
        while( noAlvo == null ) { // nó para encontrar o noAlvo a ser removido, a partir do conteúdo
            for (int i = 0; i < nosAvaliacao.size(); i++) {
                if(nosAvaliacao.get(i)!= null){
                    if(nosAvaliacao.get(i).getConteudo() == conteudo){
                        noAlvo = nosAvaliacao.get(i);

                        break;
                    }
                }
                posicaoNoAlvo++;
            }

            if( noAlvo == null ) {
                nosAvaliacao = _criarListaFilhos(nosAvaliacao);
                if(listaDeNosNulos(nosAvaliacao)){
                    System.out.println("Elemento não encontrado!");
                    return null;
                }
            }

        }
        return new Alvo(noAlvo,posicaoNoAlvo);
    }
    public NoArvore<T> encontrarNoImplementacaoProfessor(T conteudo){
        if(raiz==null){
            System.out.println("Arvore vazia!");
            return null;
        }
        else {
            NoArvore<T> noAux = raiz;
            while (noAux != null && noAux.getConteudo() != conteudo) {
                if (conteudo.compareTo(noAux.getConteudo()) < 0)
                    noAux = noAux.getNoEsq();
                else if( conteudo.compareTo( noAux.getConteudo() ) > 0 )
                    noAux = noAux.getNoDir();
            }
            if(noAux==null) {
                System.out.println("Conteúdo não encontrado!");
                return null;
            }

            return noAux;
        }
    }
    private boolean listaDeNosNulos(List<NoArvore<T>> listaDeNos){
        for(NoArvore<T> no: listaDeNos){
            if(no!=null)
                return false;
        }
        return true;
    }
    private List<NoArvore<T>> _criarListaFilhos(@NotNull List<NoArvore<T>> listaNoPais){
        int sizeListaNosPais = listaNoPais.size();
        List<NoArvore<T>> ListaNosFilhos= new ArrayList();
        for(int i=0; i< sizeListaNosPais; i++){

            if(listaNoPais.get(i)!= null){
                ListaNosFilhos.add(listaNoPais.get(i).getNoEsq());
                ListaNosFilhos.add(listaNoPais.get(i).getNoDir());
            }
            else{
                ListaNosFilhos.add(null);
                ListaNosFilhos.add(null);
            }

        }
        return ListaNosFilhos;

    }
    private void _exibirArvoreInOrdem(NoArvore<T> noExibicao){
        if(noExibicao==null)
            return;

        if(noExibicao.getNoEsq()!=null){
           this._exibirArvoreInOrdem(noExibicao.getNoEsq());
        }

        System.out.println(noExibicao.getConteudo()+" , ");
        if(noExibicao.getNoDir()!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoDir());
        }

        /* IMPLEMENTAÇÃO PROFESSOR

        if(noExibicao!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoEsq());
            System.out.println(noExibicao.getConteudo()+ ", ");
            this._exibirArvoreInOrdem(noExibicao.getNoDir());
        }
         * */


    }
    private void _exibirArvorePreOrdem(NoArvore<T> noExibicao){
        if(noExibicao==null)
            return;
        System.out.println(noExibicao.getConteudo());
        if(noExibicao.getNoEsq()!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoEsq());
        }
        if(noExibicao.getNoDir()!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoDir());

        }
         /* IMPLEMENTAÇÃO PROFESSOR

        if(noExibicao!=null){
            System.out.println(noExibicao.getConteudo()+ ", ");
            this._exibirArvoreInOrdem(noExibicao.getNoEsq());
            this._exibirArvoreInOrdem(noExibicao.getNoDir());
        }
         * */

    }

    private void _exibirArvorePosOrdem(NoArvore<T> noExibicao){
        if(noExibicao==null)
            return;

        if(noExibicao.getNoEsq()!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoEsq());
        }
        if(noExibicao.getNoDir()!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoDir());
        }
        System.out.println(noExibicao.getConteudo());

        /* IMPLEMENTAÇÃO PROFESSOR

        if(noExibicao!=null){
            this._exibirArvoreInOrdem(noExibicao.getNoEsq());
            this._exibirArvoreInOrdem(noExibicao.getNoDir());
            System.out.println(noExibicao.getConteudo()+ ", ");
        }
         * */
    }

    private NoArvore<T> _inserir(NoArvore<T> atual, NoArvore<T> novoNo){
        if(atual == null){
            atual = novoNo;
            return atual;
        }
        else if(atual.getConteudo().compareTo(novoNo.getConteudo())>=0){
            atual.setNoEsq(this._inserir(atual.getNoEsq(),novoNo));
        }
        else if(atual.getConteudo().compareTo(novoNo.getConteudo())<0){
            atual.setNoDir(this._inserir(atual.getNoDir(),novoNo));
        }
        return atual;
    }

}
