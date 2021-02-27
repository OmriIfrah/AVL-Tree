import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class TestAVLTree 
{
	public static void main(String[] args) throws Exception {


		AVLTree tree = new AVLTree();

		// Initialize reader and tokenizer for the input stream
		// for reading 'tokens' (namely point values) input from the keyboard.
		InputStreamReader reader = new InputStreamReader(System.in);
		StreamTokenizer tokens = new StreamTokenizer(reader);

		System.out.print("Enter commands : ");
		while ((tokens.nextToken()) == StreamTokenizer.TT_WORD){

			switch(tokens.sval)
			{
			case "add":
				tokens.nextToken();
				int n = (int)tokens.nval; 
				tree.insert(n);
				break;


			case "find":
				tokens.nextToken();
				int num = (int)tokens.nval; 
				if(tree.retrieve(num) != null)
					System.out.println("The key: " + num + " is found");
				else
					System.out.println("The key: "+ num +" is Not found");
				break;

			case "K":
				System.out.println(tree.toString());
				break;

			case "F":
				System.out.println(tree.isFull()? "the tree is full":"the tree is NOT full");
				break;

			case "E":
				System.out.println(tree.isEmpty()? "the tree is empty":"the tree is NOT empty");
				break;

			case "C":
				tree.clear();
				break;


			case "Q":

				return;

			default:
				return;

			}


		}

	}


}



