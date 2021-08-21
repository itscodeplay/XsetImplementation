import java.util.*;

public class Node {
	private int key;
	private Node root;
	private Node left, right;
	
	/* Conctructor to create new Node */
	public Node(int data) {
		key = data;
		left = right = null;
	}
	
	public Node() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	void deleteKey(int key) {
		root = deleteRec(root, key);
	}
	
	// Method to delete element from the set
	public Node deleteRec(Node root, int key) {
		if(root == null) 
			return root;
		if(key < root.key)
			root.left = deleteRec(root.left, key);
		else if(key > root.key)
			root.right = deleteRec(root.right, key);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			root.key = minVal(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}
	
	int minVal(Node root) {
		int mini = root.key;
		while(root.left != null) {
			mini = root.left.key;
			root = root.left;
		}
		return mini;
	}
	
	// Method to insert data into the set
	public void insert(int data) {
		if(search(data))
			System.out.println("Data already present in set");
		else
			root = addElement(root, data);
	}
	
	// Insertion Helper
	public Node addElement(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		if(data < root.key)
			root.left = addElement(root.left, data);
		else if(data > root.key)
			root.right = addElement(root.right, data);
		return root;
	}
	
	// Search method 
	public boolean search(int data) {
		return searchUtil(root, data);
	}
	
	public boolean searchUtil(Node root, int key)
    {
        while (root != null) {
            if (key > root.key)
                root = root.right;

            else if (key < root.key)
                root = root.left;
            else
                return true; 
        }
        return false;
    }
	
	void inOrder() {
		inOrderRec(root);
	}
	
	void inOrderRec(Node root) {
		if(root == null)
			return;
		inOrderRec(root.left);
		System.out.print(root.key+" ");
		inOrderRec(root.right);
	}
	
	void traverse(Node root, ArrayList<Integer> list) {
		if(root == null)
			return;
		traverse(root.left, list);
		list.add(root.key);
		traverse(root.right, list);
	}
	
	// Mehtod to return random number form the set
	public int returnRandom() {
		ArrayList<Integer> list = new ArrayList<>();
		traverse(root, list);
		int len = list.size();
		int min = 0, max = len-1;
		int randomIndex =  (int) ((Math.random() * (max - min)) + min);
		if(list.isEmpty())
			System.out.println("Set is empty");
		return list.get(randomIndex);	
	}
}
