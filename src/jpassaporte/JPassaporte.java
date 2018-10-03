package jpassaporte;
import java.util.Date;
import java.util.Scanner;

public class JPassaporte {
    
    public static boolean criarAgendamento(Calendario calendario){
        Agendamento agendamento = new Agendamento();
        PerguntaUsuario pergunta = new PerguntaUsuario();
        
        boolean isDataPossivel = false;
        while(!isDataPossivel){
            int[] respostaData = pergunta.PerguntarDataHora("Digite uma data (dd/mm/aaaa hh:mm):");
            
            isDataPossivel = agendamento.setDataHora(respostaData[0], respostaData[1], respostaData[2], respostaData[3], respostaData[4]);
            //SE DATA VÁLIDA VERIFICAR CONFLITO ENTRE OUTRAS DATAS
            if(isDataPossivel){
                System.out.println(agendamento.getDataHora());
                if(calendario.validarAgendamento(agendamento)){
                   calendario.setCriarAgendamento(agendamento);
                   return true;
                }else{
                    System.out.println("Esta horário nao esta vago");
                }
            }else{
                System.out.println("Esta data não esta disponível");
            }
        }
        return false;
    }
    
    public static void mostrar(Calendario calendario){
        
        for(Agendamento _agendamento : calendario.getMostrarTodos()){
            System.out.print(_agendamento.getDataHora() + " ");
            if(_agendamento.getPessoa() != null){
                System.out.println("- " + _agendamento.getPessoa().getNome());
            }else{
                System.out.println("");
            }
        }
        
        for(Agendamento _agendamento : calendario.getMostrarVagos()){
            System.out.println("\nHorarios vagos: ");
            System.out.print(_agendamento.getDataHora() + " ");
            if(_agendamento.getPessoa() != null){
                System.out.println(_agendamento.getPessoa().getNome());
            }else{
                System.out.println("");
            }
        }
        
        for(Agendamento _agendamento : calendario.getMostrarOcupados()){
            System.out.println("\nHorarios ocupados: ");
            System.out.print(_agendamento.getDataHora() + " - ");
            if(_agendamento.getPessoa() != null){
                System.out.println(_agendamento.getPessoa().getNome() + " - " + _agendamento.getPessoa().getId());
            }else{
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        PerguntaUsuario pergunta = new PerguntaUsuario();
        criarAgendamento(calendario);
        
       
        
        
        while(true){
            int opcao = pergunta.PerguntarNumero("Para administrador, digite 1. Para usuário, digite 2:");
            switch(opcao){
                case 1: System.out.println("Admin"); break;
                case 2: System.out.println("Usuário"); break;
                default: System.out.println("Digite um valor válido.");
            }
        }
        
        
        
        
        
        
        


    }
}
