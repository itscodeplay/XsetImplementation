import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class Testing {
	
	@Test
	public void testDeleteKey() {
		Node tree = new Node();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		tree.deleteKey(70);
		tree.inOrder();
		// assertEquals(treeSize(), 6)
	}
	
	// Negative Scenario: tree.deleteKey(5) is not present in the set, will return null
	
	@Test
	public void insert() {
		Node tree = new Node();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		//assertEquals(treeSize(), 3)
	}
	
	//1.  Negative Scenario: tree.insert("Hello") will not add any element
	//2.  Negative Scenario: tree.insert(50) will not add any element due to duplicate value
	
	@Test
	public void searchUtil() {
		Node tree = new Node();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		
		boolean res = tree.search(100);
		assertFalse(res);
		
		res = tree.search(50);
		assertTrue(res);
	}
	
	@Test
	public void returnRandom() {
		Node tree = new Node();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		
		int res = tree.returnRandom();
		boolean response = tree.search(res);
		assertTrue(response);
	}
	
}
