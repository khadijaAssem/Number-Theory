import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String [] arg){
        Scanner s =new Scanner(System.in);
        long a,b,m;
        int n;
        String crt;
        ArrayList<Long> modes;
        while (true){
            System.out.println("Entre : 1 for Fast Exponentiation OR");
            System.out.println("      : 2 for Extended Euclidean Algorithm OR");
            System.out.println("      : 3 for Chinese Remainder OR");
            System.out.println("      : 4 for Prime Number Generation OR");
            System.out.println("any other key to Exit");
            char c =s.next().charAt(0);
            System.out.println("***************************************");
            switch (c){
                case ('1'):
                    System.out.println("Entre a,b,m");
                    a=s.nextLong();
                    b=s.nextLong();
                    m=s.nextLong();
                    fastExp f= new fastExp();
                    System.out.println("first naive using recursive : "+f.firstNaiveRecursive(a,b,m));
                    System.out.println("first naive using iterative : "+f.firstNaiveIterative(a,b,m));
                    System.out.println("second naive using recursive : "+f.secondNaiveRecursive(a,b,m));
                    System.out.println("second naive using iterative : "+f.secondNaiveIterative(a,b,m));
                    System.out.println("***************************************");
                    break;
                case('2'):
                    System.out.println("Entre a,b");
                    a=s.nextLong();
                    b=s.nextLong();
                    gcd output=new gcd();
                    System.out.println(output.gcd(a,b)+"=gcd("+a+","+b+")");
                    long[] result=output.extendGCD(a,b);
                    System.out.println(output.gcd(a,b)+"="+result[0]+"*"+a+"+"+result[1]+"*"+b);
                    System.out.println("***************************************");
                    break;
                case('3'):
                    System.out.println("Entre a,b");
                    a=s.nextLong();
                    b=s.nextLong();
                    System.out.println("Entre M in the following format : M1,M2,....Mn");
                    crt=s.next();
                    String[] spillited =crt.split(" *, *");
                    modes = new ArrayList<>();
                    for (int i=0;i<spillited.length;i++){
                        modes.add(Long.parseLong(spillited[i]));
                    }

                    CRT ou=new CRT();
                    System.out.println("multiplication of 2 numbers is : "+ou.findCRT(a,b,modes,true));
                    System.out.println("addition of 2 numbers is : "+ou.findCRT(a,b,modes,false));
                    System.out.println("***************************************");
                    break;
                case ('4'):
                    System.out.println("Entre n");
                    n=s.nextInt();
                    SievePrimeFactors out = new SievePrimeFactors();
                    out.sieve(n);
                    System.out.println("***************************************");
                    break;
                default:
                    return;
            }


        }

    }
}
