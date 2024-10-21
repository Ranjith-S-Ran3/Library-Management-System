package library_management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class book_repo {
   
	static HashMap<Integer,book>bookrepo=new HashMap<>();
	
	
	public void searchbook(String name) {
		int cnt=-1;
		for(book b:bookrepo.values()) {
			
			if(name.equals(b.Title) && 0<stock_repo.stockrepo.get(b.BookId).bookcnt) {
				System.out.println(b.Title+ " is Available\nThe Book Id is : "+b.BookId);
				cnt=1;
				break;
			}
		}
		
		if(cnt==-1)System.out.println(name+ " is NOt Available");
	}
	
	 public void addbook() {
			
			Scanner n=new Scanner(System.in);
			System.out.println("Enter a  Book Title :");
			String title=n.next();
			System.out.println("Enter a Auther  Name :");
			String auther=n.next();
			System.out.println("Enter a Description :");
			String desc=n.next();
			System.out.println("Enter a Publised date :");
			String p_date=n.next();
			System.out.println("Enter a Edition :");
			int edi=n.nextInt();
			System.out.println("Enter a price :");
			double price=n.nextDouble();
		
			
			Random o=new Random();
			int id=o.nextInt();
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			Date date=null;
			try {
				date = sdf.parse(p_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			book b=new book(id,auther,title,desc,date,edi,price);
			
			bookrepo.put(id,b);
			System.out.println("Add a New Book Successfull...");
		}
		
		
		public void removebook() {
			
			Scanner n=new Scanner(System.in);
			System.out.println("Enter a  User Id :");
			int id=n.nextInt();
			
			if(!bookrepo.containsKey(id)) {
				System.out.println("the book is not Contains");
				return;
			}
			
			bookrepo.remove(id);
			System.out.println("Remove The Book Successfull");
		}
		
		public void viewbooklist() {
			
			for(book ad:bookrepo.values()) {
				System.out.println(ad);
			}
		}

}