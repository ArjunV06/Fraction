//Arjun Vasudevan
import java.util.*;

public class Fraction
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] numerator = new int[5];
        int[] denominator = new int[5];
        String input = in.nextLine();
        char[] chars = input.toCharArray();
        int operation = 0;
        for(int i = 0; i<chars.length; i++)
        {
            switch(char[i])
            {
                case '+':
                    operation = 0;
                    break;
                case '*':
                    operation = 1;
                case '/':
                    operation = 2;
                case '-':
                    operation = 3;
                default:
                    System.out.println("Please input an expression in the order: num/denom +/*- num/denom; or input just a fraction in num/denom form");
                    


            }
        }
        
    }
}