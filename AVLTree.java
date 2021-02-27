
public class AVLTree {
	
	private AVLTreeNode root;
	
	public AVLTree ()
	{
		root = null;
	}
	public void insert(int newElement)
	{
		root = insert_recursive(root, newElement);
	}
	public AVLTreeNode retrieve(int searchKey)
	{
		return retrieve_rec(root ,searchKey);
	}
	public void clear()
	{
		root = null;
	}// Clear tree
	public boolean isEmpty()
	{
		if(root == null)
			return true;
		
		return false;
	}
	public boolean isFull()
	{
		return false;
	} 
	public String toString()
	{
		return Inorder_rec(root);
	} // Output the tree structure in Inorder
	
	
	private AVLTreeNode insert_recursive(AVLTreeNode root,int newKey)
	{
		if(root == null)
		{
			AVLTreeNode new_node = new AVLTreeNode(newKey,0,null,null);
			return new_node;
		}
			
		if(newKey < (root.getKey())) //go left
			root.setLeft(insert_recursive(root.getLeft(),newKey));
		
		else if(newKey > (root.getKey())) //go right
			root.setRight(insert_recursive(root.getRight(),newKey));
		
		heightUpdate(root);
		
		
		int balance = getBalance(root);
		//left left
		if(balance > 1 && newKey < root.getLeft().getKey())
		{
			return rightRoatet(root);
		}
		//right right
		if(balance < -1 && newKey > root.getRight().getKey())
		{
			return leftRoatet(root);
		}
		//left right
		if(balance > 1 && newKey > root.getLeft().getKey())
		{
			root.setLeft(leftRoatet(root.getLeft()));
			return rightRoatet(root);
		}
		// right left
		if(balance < -1 && newKey < root.getRight().getKey())
		{
			root.setRight(rightRoatet(root.getRight()));
			return leftRoatet(root);
		}
		
		return root;
	}
	
	private int max(int a, int b) 
	{ 
		return (a > b) ? a : b; 
	}
	
	private void heightUpdate(AVLTreeNode root)
	{
		if(root.getLeft()== null && root.getRight() == null)
			root.setHeight(0);
		
		else if(root.getLeft()== null && root.getRight() != null)
			root.setHeight(root.getRight().getHeight()+1);
		
		else if(root.getLeft()!= null && root.getRight() == null)
			root.setHeight(root.getLeft().getHeight()+1);
		else
			root.setHeight(max(root.getLeft().getHeight(),root.getRight().getHeight()) +1);
		
	}
	
	private AVLTreeNode rightRoatet(AVLTreeNode k2)
	{
		AVLTreeNode k1 = k2.getLeft();
		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		heightUpdate(k2);
		heightUpdate(k1);
		
		return k1;
	}
	
	private AVLTreeNode leftRoatet(AVLTreeNode k2)
	{
		AVLTreeNode k1 = k2.getRight();
		k2.setRight(k1.getLeft());
		k1.setLeft(k2);
		heightUpdate(k2);
		heightUpdate(k1);
		
		return k1;
	}
	
	private int getBalance(AVLTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.getLeft() == null)
		{
			if(root.getRight() == null)
			{
				return 0;
			}
			return 0 - root.getRight().getHeight();
		}
		
		else if(root.getRight()== null)
		{
			return root.getLeft().getHeight();
		}
		
		return root.getLeft().getHeight() - root.getRight().getHeight();
	}
	
	
	private AVLTreeNode retrieve_rec(AVLTreeNode root ,int searchKey)
	{
		if(root == null)
		{
			return null;
		}
		if(root.getKey() == searchKey)
			return root;
		
		if(searchKey < (root.getKey())) //go left
			return retrieve_rec(root.getLeft(),searchKey);
		
		if(searchKey> (root.getKey())) //go right
			return retrieve_rec(root.getRight(),searchKey);
		
		return root;
	}
	
	private boolean isLeaf(AVLTreeNode tree)
	{
		if(tree == null)
		{
			return false;
		}
		if(tree.getLeft() == null && tree.getRight() == null)
			return true;
		
		return false;
	}
	
	private String Inorder_rec(AVLTreeNode root)
	{
		String str="";
		if(root == null)
		{
			return str;
		}
		if(isLeaf(root)) /*if is leaf return*/
			return " "+root.getKey()+" ";
		
		if(root.getLeft()!=null) 
			str+=Inorder_rec(root.getLeft()); /*make recursive on left side*/
		str+=(" "+root.getKey()+" ");
		if(root.getRight()!= null)
			str+=Inorder_rec(root.getRight()); /*make recursive on right side*/
		return str;
		
	}
	

}
