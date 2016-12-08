package pl.edu.agh.kis.javagradleservicestest.compiler;

public interface TokenStream {

	int LA(int k);
	
	Token LT(int k);
	
	void consume();

	int index();
}
