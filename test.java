import java.util.Scanner;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String[]args){
        difficulty();

    }

    public static void difficulty(){
        Scanner console = new Scanner(System.in);
        String s;
        int games = 0;
        while(games<=20){
            System.out.println("Select Game Difficulty: Easy(e),  Intermediate(i),and Hard(h)");
            s = console.nextLine();
            if(s.length() == 0){
                System.out.println("Invalid Selection! Try Again");
                continue;
            }
            s = s.toLowerCase();
            s = s.substring(0,1);
            if(s.equals("e")){
                game(15, 4);
            }
            else if(s.equals("i")){
                game(12, 3);
            }
            else if(s.equals("h")){
                game(10, 2);
            }
            else{
                System.out.println("Invalid Selection! Try Again");
                continue;
            }
            games++;
        }
    }

    public static void game(int a, int b){
        Scanner console = new Scanner(System.in);
        String word;
        word = RandomWord.newWord();
        System.out.println("The Secret Word is:"+word);
        String s = new String();
        String let = new String();
        String spaces = new String();
        int x = 0;
        char c = ' ';
        boolean o = false;
        for(int i = 0; i < word.length(); i++){
            s += "-";
        }
        while(a>0){
            o = false;
            System.out.println("The Word is:"+s);
            System.out.println("Guesses Remaining: "+a);
            System.out.println("Please enter the letter you want to guess:");
            let = console.nextLine();
            if(let.length() == 0){
                System.out.println("No Letter Provided!");
                continue;
            }
            c = let.charAt(0);
            System.out.println("Please enter the spaces you want to check (separated by spaces):");
            spaces = console.nextLine();
            if(spaces.length() == 0){
                System.out.println("No Spaces Provided!");
                continue;
            }
            String[] space = spaces.split("\\s+");
            for(int i = 0; i < space.length; i++){
                x = Integer.parseInt(space[i]);
                if(word.charAt(x) == c){
                    s = s.substring(0,x)+c+s.substring(x+1,s.length()-1);
                    System.out.println(s);
                    o = true;
                }
            }
            if(o == false){
                System.out.print("Guess was not in the spaces provided!");
                a--;
            }
            if(s.equals(word)){
                System.out.println("You Guessed The Word!");
                break;
            }
        }
        if(a == 0){
            System.out.println("No Guesses Remaining!");
        }
    }
}
