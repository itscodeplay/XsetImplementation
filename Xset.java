import java.util.Scanner;

public class Xset extends Node{
	public static void main(String[] args) {
		Node tree = new Node();
		System.out.println("--------Choose a Xset operation(Q/q to quit)-------");
		Scanner in = new Scanner(System.in);
		String quit = "Q";
		do {
			System.out.println("Press 1 to insert");
			System.out.println("Press 2 to remove element");
			System.out.println("Press 3 view set elements");
			System.out.println("Press 4 to search an element");
			System.out.println("Press 5 to get random element");
			
			String input = in.nextLine();
			try {
				int choice = Integer.valueOf(input);
				int value;
				switch(choice) {
				case 1:
					System.out.print("Enter element: ");
					String ip = in.nextLine();
					try {
						int element = Integer.valueOf(ip);
						tree.insert(element);
					}catch(NumberFormatException e) {
						System.out.println("Enter valid integer");
					}
					
					break;
				case 2:
					System.out.print("Enter value to be deleted: ");
					value = in.nextInt();
					tree.deleteKey(value);
					break;
				case 3:
					System.out.print("Set Elements: ");
					tree.inOrder();
					System.out.println();
					break;
					
				case 4:
					System.out.print("Enter value to be searched: ");
					value = in.nextInt();
					if(tree.search(value))
						System.out.println("Value exists");
					else
						System.out.println("Value not found");
					break;
				case 5: 
					System.out.println("The random element has value: " +tree.returnRandom());
					break;
				default:
					System.out.println("No valid selection made");
			}
			}catch(NumberFormatException e) {
				System.out.println("Enter valid integer to proceed");
			}
					
		}while(quit.equalsIgnoreCase("Q"));
	}
		
}
