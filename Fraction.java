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
        
        int [] answers = new int[5];
        int [] returns = checkString(in);
        int operation = returns[0];
        int operatorIndex=returns[1];
        String input = Global.input;
        int numDivCount = 0;
        int denomDivCount=0;
        boolean denomGood = false;
        boolean numGood = false;
        //System.out.println(input);
        while(!denomGood || !numGood)
        //while(answer == Integer.MAX_VALUE)
        {
            String numerator = input.substring(0, operatorIndex-1);
            String denominator = input.substring(operatorIndex+2);
            //System.out.println(operatorIndex + "" + operatorIndex);
            //System.out.println(numerator);
            //System.out.println(denominator);
            char[] numArr = numerator.toCharArray();
            for(int i = 0; i<numArr.length; i++)
            {
                if(numArr[i]==47)
                {
                    numDivCount+=1;
                    if(numDivCount>1)
                    {
                        System.out.println("INCORRECT INPUT");
                      
                        returns = checkString(in);
                        operation = returns[0];
                        operatorIndex=returns[1];
                        input = Global.input;
                        numDivCount=0;
                        numGood=false;
                    }
                }
                if(numArr[i] < 47 || numArr[i]>57)
                {
                    
                    System.out.println("INCORRECT INPUT");
                    
                    returns = checkString(in);
                    operation = returns[0];
                    operatorIndex=returns[1];
                    input = Global.input;
                    numDivCount=0;
                    numGood=false;
                }
                else if(i==numArr.length-1)
                {
                    numDivCount=0;
                } 
            }
            numGood=true;
            char[] denomArr = denominator.toCharArray();
            for(int i = 0; i<denomArr.length; i++)
            {
                if(denomArr[i]==47)
                {
                    denomDivCount+=1;
                    if(denomDivCount>1)
                    {
                        //System.out.println("INCORRECT INPUT");
                        //System.out.println(operatorIndex);
            
                        returns = checkString(in);
                        operation = returns[0];
                        operatorIndex=returns[1];
                        input = Global.input;
                        denomDivCount=0;
                        denomGood=false;
                    }
                }
                if(denomArr[i] < 47 || denomArr[i]>57)
                {
                    
                    System.out.println("INCORRECT INPUT");
                    
                    returns = checkString(in);
                    operation = returns[0];
                    operatorIndex=returns[1];
                    input = Global.input;
                    denomDivCount=0;
                    denomGood=false;
                }
                else if(i==denomArr.length-1)
                {
                    denomDivCount=0;
                }
                denomGood=true;
                
            }

            //dividing the numerator and denominator into their equal parts!
            answers = equationSolver(numerator, denominator, operation);
            System.out.println("The answer is: " + answers[0] + "/" + answers[1] + " ==> " + answers[2] + "/" + answers[3] + " ==> " + answers[4] );



        }
        
        //String numerator = 

        //System.out.println(operation + "" + operatorIndex);
    }
    public static int[] equationSolver(String num, String denom, int operation)
    {
        int[] solutions = new int[5];
        int unNum=0;
        int unDenom=0;
        int numDivPos = num.indexOf("/");
        int num1 = Integer.parseInt(num.substring(0,numDivPos));
        int denom1 = Integer.parseInt(num.substring(numDivPos+1));
        
        int denomDivPos = denom.indexOf("/");
        int num2 = Integer.parseInt(denom.substring(0,denomDivPos));
        int denom2 = Integer.parseInt(denom.substring(denomDivPos+1));
        char operand = '`';
        /*switch(operation)
        {
            case 1:
                operand = '+';
            break;
            case 2:
                operand = 'X'
            break;
            case 3:
                operand = '÷'
            break;
            case 4:
                operand = '-'
            break;
        }*/
       

        int lcm=0;

        switch(operation)
        {
            case 1: //addition
                unNum = ((num1*denom2) + (num2*denom1));
                unDenom = (denom1*denom2);
            break;
            case 2: //multiplication
                unNum = num1*num2;
                unDenom = denom1*denom2;
            break;
            case 3: //divide
                unNum = num1*denom2;
                unDenom = denom1*num2;
            break;
            case 4: //subtract
                unNum = ((num1*denom2) - (num2*denom1));
                unDenom = (denom1*denom2);
            break;

        }
        solutions[0] = unNum;
        solutions[1] = unDenom;
        int simpliNum = unNum;
        int simpliDenom = unDenom;
        for(int i = (int)Math.max(unNum,unDenom); i>1; i--)
        {
            if(unNum%i == 0 && unDenom%i == 0)
            {
                lcm = i;
                //System.out.println(lcm);
                break;
            }
        }
        if(lcm != 0)
        {
            simpliNum = unNum/lcm;
            simpliDenom = unDenom/lcm;
        }
        int approx = Math.round((unNum/unDenom));
        
       solutions[2] = simpliNum;
       solutions[3] = simpliDenom;
       solutions[4] = approx;

        return solutions;
    }
    public static int[] checkString(Scanner in)
    {
        System.out.print("Enter a fraction, operator, and another fraction usingthis format: (2/3 + 1/2), and I will add, subtract, multiply, or divide the fractions according to the operation desired. ");
        System.out.print("\nEnter Fractions--> ");
        
        String input = in.nextLine();
        Global.input=input;
        //glb=input;
        char[] chars = input.toCharArray();
        
        int firstSlash = input.indexOf("/");
        //System.out.println(firstSlash);
        
        
        int operation = 0;
        int operatorIndex=999;
        int spaceCount = 0;
        int[] returns = new int[2];
        if(firstSlash==-1)
        {
            System.out.println("INCORRECT INPUT");
            returns = checkString(in);
            return returns;
        }
        for(int i = 0; i<chars.length; i++)
        {
            if(chars[i] == ' ')
            {
                spaceCount++;
            }
            if(i == chars.length-1 && spaceCount != 2)
            {
                System.out.println("INCORRECT INPUT");
                returns = checkString(in);
                return returns;
            }
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