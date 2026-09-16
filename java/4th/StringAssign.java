public class StringAssign {
    public static void q1(){
        System.out.println("Enter String");
        String s = ConsoleInput.getString();
        int index = 0;
        do{
            System.out.println("Enter index to find the char");
            index = ConsoleInput.getInt();
            for(int iTemp =0 ; iTemp < s.length() ; iTemp++){
                if(index == iTemp)
                    System.out.println("The character at position " + index + " is " +s.charAt(iTemp));
            }
        }while(index >= 0 && index < s.length());
    }
    
    
    public static void q2(){
        System.out.println("Enter String1 ");
        String s1 = ConsoleInput.getString();
        System.out.println("Enter String2 ");
        String s2 = ConsoleInput.getString();
        if(s1.compareTo(s2) == 0)
            System.out.println("Lexicographically true " );
        else
            System.out.println("Lexicographically false " );
    }
    

    public static void q3(){
        System.out.println("Enter String 1 ");
        String s1 = ConsoleInput.getString();
        boolean flag = true;
        while(flag){
            System.out.println("Enter String 2 to check if str 1 ends with it or not");
            String s2 = ConsoleInput.getString();
            if(s1.endsWith(s2))
                System.out.println("Same ending");
            else{
                System.out.println("Diff ending");
                flag = false;
            }
        }
    }
    public static void main(String args[]){
        // q1();
        // q2();
        q3();

    }
}

