package jpassaporte;

public class Agendamento { 
    private String tarefa;
    private Pessoa pessoa;
    private int duracao;
    private DataHora dataHora;
    
    public Agendamento(String _tarefa){ //Construtor só para poder alterar o nome da tarefa.
        setTarefa(_tarefa);
        setPessoa(null);
        setDuracao(30);
    }
    public Agendamento(){
        setTarefa("Agendamento Passaporte");
        setPessoa(null);
        setDuracao(30);
        dataHora = new DataHora();
    }
    
    public void setTarefa(String _tarefa){
        tarefa = _tarefa;
    } 
    public String getTarefa(){
        return tarefa;
    }
    
    public void setPessoa(Pessoa _pessoa){
        pessoa = _pessoa;
    }
    public Pessoa getPessoa(){
        return pessoa;
    }
    
    public void setDuracao(int _duracao){
        duracao = _duracao;
    }
    public int getDuracao(){
        return duracao;
    } 
   
    public boolean setDataHora(int _dia, int _mes, int _ano, int _hora, int _minuto){
        if(dataHora.setDataHora(_dia, _mes, _ano, _hora, _minuto)){
            return dataHora.isAfterToday();
        }
        return false;
    }
    public String getDataHora(){
        return dataHora.getDataHoraFormatado();
    }
    
    public DataHora getDataHoraCompleto(){
        return dataHora;
    }

    
}
