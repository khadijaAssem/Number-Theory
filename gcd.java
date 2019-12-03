public class gcd {
    public long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
    public long[] extendGCD(long a, long b)
    {
        long s = 0, t = 1, lastS = 1, lastT = 0, temp;
        long[]output={lastS,lastT};
        while (b != 0)
        {
            long q = a / b;
            long r = a % b;

            a = b;
            b = r;

            temp = s;
            s = lastS - q * s;
            lastS = temp;

            temp = t;
            t = lastT - q*t;
            lastT = temp;
        }
        output=new long[]{lastS,lastT};
        return output;
    }
}
