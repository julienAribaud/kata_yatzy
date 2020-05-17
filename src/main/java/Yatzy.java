public class Yatzy {

    private static final int NUMBER_OF_DICE =5;
    private static final int MAX_VALUE =6;

    private static final int DEFAULT_VALUE_INVALID=0;
    private static final int SMALL_STRAIGHT_VALUE=15;
    private static final int BIG_STRAIGHT_VALUE=20;
    private static final int YATZY_VALUE=50;

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

    private int[] countDiceValues(){
        int[] counts = new int[MAX_VALUE];

        for (int dice : dices)
            counts[dice-1]++;

        return counts;
    }

    public int yatzy() {
        for (int count : countDiceValues())
            if (count == NUMBER_OF_DICE)
                return YATZY_VALUE;
        return DEFAULT_VALUE_INVALID;
    }

    private int sumValueCalled(int valueCalled) {
        int sum = 0;
        for (int dice : dices) {
            if (dice == valueCalled)
                sum += valueCalled;
        }
        return sum;
    }

    public int ones() { return sumValueCalled(1); }
    public int twos() { return sumValueCalled(2); }
    public int threes() { return sumValueCalled(3); }
    public int fours() { return sumValueCalled(4); }
    public int fives() { return sumValueCalled(5); }
    public int sixes() { return sumValueCalled(6); }

    private int calculValueByTimes(int value,int numberOfTimes){
        return (value+1)*numberOfTimes;
    }

    public int two_pair() {
        int[] counts= countDiceValues();

        boolean gotPairYet=false;
        int previousPoints=0;

        for (int diceValue=0;diceValue<counts.length;diceValue++) {
            if (counts[diceValue] >= 2) {
                int points=calculValueByTimes(diceValue, 2);
                if (gotPairYet) {
                    return points + previousPoints;
                }
                previousPoints = points;
                gotPairYet = true;
            }
        }
        return DEFAULT_VALUE_INVALID;
    }

    private int searchAndCalculSameValueNTimes(int numberOfTime) {
        int[] counts = countDiceValues();

        for (int diceValue = counts.length - 1; diceValue >= 0; diceValue--)
            if (counts[diceValue] >= numberOfTime)
                return calculValueByTimes(diceValue,numberOfTime);

        return DEFAULT_VALUE_INVALID;
    }

    public int pair() {
        return searchAndCalculSameValueNTimes(2);
    }

    public int three_of_a_kind() {
        return searchAndCalculSameValueNTimes(3);
    }

    public int four_of_a_kind() {
        return searchAndCalculSameValueNTimes(4);
    }

    public int smallStraight() {
        int[] count=countDiceValues();

        if (count[0] == 1 &&
            count[1] == 1 &&
            count[2] == 1 &&
            count[3] == 1 &&
            count[4] == 1)
            return SMALL_STRAIGHT_VALUE;
        return DEFAULT_VALUE_INVALID;
    }

    public int largeStraight() {
        int[] count=countDiceValues();

        if (count[1] == 1 &&
            count[2] == 1 &&
            count[3] == 1 &&
            count[4] == 1 &&
            count[5] == 1)
            return BIG_STRAIGHT_VALUE;
        return DEFAULT_VALUE_INVALID;
    }

    public int fullHouse() {
        int[] counts= countDiceValues();

        boolean gotPairYet=false;
        boolean gotTrippleYet=false;
        int previousPoints=0;

        for (int diceValue=0;diceValue<counts.length;diceValue++) {
            if (counts[diceValue] == 3) {
                int points=calculValueByTimes(diceValue, 3);
                if (gotPairYet)
                    return points + previousPoints;

                previousPoints = points;
                gotTrippleYet = true;

            }else if(counts[diceValue] == 2){
                int points=calculValueByTimes(diceValue, 2);
                if (gotTrippleYet)
                    return points + previousPoints;

                previousPoints = points;
                gotPairYet=true;
            }
        }
        return DEFAULT_VALUE_INVALID;
    }
}