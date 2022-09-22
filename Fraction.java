//Arjun Vasudevan
import java.util.*;

public class Fraction
{
    public class Global
    {
        public static String input = ""; //Sorry Mr. Matuni, I was too invested in this strat by this point that I had to do this...
    }

    Global quickStore = new Global();
    public static void main(String[] args)
    {
        
        Scanner in = new Scanner(System.in);
        int[] numerator = new int[20];
        int[] denominator = new int[20];
        
       
        int [] returns = checkString(in);
        int operation = returns[0];
        int operatorIndex=returns[1];
        String input = Global.input;
        System.out.println(input);
        //String numerator = 

        //System.out.println(operation + "" + operatorIndex);
    }
    
    public static int[] checkString(Scanner in)
    {
        System.out.print("Please input an expression in the order: num/denom (+/*-) num/denom --> ");
        
        String input = in.nextLine();
        Global.input=input;
        //glb=input;
        char[] chars = input.toCharArray();
        
        int firstSlash = input.indexOf("/");
        
        
        int operation = 0;
        int operatorIndex=999;
        int[] returns = new int[2];
        for(int i = firstSlash+1; i<chars.length; i++)
        {

            
            
            switch(chars[i])
            {
                case '+':
                    operation = 1;
                    operatorIndex=i;
                break;
                case '*':
                    operation = 2;
                    operatorIndex=i;
                break;
                case '/':
                    
                    operation = 3;
                    operatorIndex=i;
                break;
                 case '-':
                    operation = 4;
                    operatorIndex=i;
                break;
                default:
                    if(i==chars.length-1 && operation==0)
                    {
                        returns = checkString(in);
                        return returns;
                        
                    }
                break;
                        
                   
                    


            }

            
           
        }
        if(operation!=0)
        {
            returns[0] = operation;
            returns[1] = operatorIndex;
                
            return returns;
                //break;
        }
        int [] fail = new int [0];
        return fail;
    }
        
        
    

   
}