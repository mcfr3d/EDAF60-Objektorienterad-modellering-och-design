package mainComputer;
import memoryHandle.*;

public abstract class BinOp implements Instructions{

	MemorySpace leftExpr, rightExpr;
	Address address;

	public BinOp(MemorySpace m1, MemorySpace m2, Address a){
		leftExpr = m1;
		rightExpr = m2;
		address = a;
	}
	public void execute(Memory memory, ProgramCounter count){
        operation(address.getWord(memory), leftExpr.getWord(memory), rightExpr.getWord(memory));        
        count.setIndex(count.getIndex()+1);    
    }
    public abstract void operation(Word addressWord, Word leftExpr, Word rightExpr);

	public String toString(){
		return leftExpr.toString() + rightExpr.toString() + address.toString();
	}
}
