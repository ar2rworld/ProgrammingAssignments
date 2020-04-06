package C0304distance;

import java.util.*;
public class AcmIeee
{
   public static void main(String[] args){
       Set<String> acm = new HashSet<String>();
       Set<String> ieee = new HashSet<String>();
       acm.add("Taylor");
       acm.add("Angie");
       acm.add("Christian");
       acm.add("Grayson");
       acm.add("Ken");
       
       ieee.add("Taylor");
       ieee.add("Tobias");
       ieee.add("Shane");
       ieee.add("Angie");
       ieee.add("Grayson");
       ieee.add("Christian");
       
       System.out.println("ACM had the following " + acm.size() + " programmers:\n" + acm);
       System.out.println("IEEE had the following " + ieee.size() + " programmers:\n" + ieee);
       
       Set<String> combined = new HashSet<String>();
       combined.addAll(acm);
       combined.addAll(ieee);
       
       
       
       System.out.println("Combined they had the following " + combined.size() + " programmers:\n" + combined);
       Set<String> diff = new HashSet<String>();
       diff.addAll(acm);
       diff.removeAll(ieee);
       
       System.out.println("ACM without IEEE had the following " + diff.size() + " programmers:\n" + diff);
       
       acm.retainAll(ieee);
       System.out.println("Intersection had the following " + acm.size() + " programmers:\n" + acm);
   }
    
}
