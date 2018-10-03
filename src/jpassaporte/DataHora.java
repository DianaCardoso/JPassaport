package jpassaporte;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DataHora {
    private int dia, mes, ano, hora, minuto;
    
    public DataHora(int _dia, int _mes, int _ano, int _hora, int _minuto){
        setDia(_dia);
        setMes(_mes);
        setAno(_ano);
        setHora(_hora);
        setMinuto(_minuto);
    }
    
    public DataHora (){
        inicializarDataHora();
    }
    
    public void inicializarDataHora(){
        dia = 0;
        mes = 0;
        ano = 0;
        hora = 0;
        minuto = 0;
    }
    
    public boolean setDataHora(int _dia, int _mes, int _ano, int _hora, int _minuto){
        if(
                (!setDia(_dia)) || (!setMes(_mes)) ||(!setAno(_ano)) ||
                (!setHora(_hora)) ||(!setMinuto(_minuto))
            ){
            return false;
        }
        return true;
    }
    
    public int getDia(){ 
        return dia; 
    }
    public boolean setDia(int _dia){
        if(_dia >= 1 && _dia <= 31){
            dia = _dia;
            return true;
        }else{
            return false;
        }
    }
    
    public int getMes(){ 
        return mes; 
    }
    public boolean setMes(int _mes){
        if(_mes >= 1 && _mes <= 12){
            mes = _mes;
            return true;
        }else{
            return false;
        }
    }
        
    public int getAno(){ 
        return ano; 
    }
    public boolean setAno(int _ano){
        if(_ano >= 0){
            ano = _ano;
            return true;
        }else{
            return false;
        }
    }
    
    public int getHora(){
        return hora;
    }
    public boolean setHora(int _hora) {
        if(_hora >= 0 && _hora <=23){
            hora = _hora;
            return true;
        }else{
            return false;
        }
    }
    
    public int getMinuto(){
        return minuto;
    }
    public boolean setMinuto(int _minuto) {
        if(_minuto >= 0 && _minuto <=59){
            minuto = _minuto;
            return true;
        }else{
            return false;
        }
    }
    
    public String getDataHoraFormatado(){
        String retorno = "";
        retorno+=dia;
        retorno+= "/";
        retorno+=mes;
        retorno+= "/";
        retorno+=ano;
        retorno+= " ";
        retorno+=hora;
        retorno+= ":";
        retorno+=minuto;
        return retorno;
    }
    
    public boolean isAfterToday(){
        Calendar c = Calendar.getInstance(Locale.getDefault());
        int Today = (c.get(Calendar.YEAR)* 10000) + ((c.get(Calendar.MONTH )+1) * 100) + (c.get(Calendar.DAY_OF_MONTH));
        int dataTmp = (ano * 10000) + (mes * 100) + (dia);
        if (dataTmp > Today) {
            return true;
            
            //PARAMOS AQUI O//
        }else if(Today == dataTmp ){
            //Comparar Horario
            if(hora > c.get(Calendar.HOUR_OF_DAY)){
                return true;
            }else if(hora == c.get(Calendar.HOUR_OF_DAY) ){
                // Comparar minutos
                if(minuto > c.get(Calendar.MINUTE)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

}
