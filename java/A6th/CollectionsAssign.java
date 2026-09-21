package A6th;
import common.ConsoleInput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.HashSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class CollectionsAssign{
    public static void main(String args[]){
        // q1();
        // q2();
        // q3();
        // q4();
        // q5();
        // q6();
        // q7();
        // q8();
        // q9();
        // q10();
        // q11();
        // q12();
        // q13();
        // q14();
        q15();
    }

    public static void q1(){
        ArrayList<String> colors = new ArrayList<>();

        colors.add("Blue");colors.add("Red");colors.add("Black");

        Iterator<String> it = colors.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }


    public static void q2(){
        ArrayList<Integer> al = new ArrayList<>();

        al.add(0, 10);
        System.out.println(al);
    }

    public static void q3(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        System.out.println("Enter index for element u wanna search");
        int index = ConsoleInput.getInt();
        System.out.println("Element at index " + index + " " +al.get(index));
    }

    public static void q4(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        al.set(3 , -90);
        System.out.println("Update elem at 3rd " + al.get(3));
    }

    public static void q5(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        al.remove(3);
        System.out.println("Now elem at 3rd " + al.get(3));
    }

    public static void q6(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        System.out.println("Enter element u wanna search");
        int elem = ConsoleInput.getInt();
        // if(al.contains(elem))
        //     System.out.println("Element at index " + al.indexOf(elem));
        // else
        //     System.out.println("Element not found");
        for(int iTmp = 0 ; iTmp < al.size() ; iTmp++){
            if(al.get(iTmp) == elem){
                System.out.println("Element is at index " + iTmp);
                return;
            }
            else
                System.out.println("Element not at index " + iTmp);
        }
    }

    public static void q7(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        Collections.sort(al);
        for(Integer i : al)
            System.out.println(i);
    }

    public static void q8(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        ArrayList<Integer> al2 = new ArrayList<>(al); // using al 's const
        for(Integer i : al2)
            System.out.println(i);
        // for(int iTmp = 0; iTmp < al.size() ; iTmp++)
        //     al2.add(null);
        // Collections.copy(al2, al);
        // for(Integer i : al2)
        //     System.out.println(i); // with .copy method
    }
    public static void q9(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        Collections.shuffle(al);
        for(Integer i : al)
            System.out.println(i);

    }
    public static void q10(){
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);al.add(102);al.add(0);al.add(110);al.add(10);al.add(30);
        Collections.reverse(al);
        for(Integer i : al)
            System.out.println(i);

    }
    public static void q11(){
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Blue");ts.add("Grey");ts.add("Violet");
        // System.out.println(ts.add("Blue"));
        for(String s : ts)
            System.out.println(s);
    }
    public static void q12(){
        TreeSet<String> ts1 = new TreeSet<>();
        ts1.add("Blue");ts1.add("Grey");ts1.add("Violet");ts1.add("Black");
        // System.out.println(ts.add("Blue"));
        TreeSet<String> ts2 = new TreeSet<>(ts1);
        // ts2.addAll(ts1); // addAll method
        for(String s : ts2)
            System.out.println(s);
    }

    public static void q13(){
        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Blue");ts.add("Grey");ts.add("Violet");
        // TreeSet<String> ts2 = new TreeSet<>(ts.descendingSet());
        TreeSet<String> ts2 = new TreeSet<>(Collections.reverseOrder());//basically Specific Implem of comparator here instead lowesrt to highest ulta in binary tree
        ts2.add("Blue");ts2.add("Grey");ts2.add("Violet");
        for(String s : ts2)
            System.out.println(s);
    }    

    public static void q14(){
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Blue");ts.add("Grey");ts.add("Violet");
        // System.out.println(ts.add("Blue"));
        System.out.println(ts.first());
        System.out.println(ts.last());
        // for(String s : ts)
        //     System.out.println(s);
    }

    public static void q15(){
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Blue");ts.add("Grey");ts.add("Violet");
        System.out.println("Enter element u wanna know which are bigger than this  present in TreeSet");
        String elem = ConsoleInput.getString();
        System.out.println("Element bigger than " + elem + " " + ts.ceiling(elem));
    }


}

