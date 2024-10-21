package library_management;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class takebookrepo {
   static HashMap<Integer,ArrayList<takebook>>takerepo=new HashMap<>();
   
   
   public void addtakerepo(int id,int uid,String name,LocalDate takedate) {   
	  
	   if(takerepo.containsKey(uid)){
		 
		   takebook b=new takebook(id,uid,name,takedate);
		   takerepo.get(uid).add(b);
		 
	   }else {
		   
		   takerepo.put(uid,new ArrayList<takebook>());
		   takebook b=new takebook(id,uid,name,takedate);
		   takerepo.get(uid).add(b);
		  
	   }  
   }
   
   public void viewtakebook() {
	
	   for(Entry<Integer, ArrayList<takebook>> tbs:takerepo.entrySet()) {
		   System.out.println("User Id : "+tbs.getKey());
		   
		   for(takebook tb:tbs.getValue()) {
			  System.out.println(tb); 
		   }
		   
	   }
   }
   
}
