package pl.edu.agh.kis.javagradleservicestest.compiler;

public interface Token {

	int DOWN = 1;
	int UP = 2;
	int EOR_TOKEN_TYPE = -1;
	int EOF = 0;

	public Token dupNode();
	
	public String getText();
}
