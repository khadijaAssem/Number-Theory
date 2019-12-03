import java.util.ArrayList;

public class CRT {
    public  long findCRT(long x, long y, ArrayList<Long> M, boolean isMultiply) {
        ArrayList<Long> modesX = new ArrayList<>();
        ArrayList<Long> modesY = new ArrayList<>();
        for (int i = 0; i < M.size(); i++) {
            modesX.add(x % M.get(i));
            modesY.add(y % M.get(i));
        }
        ArrayList<Long> modes = new ArrayList<>();
        if (isMultiply)
            for (int i = 0; i < M.size(); i++)
                modes.add((modesX.get(i) * modesY.get(i)) % M.get(i));
        else
            for (int i = 0; i < M.size(); i++)
                modes.add((modesX.get(i) + modesY.get(i)) % M.get(i));
        return findMinX(M.toArray(), modes.toArray(), modes.size());
    }

     long findMinX(Object[] num, Object[] rem, int k) {
        long x = 1; // Initialize result
        // As per the Chinese remainder theorem,
        // this loop will always break.
        while (true) {
            // Check if remainder of x % num[j] is
            // rem[j] or not (for all j from 0 to k-1)
            int j;
            for (j = 0; j < k; j++)
                if (x % (long) num[j] != (long) rem[j])
                    break;
            // If all remainders matched, we found x
            if (j == k)
                return x;
            // Else try next number
            x++;
        }
    }
}