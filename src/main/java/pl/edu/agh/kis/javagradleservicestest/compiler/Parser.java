package pl.edu.agh.kis.javagradleservicestest.compiler;

import pl.edu.agh.kis.javagradleservicestest.exceptions.MismatchedTokenException;
import pl.edu.agh.kis.javagradleservicestest.exceptions.MissingTokenException;
import pl.edu.agh.kis.javagradleservicestest.exceptions.RecognitionException;
import pl.edu.agh.kis.javagradleservicestest.exceptions.UnwantedTokenException;

public class Parser {

	private static final int OUT = 100;
	private static final int VAR = 101;
	private static final int ID = 102;

	private static final BitSet FOLLOW_VAR_in_outStatement2355 = new BitSet(new long[] { 0x0000000000000004L });
	private static final BitSet FOLLOW_portName_in_outStatement2328 = null;
	private static final BitSet FOLLOW_OUT_in_outStatement2326 = null;
	private static final BitSet FOLLOW_variable_in_outStatement2359 = null;
	private static final BitSet FOLLOW_ID_in_portName678 = null;
	private static final BitSet FOLLOW_ID_in_variable2778 = null;

	private ModelCreator model;
	private TokenStream input;
	private TreeAdaptor adaptor = new CommonTreeAdaptor();
	private RecognitionState state = new RecognitionState();

	public Parser(TokenStream source, ModelCreator model) {
		this.model = model;
		this.input = source;
	}

	public static class ReturnValue {
		public Token start;
		public String name;
		public CodeInfo ci;
		public Object tree;

		public Object getTree() {
			return tree;
		}
	}

	public static class OutStatementReturn extends ReturnValue {
		Instruction pinstruction;
	}

	public static class PortNameReturn extends ReturnValue {

	}

	public static class VariableReturn extends ReturnValue {
		public String s;
	}

	public final OutStatementReturn outStatement(String label, CodeInfo ilabel) throws RecognitionException {
		OutStatementReturn retval = new OutStatementReturn();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _last = null;

		CommonTree OUT111 = null;
		CommonTree VAR113 = null;
		PortNameReturn portName112 = null;

		VariableReturn variable114 = null;

		CommonTree OUT111_tree = null;
		CommonTree VAR113_tree = null;

		String portName = null;
		CodeInfo iport = null;
		String varName = null;
		CodeInfo ivar = null;

		try {
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:733:3:
			// ( ^( OUT portName ^( VAR ( variable )? ) ) )
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:734:3:
			// ^( OUT portName ^( VAR ( variable )? ) )
			{
				root_0 = (CommonTree) adaptor.nil();

				_last = (CommonTree) input.LT(1);
				{
					CommonTree _save_last_1 = _last;
					CommonTree root_1 = (CommonTree) adaptor.nil();
					_last = (CommonTree) input.LT(1);
					OUT111 = (CommonTree) match(input, OUT, FOLLOW_OUT_in_outStatement2326);
					OUT111_tree = (CommonTree) adaptor.dupNode(OUT111);

					root_1 = (CommonTree) adaptor.becomeRoot(OUT111_tree, root_1);

					match(input, Token.DOWN, null);
					_last = (CommonTree) input.LT(1);
					pushFollow(FOLLOW_portName_in_outStatement2328);
					portName112 = portName();

					state._fsp--;

					adaptor.addChild(root_1, portName112.getTree());

					portName = (portName112 != null ? portName112.name : null);
					iport = (portName112 != null ? portName112.ci : null);

					_last = (CommonTree) input.LT(1);
					{
						CommonTree _save_last_2 = _last;
						CommonTree root_2 = (CommonTree) adaptor.nil();
						_last = (CommonTree) input.LT(1);
						VAR113 = (CommonTree) match(input, VAR, FOLLOW_VAR_in_outStatement2355);
						VAR113_tree = (CommonTree) adaptor.dupNode(VAR113);

						root_2 = (CommonTree) adaptor.becomeRoot(VAR113_tree, root_2);

						if (input.LA(1) == Token.DOWN) {
							match(input, Token.DOWN, null);
							// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:741:12:
							// ( variable )?
							int alt28 = 2;
							int LA28_0 = input.LA(1);

							if ((LA28_0 == ID)) {
								alt28 = 1;
							}
							switch (alt28) {
							case 1:
							// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:741:14:
							// variable
							{
								_last = (CommonTree) input.LT(1);
								pushFollow(FOLLOW_variable_in_outStatement2359);
								variable114 = variable();

								state._fsp--;

								adaptor.addChild(root_2, variable114.getTree());

								varName = (variable114 != null ? variable114.s : null);
								ivar = (variable114 != null ? variable114.ci : null);

							}
								break;

							}

							match(input, Token.UP, null);
						}
						adaptor.addChild(root_1, root_2);
						_last = _save_last_2;
					}

					match(input, Token.UP, null);
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
				}

				retval.pinstruction = model.createOutStmt(portName, varName, label, iport, ivar, ilabel);

			}

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	private void pushFollow(BitSet followPortnameInOutstatement2328) {
		// TODO Auto-generated method stub

	}

	public final PortNameReturn portName() throws RecognitionException {
		PortNameReturn retval = new PortNameReturn();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _last = null;

		CommonTree ID40 = null;

		CommonTree ID40_tree = null;

		try {
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:346:3:
			// ( ID )
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:347:3:
			// ID
			{
				root_0 = (CommonTree) adaptor.nil();

				_last = (CommonTree) input.LT(1);
				ID40 = (CommonTree) match(input, ID, FOLLOW_ID_in_portName678);
				ID40_tree = (CommonTree) adaptor.dupNode(ID40);

				adaptor.addChild(root_0, ID40_tree);

				retval.name = (ID40 != null ? ID40.getText() : null);
				retval.ci = createCodeInfo(ID40);

			}

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	public final VariableReturn variable() throws RecognitionException {
		VariableReturn retval = new VariableReturn();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _last = null;

		CommonTree ID131 = null;

		CommonTree ID131_tree = null;

		try {
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:843:3:
			// ( ID )
			// /home/mwypych/Dokumenty/praca/alvisgit/ALVISC/src/main/antlr/pl/edu/agh/alvisc/grammar/Alvis_TreeWalker.g:844:3:
			// ID
			{
				root_0 = (CommonTree) adaptor.nil();

				_last = (CommonTree) input.LT(1);
				ID131 = (CommonTree) match(input, ID, FOLLOW_ID_in_variable2778);
				ID131_tree = (CommonTree) adaptor.dupNode(ID131);

				adaptor.addChild(root_0, ID131_tree);

				retval.s = (ID131 != null ? ID131.getText() : null);
				retval.ci = createCodeInfo(ID131);

			}

			retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}

	public Object match(TokenStream input, int ttype, BitSet follow) throws RecognitionException {
		// System.out.println("match "+((TokenStream)input).LT(1));
		Object matchedSymbol = getCurrentInputSymbol(input);
		if (input.LA(1) == ttype) {
			input.consume();
			state.errorRecovery = false;
			state.failed = false;
			return matchedSymbol;
		}
		if (state.backtracking > 0) {
			state.failed = true;
			return matchedSymbol;
		}
		matchedSymbol = recoverFromMismatchedToken(input, ttype, follow);
		return matchedSymbol;
	}

	protected Object recoverFromMismatchedToken(TokenStream input, int ttype, BitSet follow)
			throws RecognitionException {
		RecognitionException e = null;
		// if next token is what we are looking for then "delete" this token
		if (mismatchIsUnwantedToken(input, ttype)) {
			e = new UnwantedTokenException(ttype, input);
			/*
			 * System.err.println("recoverFromMismatchedToken deleting "+
			 * ((TokenStream)input).LT(1)+ " since "+((TokenStream)input).LT(2)+
			 * " is what we want");
			 */
			input.consume(); // simply delete extra token
			reportError(e); // report after consuming so AW sees the token in
							// the exception
			// we want to return the token we're actually matching
			Object matchedSymbol = getCurrentInputSymbol(input);
			input.consume(); // move past ttype token as if all were ok
			return matchedSymbol;
		}
		// can't recover with single token deletion, try insertion
		if (mismatchIsMissingToken(input, follow)) {
			Object inserted = getMissingSymbol(input, e, ttype, follow);
			e = new MissingTokenException(ttype, input, inserted);
			reportError(e); // report after inserting so AW sees the token in
							// the exception
			return inserted;
		}
		// even that didn't work; must throw the exception
		e = new MismatchedTokenException(ttype, input);
		throw e;
	}

	protected CodeInfo createCodeInfo(CommonTree node) {
		return new CodeInfo((node != null ? node.getLine() : 0), (node != null ? node.getCharPositionInLine() : 0),
				(node != null ? node.getCharPositionInLine() : 0) + (node != null ? node.getText() : null).length());
	}

	public void reportError(RecognitionException e) {
		// if we've already reported an error and have not matched a token
		// yet successfully, don't report any errors.
		if (state.errorRecovery) {
			// System.err.print("[SPURIOUS] ");
			return;
		}
		state.errorRecovery = true;

		displayRecognitionError(e);
	}

	public void recover(TokenStream input, RecognitionException re) {
		if (state.lastErrorIndex == input.index()) {
			// uh oh, another error at same token index; must be a case
			// where LT(1) is in the recovery token set so nothing is
			// consumed; consume a single token so at least to prevent
			// an infinite loop; this is a failsafe.
			input.consume();
		}
		state.lastErrorIndex = input.index();
		BitSet followSet = new BitSet(new long[] { 0x0000000000000004L });
		consumeUntil(input, followSet);
	}

	protected void displayRecognitionError(RecognitionException e) {
		System.err.println(e.toString());
	}

	protected Object getCurrentInputSymbol(TokenStream input) {
		return input.LT(1);
	}

	protected boolean mismatchIsUnwantedToken(TokenStream input, int ttype) {
		return input.LA(2) == ttype;
	}

	protected boolean mismatchIsMissingToken(TokenStream input, BitSet follow) {
		if (follow == null) {
			// we have no information about the follow; we can only consume
			// a single token and hope for the best
			return false;
		}

		// BitSet cannot handle negative numbers like -1 (EOF) so I leave EOR
		// in follow set to indicate that the fall of the start symbol is
		// in the set (EOF can follow).
		if (follow.member(input.LA(1)) || follow.member(Token.EOR_TOKEN_TYPE)) {
			// System.out.println("LT(1)=="+((TokenStream)input).LT(1)+" is
			// consistent with what follows; inserting...");
			return true;
		}
		return false;
	}

	private Object getMissingSymbol(TokenStream input,
			  RecognitionException e,
			  int expectedTokenType,
			  BitSet follow) {
		String tokenText = "<missing TOKEN>";
		return adaptor.create(new CommonTree(expectedTokenType, tokenText));
	}

	public void consumeUntil(TokenStream input, BitSet set) {
		// System.out.println("consumeUntil("+set.toString(getTokenNames())+")");
		int ttype = input.LA(1);
		while (ttype != Token.EOF && !set.member(ttype)) {
			// System.out.println("consume during recover
			// LA(1)="+getTokenNames()[input.LA(1)]);
			input.consume();
			ttype = input.LA(1);
		}
	}
}
