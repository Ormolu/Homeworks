import java.util.Scanner;

public class NumbersScanner {

        int secretNumber;
        int attempts;

        public NumbersScanner(int secretNumber, int attempts) {
            this.secretNumber = secretNumber;
            this.attempts = attempts;
        }

        public boolean makeGuess(int guessed) {
            return guessed == this.secretNumber;
        }

        public void guessNumber() {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < attempts; i++) {
                System.out.println("Enter your guess: ");
                int guessed = scanner.nextInt();

                if (makeGuess(guessed)) {
                    System.out.println("YES! You won!");
                    return;
                }
                System.out.println("Sorry, nope");
            }
            System.out.println("Game over");
        }
    }


