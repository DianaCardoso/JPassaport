/*TRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETO
* DATA 03/10/2018
* DIANA MACENA CARDOSO DOS SANTOS
* PUCPR
* PROFESSOR: EMERSON CABRERA PARAISO
*/

package jpassaporte;

//CLASSE DE PESSOA PARA ATRIBUIR NUMA DATA
public class Pessoa {
    private String nome;
    private int id;
    
    public Pessoa (String _nome, int _id){
        setNome(_nome);
        setId(_id);
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String _nome){
        nome = _nome;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int _id){
        id = _id;
    }
    
}
