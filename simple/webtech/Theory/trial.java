package webtech.Theory;
import java.util.*;

interface printer{
    void print(String s);
}

public class trial {
    public static void main(String[] args) {
        int [] ar = new int[4];
        ar[0] = 1;
        System.out.println(ar);
        
        // remove is by index
        List<Integer> ls = Arrays.asList(2,3,5,2,3);
        Integer arr[] = ls.toArray( new Integer[0] );
        System.out.println(ls  + " " + arr[0] );
    
        ls.set(0, 43);
        System.out.println(ls.toArray());
        
        greet( (m)-> System.out.println(m) );
        ls.forEach( m -> System.out.println(m)  );
        ls.sort( (a,b) -> (a-b) );
        
        System.out.println(ls);
        

        Map<Integer , Integer > mp = new TreeMap<>();
        mp.put(1, 2 ); mp.put(43, 42);
        System.out.println(mp);
        
        for( var v : mp.entrySet() ) System.out.println(v);

        // File f = new File("/home/trial.txt" );

        StringBuilder sb = new StringBuilder();
        sb.append("Manoj");
        sb.setCharAt(1, 'A');
        System.out.println(sb);

        // this is only single ended
        PriorityQueue <Integer>qu = new PriorityQueue<>();
        qu.add(1); qu.add(35); qu.add(20);
        System.out.println( qu.poll() + " " + qu.poll() );

        // remove is by index but same in queue interface is removed by value
        // there is add first and add last and similarly for remove
        // ordinary poll removes first
        LinkedList<Integer> q = new LinkedList<>();
        q.add(43) ;q.add(124); q.add(2); q.add(24);
        System.out.println(q);
        q.remove(3);
        System.out.println(q + " " + q.poll() );
        
        
        Iterator<Integer> it = q.iterator();
        System.out.println(it.next());
        it.remove();
        System.out.println(q);
        
        
        HashSet<Integer> hs = new HashSet<>();
        hs.add(2); hs.add(54); hs.add(54);
        System.out.println(hs);
        
        Map<Character , Integer > mp1 = new HashMap<>();
        String s = "mmanoj";
        Character c = s.charAt(1);
        mp1.put(c, 1);
        mp1.put(c, 2);
        System.out.println(mp1);
        s.length();

        for(var k : mp1.keySet() ){
            System.out.println( k + " " + mp1.get(k) );
        }
    }   
    public static void greet(printer p ){
        p.print("Hello");
    } 
}
