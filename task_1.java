import java.util.Scanner;

class myBinaryNumber 
{
    private String binaryString;

    public myBinaryNumber(int n) 
    {
        if (n <= 0) 
        {
            throw new IllegalArgumentException("Size must be positive.");
        }
        binaryString = new String(new char[n]).replace('\0', '0');
    }

    public myBinaryNumber(String S) 
    {
        if (!S.matches("[01]+")) 
        {
            throw new IllegalArgumentException("Invalid binary string.");
        }
        binaryString = S;
    }

    public int getSize() 
    {
        return binaryString.length();
    }

    public int getBit(int p) 
    {
        checkBounds(p);
        return binaryString.charAt(p) - '0';
    }

    public void setBit(int p, int b) 
    {
        checkBounds(p);
        if (b != 0 && b != 1) 
        {
            throw new IllegalArgumentException("Bit value must be 0 or 1.");
        }
        char[] chars = binaryString.toCharArray();
        chars[p] = (char) (b + '0');
        binaryString = new String(chars);
    }

    public void printNumber() 
    {
        System.out.println(binaryString);
    }

    public void printDecimalNumber() 
    {
        int decimal = Integer.parseInt(binaryString, 2);
        System.out.println(decimal);
    }

    private void checkBounds(int p) 
    {
        if (p < 0 || p >= binaryString.length()) 
        {
            throw new IndexOutOfBoundsException("Invalid bit position.");
        }
    }
}



class Main 
{
    public static void main(String[] args) 
    
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Binary to decimal");
        System.out.print("Enter a binary number : ");
        String userInput1 = sc.nextLine();

        myBinaryNumber binaryNumber1 = new myBinaryNumber(userInput1);

        System.out.print("Binary number : ");
        binaryNumber1.printNumber();

        System.out.print("Decimal equivalent : ");
        binaryNumber1.printDecimalNumber();

        
        System.out.println("\nDecimal to binary");
        System.out.print("Enter a decimal number : ");
        int decimalInput = sc.nextInt();

        String binaryString = Integer.toBinaryString(decimalInput);

        myBinaryNumber binaryNumber = new myBinaryNumber(binaryString);

        System.out.print("Binary number : ");
        binaryNumber.printNumber();

        sc.close();
    }
}