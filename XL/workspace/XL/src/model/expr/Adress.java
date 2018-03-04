package model.expr;

public class Adress extends Variable{
    private String name;
    
    public Adress(String name){
        super(name);
        this.name = name;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Adress){
            return ((Adress) obj).name.equals(this.name);
        }
        return false;
    }
    
}