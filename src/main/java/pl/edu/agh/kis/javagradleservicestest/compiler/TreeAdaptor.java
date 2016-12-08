package pl.edu.agh.kis.javagradleservicestest.compiler;

public interface TreeAdaptor {

	public CommonTree nil();

	public CommonTree becomeRoot(CommonTree oUT111_tree, CommonTree root_1);

	public void addChild(CommonTree root_1, Object tree);

	public CommonTree dupNode(CommonTree oUT111);

	public CommonTree rulePostProcessing(CommonTree root_0);

	public Object create(CommonTree commonTree);

}
