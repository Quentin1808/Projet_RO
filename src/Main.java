public class Main {


    public static void main(String[] args) {

        Automata automate = new Automata(30);

        HillClimber hc = new HillClimber();
        int fitness = hc.firstImprovement(10000000, automate);

        //ILS ils = new ILS();
        //int fitness = ils.ILS(200, automate);

        System.out.print("Best fitness : ");
        System.out.print(fitness);


    }

}
