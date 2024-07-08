import java.util.Scanner;

abstract class binaryOperations 
{
    abstract myBinaryNumber binaryMultiplication(myBinaryNumber a, myBinaryNumber b);
    
    myBinaryNumber binaryAddition(myBinaryNumber a, myBinaryNumber b) 
    {
        int num1 = a.getDecimalValue();
        int num2 = b.getDecimalValue();
        
        int sum = num1 + num2;
        
        return new myBinaryNumber(Integer.toBinaryString(sum));
    }
}

class myBinaryNumber 
{
    private String binaryString;

    public myBinaryNumber(String binaryString) 
    {
        this.binaryString = binaryString;
    }

    public int getDecimalValue() 
    {
        return Integer.parseInt(binaryString, 2);
    }
}

class Main {
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) 
        {
            System.out.print("Enter first binary number: ");
            String binary1 = sc.nextLine();
            
            System.out.print("Enter second binary number: ");
            String binary2 = sc.nextLine();
            
            myBinaryNumber num1 = new myBinaryNumber(binary1);
            myBinaryNumber num2 = new myBinaryNumber(binary2); 
            
            binaryOperations ops = new binaryOperations() 
            {
                myBinaryNumber binaryMultiplication(myBinaryNumber a, myBinaryNumber b) 
                {
                    int num1 = a.getDecimalValue();
                    int num2 = b.getDecimalValue();
                    
                    int product = num1 * num2;
                    
                    return new myBinaryNumber(Integer.toBinaryString(product));
                }
            };
            
            myBinaryNumber sum = ops.binaryAddition(num1, num2);
            myBinaryNumber product = ops.binaryMultiplication(num1, num2);
            
            System.out.println("Binary Addition Result: " + sum.getDecimalValue()); // Should output 8 (1011)
            System.out.println("Binary Multiplication Result: " + product.getDecimalValue()); // Should output 15 (1111)
        }
    }
}
