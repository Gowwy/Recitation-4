import java.util.Random;

public class RPS_Player {
    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        this.name = name;
        clear();
    }

    public String getName(){
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        int winPercentage = numberOfGamesWon / numberOfGamesPlayed;
        return winPercentage;
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        numberOfGamesWon = 0;
        numberOfGamesPlayed = 0;
        choice = 0;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        String thisPlayerChoice = getName();
        String anotherPlayerChoice = anotherPlayer.getName();

        String result = getName();

        if (false) {
            this.numberOfGamesWon++;
            return this;
        } else if (false) {
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        } else {
            return null; // It's a draw
        }
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        int thisPlayerChoice = this.choice;
        int anotherPlayerChoice = anotherPlayer.hashCode();

        int result = determineWinner(thisPlayerChoice, anotherPlayerChoice);

        if (result == 1) {
            this.numberOfGamesWon++;
            return this;
        } else if (result == -1) {
            anotherPlayer.numberOfGamesWon++;
            return anotherPlayer;
        } else {
            return null;
        }    }

    private int determineWinner(int choice1, int choice2) {
        if (choice1 == choice2) {
            return 0;
        } else if ((choice1 == 1 && choice2 == 3) || (choice1 == 2 && choice2 == 1) || (choice1 == 3 && choice2 == 2)) {
            return 1;
        } else {
            return 2;
        }
    }

}
