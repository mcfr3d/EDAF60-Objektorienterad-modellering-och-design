package mainComputer;
import memoryHandle.*;

public interface Instructions{
	public void execute(Memory m, ProgramCounter p);
	public String toString();
}