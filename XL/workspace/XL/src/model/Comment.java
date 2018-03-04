package model;

public class Comment implements CellValue{
    private String value;
    
    Comment  (String value){
        this.value = value;
    }

    @Override
    public double value() {
        return 0;
    }
    
    public String toString(){
        return value;
    }
}
