/*TRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETO
* DATA 03/10/2018
* DIANA MACENA CARDOSO DOS SANTOS
* PUCPR
* PROFESSOR: EMERSON CABRERA PARAISO
*/

package jpassaporte;
import java.util.ArrayList;

//CLASSE DE CALENDÁRIO PARA PODER COLOCAR O AGENDAMENTO DENTRO DO ARRAYLIST E CADA ELEMENTO SE TORNAR UM CAMPO NO ARRAY
public class Calendario {
    private ArrayList<Agendamento> listaAgendamento;
    
    public Calendario(){
        listaAgendamento = new ArrayList<Agendamento>();
    }
    
    public ArrayList<Agendamento> getMostrarTodos(){
        return listaAgendamento;
    }
    
    public ArrayList<Agendamento> getMostrarOcupados(){
        ArrayList<Agendamento> consultaTmp = new ArrayList<Agendamento>();
        
        for (Agendamento _agendamento : listaAgendamento) {
            if (_agendamento.getPessoa() != null) {
                consultaTmp.add(_agendamento);
            }
        }
        return consultaTmp;
    }
    
    public ArrayList<Agendamento> getMostrarVagos(){
        ArrayList<Agendamento> consultaTmp = new ArrayList<Agendamento>();
        
        for (Agendamento _agendamento : listaAgendamento) {
            if (null == _agendamento.getPessoa()) {
                consultaTmp.add(_agendamento);
            }
        }
        return consultaTmp;
    }
    
    public void setCriarAgendamento(Agendamento _agendamento){
        listaAgendamento.add(_agendamento);
    }
    
    public void setEditar(Agendamento _agendamento, Pessoa _pessoa){
        for(Agendamento _a : listaAgendamento){
            if(_agendamento.equals(_a)){
                _a.setPessoa(_pessoa);
            }
        } 
    }
    
    public void setApagar(Agendamento _agendamento){
        if(listaAgendamento.contains(_agendamento)){
            listaAgendamento.remove(_agendamento);
        }
    }
    
    public void setSalvar(){}
    
    public void getCarregar(){}
    
    //FUNÇÕES PARA VERIFICAR SE O AGENDAMENTO ESTA SOBREPONTO ALGUMA DATA EXISTENTE NA HORA DE CRIAR AGENDAMENTO
    public boolean validarAgendamento(Agendamento _agendamento){
        DataHora dataTmp = _agendamento.getDataHoraCompleto();
        DataHora horaTmp = _agendamento.getDataHoraCompleto();
        int dataInicial = ((dataTmp.getAno()*10000) + (dataTmp.getMes()*100) + (dataTmp.getDia()*1));
        int horaInicial = ((horaTmp.getHora()*100) + (horaTmp.getMinuto()*1));
        int dataFinal = dataInicial;
        int horaFinal = horaInicial + _agendamento.getDuracao();
        
        if(listaAgendamento.isEmpty()){
            return true;
        }
        for(Agendamento _a: listaAgendamento){
            DataHora dataTmpA = _a.getDataHoraCompleto();
            DataHora horaTmpA = _a.getDataHoraCompleto();
            int dataInicialA = ((dataTmpA.getAno()*10000) + (dataTmpA.getMes()*100) + (dataTmpA.getDia()*1));
            int horaInicialA = ((horaTmpA.getHora()*100) + (horaTmpA.getMinuto()*1));
            int dataFinalA = dataInicialA;
            int horaFinalA = horaInicialA + _a.getDuracao();
            
            if((dataInicial > dataFinalA) || (dataFinal < dataInicialA) ){
                return true;
            }else if((horaFinal <= horaInicialA) || (horaInicial >= horaFinalA)){
                    return true;
            }else{
                
                return false;
            }
            
        }//FIM DO FOR
        System.out.println("*********Data já criada, por favor escolha novamente*************");
        return false;
    }//TESTE É O _AGENDAMENTO // LISTA É O _A
}
