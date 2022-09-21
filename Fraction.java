//Arjun Vasudevan
import java.util.*;

public class Fraction
{
    public static void main(String[] args)
    {
        
        Scanner in = new Scanner(System.in);
        int[] numerator = new int[5];
        int[] denominator = new int[5];
        System.out.print("Please input an expression in the order: num/denom (+/*-) num/denom --> ");
        
        String input = in.nextLine();
        char[] chars = input.toCharArray();
        int operation = 0;
        int operatorIndex=999;
        int firstSlash = input.indexOf("/");
    
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
                            System.out.println("ERROR: Please input an expression in the order: num/denom (+/*-) num/denom!");
                            operation = 0;
                            break;
                        }
                        break;
                        
                   
                    


                }

                if(operation!=0)
                {
                    System.out.println(operation + "" + operatorIndex);
                    break;
                }
                
            
            

            
        }
        
    }

   
}