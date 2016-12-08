package pl.edu.agh.kis.javagradleservicestest.compiler;

public class ModelCreator {

	public Instruction createOutStmt(String portName, String varName, String label, CodeInfo iport, CodeInfo ivar,
			CodeInfo ilabel) {
		
		Instruction out = new Instruction();

		out.portName = portName;

		out.varName = varName;

		return out;
		
	}

}
