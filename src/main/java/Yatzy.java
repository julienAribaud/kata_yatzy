public class Yatzy {

    private static final int NUMBER_OF_DICE =5;
    private static final int MAX_VALUE =6;

    protected int[] dices= new int[NUMBER_OF_DICE];

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
    }

    public int chance() {
        int sum=0;
        for(int dice : dices){
            sum+=dice;
        }
        return sum;
    }

    public int yatzy() {
        for (int count : countDiceValues())
            if (count == NUMBER_OF_DICE)
                return 50;
        return 0;
    }

    private int sumValueCalled(int valueCalled){
        int sum=0;
        for(int dice:dices){
            if(dice==valueCalled)
                sum+=valueCalled;
        }
        return sum;
    }

    private int[] countDiceValues(){
        int[] counts = new int[MAX_VALUE];

        for (int dice : dices)
            counts[dice-1]++;

        return counts;
    }

    private int sumWantedIterationOfDiceValue(int numberWanted) {
        int[] counts = countDiceValues();

        for (int i = counts.length - 1; i >= 0; i--)
            if (counts[i] >= numberWanted)
                return (i + 1) * numberWanted;

        return 0;
    }

    public int ones() { return sumValueCalled(1); }
    public int twos(){
        return sumValueCalled(2);
    }
    public int threes(){
        return sumValueCalled(3);
    }
    public int fours(){
       return sumValueCalled(4);
    }
    public int fives() { return sumValueCalled(5); }
    public int sixes() { return sumValueCalled(6); }

    public int two_pair() {
        int[] counts= countDiceValues();

        boolean gotDouble=false;
        int previousDoubleSum=0;

        for (int i=0;i<counts.length;i++) {
            if (counts[i] >= 2) {
                if (gotDouble) {
                    return (i + 1) * 2 + previousDoubleSum;
                }
                previousDoubleSum = (i + 1) * 2;
                gotDouble = true;
            }
        }
        return 0;
    }

    public int pair() {
        return sumWantedIterationOfDiceValue(2);
    }

    public int three_of_a_kind() {
        return sumWantedIterationOfDiceValue(3);
    }

    public int four_of_a_kind() {
        return sumWantedIterationOfDiceValue(4);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



