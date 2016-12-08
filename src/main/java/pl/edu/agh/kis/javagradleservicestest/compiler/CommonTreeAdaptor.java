package pl.edu.agh.kis.javagradleservicestest.compiler;

public class CommonTreeAdaptor implements TreeAdaptor {

	@Override
	public CommonTree nil() {
		return CommonTree.nil();
	}

	@Override
	public CommonTree becomeRoot(CommonTree oUT111_tree, CommonTree root_1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addChild(CommonTree root_1, Object tree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommonTree dupNode(CommonTree tree) {
		return (CommonTree) tree.dupNode();
	}

	@Override
	public CommonTree rulePostProcessing(CommonTree root_0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object create(CommonTree commonTree) {
		// TODO Auto-generated method stub
		return null;
	}

}
