import java.io.*;

class Driver 
{
    static long binaryMultiplication(long b1, long b2) 
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

    public static void main(String[] args) throws IOException 
    {
        FileReader fileReader = new FileReader("Input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String binary1 = bufferedReader.readLine();
        String binary2 = bufferedReader.readLine();
        bufferedReader.close();

        long number1 = Long.parseLong(binary1, 2);
        long number2 = Long.parseLong(binary2, 2);

        long product = binaryMultiplication(number1, number2);

        FileWriter fileWriter = new FileWriter("Output.txt");
        fileWriter.write(Long.toBinaryString(product));
        fileWriter.close();

        System.out.println("Result written to output.txt");
    }
}
