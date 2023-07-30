import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GuessNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //a dialog box will pop out with 2 options
        String choice = JOptionPane.showInputDialog("Press 1 to start \nPress 2 to end");
        int option = Integer.parseInt(choice);
        menu(option);
       
    }
    
    //Menu method for playing or end
    public static void menu(int option){
        if(option == 1){
        Random rand = new Random();
        int comp = rand.nextInt(100);

        String num= JOptionPane.showInputDialog("ENTER YOUR NUMBER (0 - 100)");
        int user = Integer.parseInt(num);
        
        check(comp,user);
        }
        else if(option == 2){
            JOptionPane.showMessageDialog(null,"ENDED , THANKS FOR PLAYING",null,JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null,"WRONG CHOICE !",null,JOptionPane.ERROR_MESSAGE);
    }

    //This method checks if user hits the correct guess uner the given limit
    public static void check(int comp,int user){
        int count=0; //numer of attempts
        int limit =8; 
        int score = 10; //every time the guess is wrong score will be -1
        while(user != comp && count < limit){
            if(user > comp){
                String num= JOptionPane.showInputDialog("LOWER NUMBER PLEASE !\nNumber of guesses left "+(limit-count));
                user = Integer.parseInt(num);
                count++;
                score--;
            }
            else if(user < comp){
                String num= JOptionPane.showInputDialog("HIGHER NUMBER PLEASE !\nNumber of guesses left "+(limit-count));
                user = Integer.parseInt(num);
                count++;
                score--;
            }
        }
        //checking if user hits the corect guess
        if(user == comp){
            JOptionPane.showMessageDialog(null,"CONGRATULATIONS !!! YOUR GUESS IS CORRECT\n-THE TOTAL NUMBER OF GUESSES IS "+count, null,JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null,"SCORE : "+score , null, JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"THE LIMIT OF GUESSES EXCEEDED !", null, JOptionPane.WARNING_MESSAGE);
        }

        //Pop up for asking player if he wants to play again or not
        String num = JOptionPane.showInputDialog("DO U WANT TO PLAY AGAIN ?\nEnter 1 for YES\nEnter 2 for NO");
        int option = Integer.parseInt(num);

        //menu method will be called again
        menu(option);
    }

}
//Task 2 NUMBER GUESSING game of internship in OasisInfobyte