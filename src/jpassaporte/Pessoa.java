package jpassaporte;

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
