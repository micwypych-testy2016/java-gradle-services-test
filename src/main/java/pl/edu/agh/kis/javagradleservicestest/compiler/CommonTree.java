package pl.edu.agh.kis.javagradleservicestest.compiler;

public class CommonTree implements Token {
	
	private int tokenType;
	private String text;

	public CommonTree(int tokenType, String tokenText) {
		this.tokenType = tokenType;
		this.text = tokenText;
	}

	public int getLine() {
		return 0;
	}

	public int getCharPositionInLine() {
		return 0;
	}

	@Override
	public Token dupNode() {
		return new CommonTree(tokenType,text);
	}

	@Override
	public String getText() {
		return text;
	}

	public static CommonTree nil() {
		return new CommonTree(Token.EOR_TOKEN_TYPE, null);
	}

}
