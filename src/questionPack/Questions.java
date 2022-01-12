package questionPack;

import java.util.LinkedList;
import java.util.Queue;

public class Questions {

	
	 
	 private final int LIMIT = 200;
	 
	 static int a = 130;
	 static int b = 0;
	 static int c;
	 
	 
	 public static void main(String[] args) {
		 
		 try {
			c = getRes(a, b); 
		
		} catch (MyException e) {
			System.out.println(e.getMessage() + e.getNumber());
			b = 1;
			try {
				c = getRes(a, b);
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 
		 System.out.println(c);
	 
//	 Queue<Integer> q = new LinkedList<>();
//	 
//	 Questions quest = new Questions();
//	 
//	 for (int i = 0; i < 200; i++) { q.add(1); }
//	 
//	 if(q.size() == quest.LIMIT) { System.out.println("TRUE"); }else {
//	 System.out.println("FALSE"); }
//	 
//	 if(a == b) { System.out.println("TRUE"); }else {
//	 System.out.println("FALSE"); }
	 
	 }
	 static int getRes(int a, int b) throws MyException {
		 
		 if(b == 0) {
			 throw new MyException("Try to divide by zero. Exception number ", 1);
		 }
		 
		 int res = a / b; 
		 return res;
	 }
}
	 
	 
	 

