import java.util.Random;

public class Solution {

    public static final int _NBITER = 216;

    public static int[] getNeighbor(Initialization init, int[] regles) {
        int[] rulesNeighbor = new int[_NBITER];
        for (int tmpi = 0; tmpi < _NBITER; tmpi++) {
            rulesNeighbor[tmpi] = regles[tmpi];
        }

        Random r = new Random();

        int low = 0;
        int high = init.tabIndice.length;
        int randomInt = r.nextInt(high - low) + low;
        int indexRule = init.tabIndice[randomInt];

        int previousValue = rulesNeighbor[indexRule];
        int newValue = generateNewValue(previousValue);

        rulesNeighbor[indexRule] = newValue;

        return rulesNeighbor;

    }

    private static int generateNewValue(int oldValue) {
        Random r = new Random();
        int randomInt;

        randomInt = r.nextInt(4);

        if(randomInt == oldValue){
            randomInt = (randomInt + 1) % 4;
        }

        return randomInt;

    }

}