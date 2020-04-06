package C0304distance;

import java.util.*;
public class PerformanceTest
{
    static final int N = 50000;
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        
        Collection<Integer> list1 = new ArrayList<Integer>(list);
        Collection<Integer> list2 = new LinkedList<Integer>(list);
        Collection<Integer> list3 = new HashSet<Integer>(list);
       
        System.out.println("\nContains Test:");
        System.out.println("ArrayList contains test time: " + getContainsTime(list1));
        System.out.println("LinkedList contains test time: " + getContainsTime(list2));
        System.out.println("HashSet contains test time: " + getContainsTime(list3));
        System.out.println("\nRemove Test:");
        System.out.println("ArrayList remove test time: " + getRemoveTime(list1));
        System.out.println("LinkedList remove test time: " + getRemoveTime(list2));
        System.out.println("HashSet remove test time: " + getRemoveTime(list3));
    }
    

    
    public static long getContainsTime(Collection<Integer> c){
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < N; i++){
            c.contains((int)(Math.random() * 2 * N));
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    
    public static long getRemoveTime(Collection<Integer> c){
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < N; i++){
            c.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
    
    
}
