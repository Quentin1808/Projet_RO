public class ILS {


    public int ILS(int nbEval, Automata automate) {

        int bestFitness = 0;
        int fitness;

        for (int i = 0; i < nbEval; i++){

            HillClimber hc = new HillClimber();
            fitness = hc.firstImprovement(2000000, automate);

            if(fitness >= bestFitness){
                bestFitness = fitness;
            }

        }

        return bestFitness;
    }

}
