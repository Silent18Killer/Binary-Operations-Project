import java.util.Scanner;

class karatsuba {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the first binary number: ");
            String binary1 = sc.nextLine();
            System.out.print("Enter the second binary number: ");
            String binary2 = sc.nextLine();

            int num0= Integer.parseInt(binary1, 2);
            int num1= Integer.parseInt(binary2, 2);

            int sum= num0 + num1;
            String result1 = Integer.toBinaryString(sum);

            System.out.println("0"+result1);
            String result = binaryMultiply(binary1, binary2);


            System.out.println("0" + result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static String binaryMultiply(String binary1, String binary2) {
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);

        int product = num1 * num2;

        return Integer.toBinaryString(product);
    }

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

    public String binaryMultiplicationFast(String binary1, String binary2) {
        int num1 = Integer.parseInt(binary1, 2);
        int num2 = Integer.parseInt(binary2, 2);

        int product = karatsubaMultiply(num1, num2);

        return Integer.toBinaryString(product);
    }

    public int karatsubaMultiply(int x, int y) {
        if (x < 10 || y < 10) {
            return x * y;
        }

        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        int halfN = n / 2;

        int a = x >> halfN;
        int b = x & ((1 << halfN) - 1);
        int c = y >> halfN;
        int d = y & ((1 << halfN) - 1);

        int ac = karatsubaMultiply(a, c);
        int bd = karatsubaMultiply(b, d);
        int adbc = karatsubaMultiply(a + b, c + d) - ac - bd;

        return (ac << (2 * halfN)) + (adbc << halfN) + bd;
    }
}
