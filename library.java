package library_management;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class library {
	
	public static void main(String[] args) {
	
		boolean check=true;
		Scanner n=new Scanner(System.in);
	  	
		while(check) {
		   
			System.out.println("1.Log As Admin\n2.Log AS Members\n3.Exit");
		    int option=n.nextInt();
		    
			switch(option) {
			
			case 1:{
				
				System.out.println("Enter a  UserName :");
				String name=n.next();
				System.out.println("Enter a  password :");
				String password=n.next();
				
				Admin_repo ad=new Admin_repo();
				
				if(ad.check(name, password)) {
					ad.Admin();
				}else {
					System.out.println("Invalid UserName/Password...");
				}
				break;
			}
			case 2:{
				System.out.println("Enter a  Id :");
				int id=n.nextInt();
				user_repo m=new user_repo();
				
				if(m.checkuser(id)) {
				   m.cur_user=id;
				   m.Member();
				}else {
					System.out.println("Invalid ID...");
				}
				break;
			}
			case 3:{
				check=false;
				break;
			}
			default:{
				check=false;
				break;
			}
			
			}
			user_repo.cur_cnt=0;
	  }  
       
   }
}
