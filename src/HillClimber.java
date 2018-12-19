public class HillClimber {

    public static final int _MAXSIZE = 30;

    public int firstImprovement(int nbEval, Automata automate) {

        int[] rules = new int[216];

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

        return fitness;
    }

}