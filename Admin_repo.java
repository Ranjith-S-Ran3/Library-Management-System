package library_management;
import java.util.*;
import java.util.Map.Entry;

public class Admin_repo {
	
	private static String username="admin";
	private static String password="admin";
	
	public void Admin() {
		boolean check=true;
		Scanner n=new Scanner(System.in);

		while(check) {
		   
			System.out.println("1.Add a new book\t2.Remove an existing book\n3.View list of books\t4.Add a new user\n5.Remove an existing user\t6.View list of users\n7.Manage Stocks\t\t8.Exit");
		    int option=n.nextInt();
		    
			switch(option) {
			
			case 1:{
				book_repo b=new book_repo();
				b.addbook();
				break;
			}
			case 2:{
				book_repo b=new book_repo();
				b.removebook();
				break;
			}
			case 3:{
				book_repo b=new book_repo();
		        b.viewbooklist();
				break;
			}
			case 4:{
				user_repo users=new user_repo();
				users.adduser();
				break;
			}
			case 5:{
				user_repo users=new user_repo();
				users.removeuser();
				break;
			}
			case 6:{
				viewuserlist();
				break;
			}
			case 7:{
				stock_repo st=new stock_repo();
				st.stockrepo();
				break;
			}
			default:{
				check=false;
				break;
			}
			
			}	
	  }
	}
	private void viewuserlist() {
		user_repo users=new user_repo();
		
		for(user us:users.userrepo.values()) {
			System.out.println(us);
		}
	}
	
	public boolean check(String name,String password) {
		
		if(!this.username.equals(name) || !this.password.equals(password)) {
			System.out.println("Invalid UserName/Password");
			return false;
		}
		
	return true;
	}


}