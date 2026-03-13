package br.ifmg.produto1_2026.service.exception;

public class DataBaseError extends RuntimeException{
    public DataBaseError(){
    }
    public DataBaseError(String message){
        super(message);
    }
}
