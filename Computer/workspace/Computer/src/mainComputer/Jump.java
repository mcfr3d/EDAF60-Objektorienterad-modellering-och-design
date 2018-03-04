package mainComputer;
import memoryHandle.*;

public class Jump implements Instructions{

	private int index;
	
	public Jump(int index){
		this.index = index;
	}
	@Override
	public void execute(Memory m, ProgramCounter p) {
		p.setIndex(index);
	}

	@Override
	public String toString(){
		return "JMP " + index;
	}

}
