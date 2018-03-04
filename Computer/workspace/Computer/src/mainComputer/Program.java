package mainComputer;
import memoryHandle.*;
import java.util.*;

public abstract class Program extends ArrayList<Instructions> implements Instructions{

	private ProgramCounter counter;
	
	public Program() {
		counter = new ProgramCounter();
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("");
		int index = 0;
		for(Instructions i : this){
			sb.append("\n" + index + " ");
			sb.append(i.toString());
			index++;
		}
	return sb.toString();		
}

	public void setUp(Memory memory) {
		this.execute(memory, counter);
	}
}