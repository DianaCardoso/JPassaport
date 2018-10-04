/*TRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETO
* DATA 03/10/2018
* DIANA MACENA CARDOSO DOS SANTOS
* PUCPR
* PROFESSOR: EMERSON CABRERA PARAISO
*/

package jpassaporte;
import java.util.Date;
import java.util.Scanner;

public class JPassaporte {
    
    //FUNÇÃO PARA CRIAR DATAS PARA O USUÁRIO PODER AGENDAR
    public static boolean criarAgendamento(Calendario calendario){
        Agendamento agendamento = new Agendamento();
        PerguntaUsuario pergunta = new PerguntaUsuario();
        
        boolean isDataPossivel = false;
        while(!isDataPossivel){
            int[] respostaData = pergunta.PerguntarDataHora("Digite uma data (dd/mm/aaaa hh:mm):");
            
            isDataPossivel = agendamento.setDataHora(respostaData[0], respostaData[1], respostaData[2], respostaData[3], respostaData[4]);
            
            //SE DATA VÁLIDA VERIFICAR CONFLITO ENTRE OUTRAS DATAS
            if(isDataPossivel){
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
    
    //MOSTRA TODAS AS DATAS PARA O ADMINISTRADOR
    public static void mostrarTodos(Calendario calendario){
        for(Agendamento _agendamento : calendario.getMostrarTodos()){
            System.out.print(_agendamento.getDataHora() + " ");
            if(_agendamento.getPessoa() != null){
                System.out.println("- " + _agendamento.getPessoa().getNome());
            }else{
                System.out.println("");
            }
        }
    }
    
    //MOSTRA DATAS VAGAS PARA O ADMINISTRADOR
    public static void mostrarVagos(Calendario calendario){
        for(Agendamento _agendamento : calendario.getMostrarVagos()){
            System.out.println("\nHorarios vagos: ");
            System.out.print(_agendamento.getDataHora() + " ");
            if(_agendamento.getPessoa() != null){
                System.out.println(_agendamento.getPessoa().getNome());
            }else{
                System.out.println("");
            }
        }
    }
    
    //MOSTRA DATAS OCUPADAS PARA O ADMINISTRADOR
    public static void mostrarOcupados(Calendario calendario){
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
    
    //FUNÇÃO PARA O USUÁRIO PODER EDITAR UMA DATA VAGA
    public static void editarVaga(Calendario calendario, Pessoa _pessoa){
        int i = 0;
        PerguntaUsuario pergunta = new PerguntaUsuario();
        Agendamento agendamento = new Agendamento();
        
        for(Agendamento _agendamento : calendario.getMostrarVagos()){
            System.out.println(i++ + " " + _agendamento.getDataHora());
        }
        int opcao = pergunta.PerguntarNumero("Digite o número da data que deseja agendar: ");
        agendamento = calendario.getMostrarVagos().get(opcao);
        calendario.setEditar(agendamento, _pessoa);
    }
    
    //FUNÇÃO DO ADMINISTRADOR
    public static void admin(Calendario calendario){
        PerguntaUsuario pergunta = new PerguntaUsuario();
        
        while(true){
            int opcao = pergunta.PerguntarNumero("\n1 - Cadastrar datas \n2 - Mostrar datas ocupadas \n3 - Mostrar datas vagas \n4 - Mostrar todas as vagas \n5 - Sair \nDigite a opção desejada:  ");
            switch(opcao){
                case 1: criarAgendamento(calendario);break;
                case 2: mostrarOcupados(calendario); break;
                case 3: mostrarVagos(calendario); break;
                case 4: mostrarTodos(calendario); break;
                case 5: return;
                default: System.out.println("************Digite um valor válido.************");
            }
        }
    }
    
    //FUNÇÃO DO USUÁRIO
    public static void usuario(Calendario calendario){
        PerguntaUsuario pergunta = new PerguntaUsuario();
        Agendamento _agendamento = new Agendamento();
        Pessoa _pessoa = new Pessoa(pergunta.Perguntar("Digite seu nome: "), pergunta.PerguntarNumero("Digite seu RG: "));
        
        while(true){
            int opcao = pergunta.PerguntarNumero("\n1 - Datas livres \n2 - Agendar uma data \n3 - Volta \nDigite a opção desejada:  ");
            switch(opcao){
                case 1: mostrarVagos(calendario); break;
                case 2: editarVaga(calendario, _pessoa); System.out.println("************Agendado com sucesso!************");break;
                case 3: return;
                default: System.out.println("************Digite um valor válido.************");
            }
        }
    }
    
    public static void impressao() {
        Agendamento agendamento = new Agendamento();
        System.out.println("******************************************************************");
        System.out.println("******PROGRAMA DE AGENDAMENTO DE ENTREVISTA PARA O PASSAPORTE*****");
        System.out.println("******************************************************************");
        System.out.println("********DESENVOLVIDO POR DIANA MACENA CARDOSO DOS SANTOS**********");
        System.out.println("*****************************PUCPR********************************");
        System.out.println("***************************02/10/2018*****************************");
        System.out.println("******************************************************************");
        System.out.println(agendamento.getTarefa());
        
    }

    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        PerguntaUsuario pergunta = new PerguntaUsuario();
        
        impressao();
        
        
        while(true){
            int opcao = pergunta.PerguntarNumero("1 - Administrador \n2 - Usuário \nDigite a opcão desejada:");
            switch(opcao){
                case 1: admin(calendario); break;
                case 2: usuario(calendario); break;
                default: System.out.println("************Digite um valor válido.************");
            }
        }
    }
}
