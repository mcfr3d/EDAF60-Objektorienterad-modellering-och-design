package model;

import model.expr.Expr;

public class Expression implements CellValue{
    
    private Expr expr;
    private Sheet sheet;
    
    Expression  (Expr expr, Sheet sheet){
        this.expr = expr;
        this.sheet = sheet;
    }

    @Override
    public double value() {
        return expr.value(sheet);
    }
    
    public String toString(){
        return expr.toString();
    }
}
