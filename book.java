package library_management;
import java.util.*;

public class book {

	int BookId;
	String Author;
	String Title;
	String Description;
	Date P_date;
	int Edition;
	double price;
	
	book(int bookid,String author,String title,String desc,Date date,int edition,double price){
		
		this.BookId=bookid;
		this.Author=author;
		this.Title=title;
		this.Description=desc;
		this.P_date=date;
		this.Edition=edition;
		this.price=price;
	}
	
	public String toString() {
	
		System.out.println("Book ID       : "+this.BookId);
		System.out.println("Auther        : "+this.Author);
		System.out.println("Title         : "+this.Title);
		System.out.println("Description   : "+this.Description);
		System.out.println("publised Date : "+this.P_date);
		System.out.println("Edition       : "+this.Edition);
		System.out.println("Price         : "+this.price);
	    
		return "";
	}
}
