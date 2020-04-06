package C3003distanceClass;
public class StackTest {

	public static void main(String[] args) {
		WordStack ws = new WordStack();
		ws.push("Paris");
		ws.push("Vancouver");
		ws.push("Kelowna");
		
		System.out.println(ws);
		
		String last = ws.pop();
		System.out.println("Last was " + last);
		System.out.println(ws);
		
		MyStack<Double> ds = new MyStack<Double>();
		ds.push(3.14);
		ds.push(-5.5);
		ds.push(11.3);
		
		System.out.println(ds);

	}

}
