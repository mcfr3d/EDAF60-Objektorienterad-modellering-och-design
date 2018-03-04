package mainComputer;
import memoryHandle.*;
public class Halt implements Instructions{

	@Override
	public void execute(Memory m, ProgramCounter p) {
		p.setIndex(-1);
	}


	public String toString(){
		return "HLT";
	}

}
