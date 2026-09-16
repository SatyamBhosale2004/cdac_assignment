public class StringAssign {
    public static void main(String args[]){
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
}
