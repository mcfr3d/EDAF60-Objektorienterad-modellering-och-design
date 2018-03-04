package mainComputer;
import memoryHandle.*;

public class Mul extends BinOp implements Instructions{
	
	public Mul(MemorySpace m1, MemorySpace m2, Address a){
		super(m1, m2, a);
	}
    public void operation(Word addressWord, Word leftExpr, Word rightExpr){
        addressWord.mul(leftExpr, rightExpr);
	}
	public String toString(){
		return "MUL " + super.toString();
	}
}
