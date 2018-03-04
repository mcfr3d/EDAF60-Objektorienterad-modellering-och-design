package mainComputer;
import memoryHandle.*;

public class Factorial extends Program{
	public Factorial(){
		super();
		Address n = new Address(0), fac = new Address(1);
		add(new Copy(new LongWord(5), n));
		add(new Copy(new LongWord(1), fac));
		add(new JumpEq(6, n, new LongWord(1)));
		add(new Mul(fac, n,fac));
		add(new Add(n, new LongWord(-1), n));
		add(new Jump(2));
		add(new Print(fac));
		add(new Halt());
	}
	public void execute(Memory memory, ProgramCounter counter){
		while(counter.getIndex() != -1){
			this.get(counter.getIndex()).execute(memory, counter);
		}
	}
}