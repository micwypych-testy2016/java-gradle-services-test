package pl.edu.agh.kis.javagradleservicestest.compiler;

public class RecognitionState {

	public int _fsp = -1;
	public boolean errorRecovery = false;
	public boolean failed = false;
	public int backtracking = 0;
	public int lastErrorIndex = -1;

}
