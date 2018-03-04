package model;

import java.io.IOException;

import model.expr.Expr;
import model.expr.ExprParser;
import util.XLException;

public class CellValueFactory {
    
    static CellValue makeCellValue(String value, Sheet sheet){
        if(value.charAt(0) == '#'){
            return new Comment(value);
        }
        try{
            Expr expr = new ExprParser().build(value);
//            try {
                CellValue cv = new Expression(expr, sheet);
                return cv;
//            } catch (XLException e) {
//                return new Error("fr�n expression value saknas");
//            }
//
//            // NÅGOT ÄR FEL MED ERROR, CIRCULAR OSV
        } catch (IOException error) {
            return new Error("From Factory");

        }
    }

}
