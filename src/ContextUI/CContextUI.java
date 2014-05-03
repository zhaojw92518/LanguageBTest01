package ContextUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class CContextUI extends JPanel{
	private JTree tree = null;
	private DefaultMutableTreeNode top = null;
	private JScrollPane tree_view = null;
	
	public CContextUI(){
		super();
	}
	
	public void update(LinkedList<DefaultMutableTreeNode> in_list){
		this.removeAll();
		this.setLayout(new GridLayout(1,1));
		top = new DefaultMutableTreeNode("Context");
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		//Listen for when the selection changes.
		//tree.addTreeSelectionListener(this);
		
		tree_view = new JScrollPane(tree);
		//Dimension min_size = new Dimension(600, 450);
		
		//tree_view.setMinimumSize(min_size);
		
		this.add(tree_view);
		for(DefaultMutableTreeNode cur_node: in_list){
			top.add(cur_node);
		}
		this.expandAllNode(tree, new TreePath(top), true);
		this.validate();
		this.repaint();
	}
	
	private void expandAllNode(JTree tree, TreePath parent, boolean expand) {
	    // Traverse children
	    TreeNode node = (TreeNode) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	        for (Enumeration<?> e = node.children(); e.hasMoreElements();) {
	            TreeNode n = (TreeNode) e.nextElement();
	            TreePath path = parent.pathByAddingChild(n);
	            expandAllNode(tree, path, expand);
	        }
	    }
	 
	    if (expand) {
	        tree.expandPath(parent);
	    } else {
	        tree.collapsePath(parent);
	    }
	}
}
