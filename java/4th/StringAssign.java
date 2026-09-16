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

    public static void q4(){
        String s = "The quick brown fox jumps over the lazy dog.";
        // int count = 0;
        // int count1 = 0;
        // for(int iTemp =0 ; iTemp < s.length() ; iTemp++){
        //     System.out.print(s.charAt(iTemp) + " \t");
        //     count ++;
        //     if(count == 10){
        //         System.out.println();
        //         System.out.print("==================================================================");
        //         System.out.println();
        //         count = 0;
        //         for(int jTemp=iTemp; jTemp < s.length(); jTemp++){
        //             System.out.print((int)s.charAt(jTemp) + " \t");
        //             count1++;
        //             if(count1 == 10){
        //                 break;
        //                 count1 = 0;
        //             }

        //         }
                
        //     }

        // }
        // String lowerS = s.toLowerCase();
        // int indexAlphabet[] = new int[26];

        // for(int iTmp = 0; iTmp < lowerS.length(); iTmp++){

        // }
        String lowerS = s.toLowerCase();
        char alphabet[] = new char[26];
        int index = 0;
        for(char ch = 'a' ; ch <= 'z' ; ch++ ){
            alphabet[index++] = ch;
        }

        int indices[] = new int[26];
        for(int iTmp = 0 ; iTmp < alphabet.length; iTmp++){
            indices[iTmp] = s.indexOf(alphabet[iTmp]);
        }

        q4Print(alphabet, indices , 0 ,10);
        System.out.println();
        q4Print(alphabet, indices , 10 ,20);
        System.out.println();
        q4Print(alphabet, indices , 20 ,26);
        
    }
    public static void q4Print(char aplha[], int indx[], int start, int end){
        for(int iTmp = start ; iTmp < end ; iTmp++){
            System.out.print(aplha[iTmp] + " \t");
        }
        // alphbets
        System.out.println();

        for(int iTmp = start ; iTmp < end ; iTmp++){
            System.out.print("=========");
        }
        System.out.println();
        // dashes

        for(int iTmp = start ; iTmp < end; iTmp++){
            System.out.print(indx[iTmp] + " \t");
        }
        System.out.println();
    }

    public static void q5(){
        System.out.println("Enter String");
        String s = ConsoleInput.getString();
        System.out.println("Enter which String to replace");
        String sOg = ConsoleInput.getString();
        System.out.println("Enter String to be replace with");
        String sRep = ConsoleInput.getString();

        String regexOg = "\\b" + sOg + "\\b";// \ b is bounday so specific word can be replaced
        String newString = s.replaceAll(regexOg,sRep); 

        System.out.println("Og String  : " + s);
        System.out.println("New String : " + newString);
    
    }
    public static void q6(){
        System.out.println("Enter String");
        String s = ConsoleInput.getString();
        String sUpCase = s.toUpperCase();
        System.out.println(sUpCase);
    }

    public static void q7(){
        System.out.println("Enter String");
        String s = ConsoleInput.getString();
        System.out.println("The given string is : " +s);
        System.out.println("The reverse order is: ");
        for(int iTmp = s.length()-1; iTmp >=0;iTmp--){
            System.out.print(s.charAt(iTmp));
        }
    }
    public static void main(String args[]){
        // q1();
        // q2();
        // q3();
        q4();
        // q5();
        // q6();
        // q7();
    }
}

