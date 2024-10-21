package library_management;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class stock_repo {
 
	static HashMap<Integer,stock>stockrepo=new HashMap<>();
	
	public void stockrepo() {
		boolean check=true;
		Scanner n=new Scanner(System.in);

		while(check) {
		   
			System.out.println("1.Add a stock\n2.Remove an stock\n3.View stocklist\n4.Exit");
		    int option=n.nextInt();
		    
			switch(option) {
			
			case 1:{
				addstock();
				break;
			}
			case 2:{
				removestock();
				break;
			}
			case 3:{
				viewstocks();
				break;
			}
			default:{
				check=false;
				break;
			}
			
			}
		}
	}
	
	public void addstock() {
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a book id :");
		int id=n.nextInt();
		System.out.println("Enter a add cnt :");
		int cnt=n.nextInt();
		
		stockrepo.put(id, new stock(id,cnt));
		System.out.println("Add a Stock ");
	}
	
	public void removestock() {
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a book id :");
		int id=n.nextInt();
		
		if(!stockrepo.containsKey(id)) {
			System.out.println("The stock is Empty ");
		}else {
		   stock st=stockrepo.get(id);
		   st.bookcnt-=1;
		   stockrepo.put(id, st);
			System.out.println("Remove the Stock is Successfull");
		}
	}

	public void viewstocks() {
		
		for(Entry<Integer, stock>  st:stockrepo.entrySet()) {
			System.out.println("Book ID : "+st.getKey());
			System.out.println("Book cnts"+st.getValue().bookcnt);
		}
	}
	
}
