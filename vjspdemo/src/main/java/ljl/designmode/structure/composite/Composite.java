package ljl.designmode.structure.composite;

import javax.xml.bind.Element;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Title: Composite
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/2/19 13:46
 */
class TreeNode{
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> childrens= new Vector<TreeNode>();

	public TreeNode(String name ){
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public Enumeration<TreeNode> getChildrens() {
		return childrens.elements();
	}
	public void add(TreeNode treeNode){
		childrens.add(treeNode);
	}
	public void remove(TreeNode treeNode){
		childrens.remove(treeNode);
	}

}
class Tree{
	public TreeNode root;
	public Tree(String name){
		root = new TreeNode(name);
	}
}
public class Composite {

	public static void main(String[] args) {
		Tree tree = new Tree("root");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");

		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished!");
	}
}
