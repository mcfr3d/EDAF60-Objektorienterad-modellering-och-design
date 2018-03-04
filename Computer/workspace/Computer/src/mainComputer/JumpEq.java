package mainComputer;
import memoryHandle.*;
public class JumpEq implements Instructions {

	private int index;
	private MemorySpace m1, m2;
	
	public JumpEq(int index, MemorySpace m1, MemorySpace m2){
		this.m1 = m1;
		this.index = index;
		this.m2 = m2;
	}
	@Override
	public void execute(Memory m, ProgramCounter p) {
		if(m1.getWord(m).equals(m2.getWord(m))){
			p.setIndex(index);
		}
		else{
			p.setIndex(p.getIndex()+1);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "JEQ " + index + m1 + m2;
	}

}
