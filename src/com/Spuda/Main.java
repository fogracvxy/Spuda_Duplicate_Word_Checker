//Spuda checker duplih rijeci
package com.Spuda;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class test {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int count;
        String stringInput;
        int exit = 0;
        while(true) {
            System.out.println("Enter words with space");
            stringInput = input.nextLine();

            //pretvaranje stringa u mala slova radi lakse usporedbe
            stringInput = stringInput.toLowerCase();

            //Razdvajanje stringa na rijeci
            String words[] = stringInput.split(" ");

            System.out.println("Duplicate words : ");
            for(int i = 0; i < words.length; i++) {
                count = 1;
                for(int j = i+1; j < words.length; j++) {
                    if(words[i].equals(words[j])) {
                        count++;
                        //stavljanje na 0 da se ne vraca na vec iste rijeci
                        words[j] = "0";
                    }
                }

                //prikazanje duplih rijeci ako je broj veci od 1
                if(count > 1 && words[i] != "0")
                    System.out.println(words[i]);
            }
            try
            {
                System.out.println("Want to turn off program? Type: 1");
                exit = input.nextInt();
            }
            catch(InputMismatchException exception)
            {
                System.out.println("This is not an integer");
            }
            input.nextLine();
            if (exit == 1){
                System.out.println("Gasim program za 3 sekunde");
                TimeUnit.SECONDS.sleep(3);
                break;
            } else {

                System.out.println("Enter words again:");
            }
        }
    }

}

