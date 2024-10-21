package library_management;

import java.time.LocalDate;

public class takebook {
	
	int bookid;
	int userid;
    String name;
    LocalDate takedate;
    LocalDate returndate;    
	
    takebook(int id,int uid,String name, LocalDate takedate){
 
    	this.bookid=id;
    	this.userid=uid;
    	this.name=name;
    	this.takedate=takedate;
    	this.returndate=null;
      
    }
    
    public String toString() {
    	
    	System.out.println(bookid);
    	System.out.println(userid);
    	System.out.println(name);
    	System.out.println(takedate);
    	System.out.println(returndate);
    	
    	
    	return "";
    }

}
