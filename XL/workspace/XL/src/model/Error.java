package model;

import util.XLException;

public class Error implements CellValue{
    String message;
    public Error(String message){
        this.message = message;
    }
    @Override
    public double value() throws XLException{
        throw new XLException(message);
    }
    
    public String toString(){
        return message;
    }

}
