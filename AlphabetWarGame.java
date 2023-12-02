public class AlphabetWarGame {
    private static final String LEFT_SIDE = "wpbs";
    private static final String RIGHT_SIDE = "mqdz";
    private String leftSideStrengths;
    private String rightSideStrengths;
    public AlphabetWarGame() {
        this.leftSideStrengths = LEFT_SIDE;
        this.rightSideStrengths = RIGHT_SIDE;
    }
    public AlphabetWarGame(String leftStrengths, String rightStrengths) {
        this.leftSideStrengths = leftStrengths;
        this.rightSideStrengths = rightStrengths;
    }
    private int calculateStrength(String word, String strengths) {
        int totalStrength = 0;
        for (char letter : word.toCharArray()) {
            if (strengths.indexOf(letter) != -1) {
                totalStrength += strengths.indexOf(letter) + 1;
            }
        }
        return totalStrength;
    }
    public String AlphabetWar(String word) {
        int leftStrength = calculateStrength(word, leftSideStrengths);
        int rightStrength = calculateStrength(word, rightSideStrengths);
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
    public String AlphabetWar(String leftWord, String rightWord) 
{
        int leftStrength = calculateStrength(leftWord, leftSideStrengths);
        int rightStrength = calculateStrength(rightWord, rightSideStrengths);
        if (leftStrength > rightStrength) {
            return "Left side wins!";
        } else if (rightStrength > leftStrength) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }
    public static void main(String[] args) {
        AlphabetWarGame game = new AlphabetWarGame();
        System.out.println(game.AlphabetWar("z"));            
        System.out.println(game.AlphabetWar("zdqmwpbs"));      
        System.out.println(game.AlphabetWar("wwwwwwz"));      
    }
}
