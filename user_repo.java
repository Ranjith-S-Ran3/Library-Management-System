package library_management;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class user_repo {
  
	static HashMap<Integer,user>userrepo=new HashMap<>();
	static int cur_user,cur_cnt=0;
	
	public void Member() {
		boolean check=true;
		Scanner n=new Scanner(System.in);
		
		while(check) {
		   
			System.out.println("1.Search for a book\n2.take book\n3.Return a book\n4.viewbooks\n5.view take books\n6.Exit");
		    int option=n.nextInt();
		    
			switch(option) {
			
			case 1:{
				searchbook();
				break;
			}
			case 2:{
				takebook();
				break;
			}
			case 3:{
				returnbook();
				break;
			}
			case 4:{
				book_repo book=new book_repo();
				book.viewbooklist();
				break;
			}
			case 5:{
				takebookrepo takeb=new takebookrepo();
				takeb.viewtakebook();
				break;
			}
			default:{
				check=false;
				break;
			}
			
			}	
	  }
	}
    
	public boolean checkdate() {
		takebookrepo take=new takebookrepo();
	       LocalDate ldate=LocalDate.now();
	       
	       for(Entry<Integer, ArrayList<takebook>> tbs:take.takerepo.entrySet()) {
			   
	    		   if(tbs.getKey()==cur_user) {
	    			
	    			 for(takebook tb:tbs.getValue()){
	    			  
	    			   int date=tb.takedate.getDayOfMonth();
	    			   int month=tb.takedate.getMonthValue();
	    			   int year=tb.takedate.getYear();
	    			   
	    			   LocalDate afterdate=LocalDate.of(year,month,date).plusMonths(1);
	    			   int value=ldate.compareTo(afterdate);
	    			   
	    	    	   System.out.println(ldate+"<<<"+afterdate+"<<<<"+value);
	    	    	   
	    	    	   if(0<value && tb.returndate==null) {
	    	    		   System.out.println("you have already longdays used books");
	    	    		   return false;
	    	    	   }
	    			      
	    			 }     
	    		   }  
	    	   }
		return true;
	  }
	
	private boolean checkmax() {
		 
		if(5>cur_cnt) {
			return true;
		}
		System.out.println("Maximum limit crossed");
	return false;	
	
	}
	
	public void returnbook() {
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a  Book Id :");
		int id=n.nextInt();
		
		stock_repo strep=new stock_repo();
		stock st=strep.stockrepo.get(id);
		st.bookcnt+=1;
		
		takebookrepo take=new takebookrepo();
		
		  for(takebook tbs:take.takerepo.get(cur_user)) {
			  
			  if(tbs.bookid==id && tbs.returndate==null) {
				 LocalDate date=LocalDate.now(); 
				 tbs.returndate=date;
				 System.out.println("SuccessFull Return The Book");
				 return;
			  }
		  }
		
	}
	
	public void searchbook() {
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a  Book Title :");
		String name=n.next();
		
		book_repo book=new book_repo();
		book.searchbook(name);	
	}
	
	public void takebook() {
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a  Book Id :");
		int id=n.nextInt();
		
		stock_repo strep=new stock_repo();
		book_repo book=new book_repo();
		
		if(0>strep.stockrepo.get(id).bookcnt) {
			System.out.println(book.bookrepo.get(id).Title+" The Book is Not Available...");
			return;
		}
		
		if(!checkmax()) {
			return;
		}
	
		if(!checkdate()) {
			return;
		}

		cur_cnt+=1;
		
		stock st=strep.stockrepo.get(id);
		st.bookcnt-=1;
		strep.stockrepo.put(id, st);
		
		System.out.println("Enter a get book date :");
		int date=n.nextInt();
		System.out.println("Enter a  month :");
		int  month=n.nextInt();
		System.out.println("Enter a  year :");
		int year=n.nextInt();
	
		LocalDate ldate=LocalDate.of(year,month,date);
		
		takebookrepo take=new takebookrepo();
		take.addtakerepo(id,cur_user, book.bookrepo.get(id).Title, ldate);
		System.out.println("You Have Take a Book Successfull");
		
	}
	
    public void adduser() {
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a  Name :");
		String name=n.next();
		System.out.println("Enter a password :");
		String password=n.next();
		System.out.println("Enter a Gender F/M :");
		char gender=n.next().charAt(0);
		System.out.println("Enter a Age :");
		int age=n.nextInt();
		
		Random o=new Random();
		int id=o.nextInt();
		
		user a=new user(id,name,password,gender,age);
		
		userrepo.put(id,a);
		System.out.println("Add a New User");
	}
	
	
	public void removeuser() {
		
		Scanner n=new Scanner(System.in);
		System.out.println("Enter a  User Id :");
		int id=n.nextInt();
		
		if(userrepo.containsKey(id)) {
		   userrepo.remove(id);
		   System.out.println("Remove The User..");
		}else{
			System.out.println("Not Find User");
		}
		
	}
   
   private boolean check(int id) {
		
		if(!userrepo.containsKey(id)){
		
			return false;
		}
		
	return true;
   }
   public boolean checkuser(int id) {
	   return check(id);
   }
   
	
}
