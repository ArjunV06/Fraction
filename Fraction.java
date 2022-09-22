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
        //int[] numerator = new int[20];
        //int[] denominator = new int[20];
        
        int answer = Integer.MAX_VALUE;
        int [] returns = checkString(in);
        int operation = returns[0];
        int operatorIndex=returns[1];
        String input = Global.input;
        int numDivCount = 0;
        int denomDivCount=0;
        //System.out.println(input);
        while(answer==Integer.MAX_VALUE)
        {
            String numerator = input.substring(0, operatorIndex-1);
            String denominator = input.substring(operatorIndex+2);
            System.out.println(operatorIndex + "" + operatorIndex);
            System.out.println(numerator);
            System.out.println(denominator);
            char[] numArr = numerator.toCharArray();
            for(int i = 0; i<numArr.length; i++)
            {
                if(numArr[i]==47)
                {
                    numDivCount+=1;
                    if(numDivCount>1)
                    {
                        System.out.println("INCORRECT INPUT NUM TOO SLASHES");
                        System.out.println(operatorIndex);
                        System.out.println(numerator);
                        System.out.println(denominator);
                        returns = checkString(in);
                        operation = returns[0];
                        operatorIndex=returns[1];
                        input = Global.input;
                        numDivCount=0;
                    }
                }
                if(numArr[i] < 47 || numArr[i]>57)
                {
                    
                    System.out.println("INCORRECT INPUT NUM");
                    System.out.println(operatorIndex);
                    System.out.println(numerator);
                    System.out.println(denominator);
                    returns = checkString(in);
                    operation = returns[0];
                    operatorIndex=returns[1];
                    input = Global.input;
                    numDivCount=0;
                }
                else if(i==numArr.length-1)
                {
                    numDivCount=0;
                }
            }
            char[] denomArr = denominator.toCharArray();
            for(int i = 0; i<denomArr.length; i++)
            {
                if(denomArr[i]==47)
                {
                    denomDivCount+=1;
                    if(denomDivCount>1)
                    {
                        System.out.println("INCORRECT INPUT DENOM");
                        System.out.println(operatorIndex);
            System.out.println(numerator);
            System.out.println(denominator);
                        returns = checkString(in);
                        operation = returns[0];
                        operatorIndex=returns[1];
                        input = Global.input;
                        denomDivCount=0;
                    }
                }
                if(denomArr[i] < 47 || denomArr[i]>57)
                {
                    
                    System.out.println("INCORRECT INPUT DENOM");
                    System.out.println(operatorIndex);
            System.out.println(numerator);
            System.out.println(denominator);
                    returns = checkString(in);
                    operation = returns[0];
                    operatorIndex=returns[1];
                    input = Global.input;
                    denomDivCount=0;
                }
                else if(i==denomArr.length-1)
                {
                    denomDivCount=0;
                }
                
            }
        }
        
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
        //System.out.println(firstSlash);
        
        
        int operation = 0;
        int operatorIndex=999;
        int[] returns = new int[2];
        if(firstSlash==-1)
        {
            returns = checkString(in);
            return returns;
        }
        for(int i = firstSlash+1; i<chars.length; i++)
        {

            
            
            switch(chars[i])
            {
                case '+':
                    operation = 1;
                    operatorIndex=i;
                    returns[0] = operation;
                    returns[1] = operatorIndex;
                
                    return returns;
                //break;
                case '*':
                    operation = 2;
                    operatorIndex=i;
                    returns[0] = operation;
                    returns[1] = operatorIndex;
                
                    return returns;
                //break;
                case '/':
                    
                    operation = 3;
                    operatorIndex=i;
                    returns[0] = operation;
                    returns[1] = operatorIndex;
                
                    return returns;
                //break;
                case '-':
                    operation = 4;
                    operatorIndex=i;
                    returns[0] = operation;
                    returns[1] = operatorIndex;
                
                    return returns;
                //break;
                default:
                    if(i==chars.length-1 && operation==0)
                    {
                        System.out.println("INCORRECT INPUT");
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