package mainComputer;
import memoryHandle.*;

public class Add extends BinOp implements Instructions{

	public Add(MemorySpace m1, MemorySpace m2, Address a){
		super(m1, m2, a);
	}
	public void operation(Word addressWord, Word leftExpr, Word rightExpr){
        addressWord.add(leftExpr, rightExpr);
	}
	public String toString(){
		return "ADD " + super.toString();
	}
}
