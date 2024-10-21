package library_management;
import java.time.LocalDate;
import java.util.*;

public class user {
	int id;
	String name;
	String password;
	char gender;
	int age;

	
	user(int id,String n,String p,char g,int age){
		
		this.id=id;
		this.name=n;
		this.password=p;
		this.gender=g;
		this.age=age;
	
		
	}
	
	public String toString() {
		
		System.out.println("User Id   : "+this.id);
		System.out.println("Name      : "+this.name);
		System.out.println("Password  : "+this.password);
		System.out.println("Gender    : "+this.gender);
		System.out.println("Age       : "+this.age);
	
		return "";
	}
   
}
