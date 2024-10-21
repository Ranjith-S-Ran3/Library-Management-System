package library_management;

public class stock {

	int bookid;
	int bookcnt;
	
	stock(int id,int cnt){
		this.bookid=id;
		this.bookcnt=cnt;
	}
	
	public String toString() {
		
		System.out.println("book stock cnt : "+this.bookcnt);
	
		return "";
	}
}
