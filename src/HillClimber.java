import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HillClimber {

    public static final int _MAXSIZE = 30;

    public int firstImprovement(int nbEval, Automata automate) {

        int[] rules = new int[216];
        String outName = "resultHCFI.dat";
        PrintWriter ecrivain;

        Initialization initialization = new Initialization();
        initialization.init(rules);


        int fitness = automate.f(rules, _MAXSIZE);

        for (int i = 0; i < nbEval; i++) {
            int[] rulesNeighbor = Solution.getNeighbor(initialization, rules);

            int fitnessNeighbor = automate.f(rulesNeighbor, _MAXSIZE);

            if (fitnessNeighbor >= fitness) {
                rules = rulesNeighbor;
                fitness = fitnessNeighbor;
            }
        }
        try {
            ecrivain =  new PrintWriter(new BufferedWriter(new FileWriter(outName)));

            printToFile(fitness, rules, ecrivain);

            ecrivain.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return fitness;
    }

    public static void printToFile(int fitness, int [] rules, PrintWriter ecrivain) {
        ecrivain.print(fitness);
        for(int i = 0; i < 216; i++) {
            ecrivain.print(" ");
            ecrivain.print(rules[i]);
        }
        ecrivain.println();
    }

}