import java.util.Scanner;

class BinaryOperations 
{
    static long binaryMultiplicationNaive(long b1, long b2) 
    {
        long result = 0;
        while (b2 != 0) 
        {
            if ((b2 & 1) == 1) 
            {
                result += b1;
            }
            b1 <<= 1;
            b2 >>= 1;
        }
        return result;
    }
}

class BinaryMultiplicationNaive extends BinaryOperations 
{
    public static void main(String[] args) 
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter binary number A: ");
            String b1 = sc.nextLine();
            System.out.print("Enter binary number B: ");
            String b2 = sc.nextLine();
            
            long number1 = Long.parseLong(b1, 2);
            long number2 = Long.parseLong(b2, 2);

            long product = binaryMultiplicationNaive(number1, number2);
            System.out.println("\nA * B is : " + Long.toBinaryString(product));
        }
    }
}
