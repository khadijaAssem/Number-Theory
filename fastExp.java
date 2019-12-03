public class fastExp {
    public long firstNaiveIterative(long a,long b,long m){
        long c=1;
        for (int i=1;i<=b;i++) {
            c=c*a;
            while (c<0){
                c+=m;
            }
            c=c%m;
        }
        return c;
    }
    public long secondNaiveIterative(long a,long b,long m){
        long c=1;
        for (int i=1;i<=b;i++) {
            c=(c*a)%m;
            while (c<0){
                c+=m;
            }
        }
        return c;
    }
    public long firstNaiveRecursive(long a,long b,long m){
        long c=1;
        if(a==0)
            return 0;
        if(b==0)
            return 1;
        if (b%2==0){
            c=firstNaiveRecursive(a,b/2,m);
            c=((long)Math.pow(c,2))%m;
        }else{
            c=a%m;
            c=(c*firstNaiveRecursive(a,b-1,m)%m)%m;
        }

        return (c+m)%m;
    }
    public long secondNaiveRecursive(long a,long b,long m){
        long c=1;
        if(a==0)
            return 0;
        if(b==0)
            return 1;
        if (b%2==0){
            c=((long)Math.pow(secondNaiveRecursive(a,b/2,m),2))%m;
        }else{
            c=((a%m)*secondNaiveRecursive(a,b-1,m)%m)%m;
        }

        return (c+m)%m;
    }

}