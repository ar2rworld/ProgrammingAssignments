package C1603distanceClass;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,4,61,63,3,2,34,64,32,75,7,5,4,3,46,4,3,99};
		arr = rand1Darray(1000);
		long s = System.currentTimeMillis();
		bubble(arr);
		long f = System.currentTimeMillis();
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nmilliseconds: " + (f-s));
	}
	public static int[] rand1Darray(int n) {
		int[] out = new int[n];
		for(int i =0; i<n;i++) {
			out[i] =(int)( Math.random()*100);
		}
		return out;
	}
	public static void bubble(int[] arr) {
		for(int i=0; i<arr.length; i++) { // n work
			for(int j=0; j<arr.length-1; j++) { // n -1 work
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

}
