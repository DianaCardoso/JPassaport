/*TRABALHO DE PROGRAMAÇÃO ORIENTADA A OBJETO
* DATA 03/10/2018
* DIANA MACENA CARDOSO DOS SANTOS
* PUCPR
* PROFESSOR: EMERSON CABRERA PARAISO
*/

package jpassaporte;

import java.util.Scanner;

//CLASSE PARA PERGUNTAS E RESPOSTAS FEITAS DURANTE O PROGRAMA
//SERVE PARA VALIDAR SE A PERGUNTA É DO TIPO DATAHORA, DO TIPO NUMERO E DO TIPO DADOS
//JÁ LÊ O TECLADO E RETORNA COM OS VALORES DIGITADOS
public class PerguntaUsuario {
     
    public int[] PerguntarDataHora(String _pergunta){
        int[] respostaFormatada = {1,2,3,4,5};
        String resposta = null;
        Scanner teclado = new Scanner(System.in);
        while (resposta == null) {            
            System.out.println(_pergunta);
            if (teclado.hasNextLine()) {
                String tmp = teclado.nextLine().trim();
                if (!"".equals(tmp) ) {
                    try{
                        String array[] = new String[2];
                        array = tmp.split(" ");
                        String dataTmp = array[0];
                        String dataArray[] = dataTmp.split("/");

                        String horaTmp = array[1];
                        String horaArray[] = horaTmp.split(":");
                        respostaFormatada = new int[] {Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2]), Integer.parseInt(horaArray[0]), Integer.parseInt(horaArray[1])};
                        break;
                    
                    }catch (NumberFormatException e){ // Catch para coisas digitadas que não são numeros
                        System.out.println("Alguma coisa aí não é um número");
                        resposta= null;
                    }
                    catch(IndexOutOfBoundsException n){ // Quando é digitado fora do formato padrão
                        System.out.println("Formato inválido, por favor digitar corretamente...");
                        resposta= null;
                    }
                }
            }
        }
        return respostaFormatada;
    }
    
    public String Perguntar(String _pergunta){
        String resposta = null;
        Scanner teclado = new Scanner(System.in);
        while (resposta == null) {            
            System.out.println(_pergunta);
            if (teclado.hasNextLine()) {
                String tmp = teclado.nextLine().trim();
                if (!"".equals(tmp) ) {
                resposta = tmp;
                }
            }
        }
        return resposta;      
    }
    
    public int PerguntarNumero(String _pergunta){
        String resposta = null;
        int respostaNumero = -1;
        Scanner teclado = new Scanner(System.in);
        while (resposta == null) {            
            System.out.println(_pergunta);
            if (teclado.hasNextLine()) {
                String tmp = teclado.nextLine().trim();
                if (!"".equals(tmp) ) {
//                    Try/catch é usado para tentar executar um bloco de código,
//                      E executa outro, caso houver algum erro
//                      Neste caso, se o erro for NumberFormatException
//                      Vai voltar a ler e ignorar o que foi digitado
                    try{
                        respostaNumero = Integer.parseInt(tmp);
                        break;
                    }catch(NumberFormatException e){
                        System.out.println("Inválido, por favor digite novamente...");
                        resposta= null;
                    }
                    
                }
            }
        }
        return respostaNumero;
    }
    
}
