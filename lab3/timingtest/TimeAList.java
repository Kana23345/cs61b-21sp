package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Integer> ops = new AList<>();
        AList<Double> times=new AList<>();
        Stopwatch st=new Stopwatch();
        int count;
        for (int i=0;i<12;i++) {
            count= (int) Math.pow(2,i) * 1000;
            Ns.addLast(count);
            ops.addLast(count);
            for (int j=0;j<count;j++){
                AList<Integer> aList=new AList<>();
                aList.addLast(j);
            }
            times.addLast(st.elapsedTime());
        }

        printTimingTable(Ns,times,ops);
    }
}
