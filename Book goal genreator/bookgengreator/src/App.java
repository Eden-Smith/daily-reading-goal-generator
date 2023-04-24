import java.util.Scanner;

import Objects.book;

public class App {
    public static void main(String[] args) throws Exception {
        //intialize and declare scanner
        Scanner kb = new Scanner(System.in);

        //find daily reading goal
        System.out.println("What is your dialy reading goal?");
        int goal = kb.nextInt();
        System.out.println(goal);

        //determine books in rotation
        System.out.println("How many books?");
        int numOfBooks = kb.nextInt();
        book[] booksInRotation = new book[numOfBooks];


        //adds the books to the book array
        for(int i = 0; i < numOfBooks; i++) {
            System.out.println("Whats the info for book #" + String.valueOf(i+1) + "?");
            booksInRotation[i] = addBooks(kb);
        }

        //chooses book
        int bookChosen = (int) (Math.random() * numOfBooks);
        System.out.println(("The book chosen is " + booksInRotation[bookChosen].getMyTitle() + "."));

        determineGoals(kb, goal, booksInRotation[bookChosen]);


        //closes scanner
        kb.close();
    }

    //static method to create books
    public static book addBooks(Scanner kb) {
        kb.nextLine();

        //find out info for books
        System.out.println("Title?");
        String title = kb.nextLine();
        System.out.println("Last page?");
        int page = kb.nextInt();
        kb.nextLine();
        System.out.println("Author?");
        String author = kb.nextLine();
        System.out.println("How many chapters?");
        int numOfChapters = kb.nextInt();
        int[] chapters = new int[numOfChapters];

        //find each chapters page number
        for(int i = 0; i < numOfChapters; i++) {
            System.out.println("What page does chapter " + String.valueOf(i+1) + " end on?");
            chapters[i] = kb.nextInt();
        }

        //create book for return
        book book = new book(title, page, author, chapters);
        return book;
    }

    // this determines dialy goals based off a page goal given and the chapter page numbres provided
    public static void determineGoals(Scanner kb, int goal, book book) {
        int day = 1;
        int lastPageRead = 0;
        System.out.println(book.toString());

        //runs through the chapter of the book
        for(int i = 0; i < book.getMyChapters().length; i++) {

            //only accepts cahpters that are not the final chapter and have ends less thanir equal to page goal
            if((i+1) < book.getMyChapters().length) {
                if((book.getMyChapters()[i+1] - (lastPageRead + goal) >= 0)) {
                    System.out.println(day + ": read to the end of chapter " +  String.valueOf(i+1));
                    lastPageRead += goal;
                    day++;
                }  
            }else if((i+1) == book.getMyChapters().length) {//only runs at the last chapter
                System.out.println(day + ": read to the end of chapter " + String.valueOf(i+1));
            } else {//bug fixing neeeded if this runs
                System.out.println("something went wrong");
            }
        }

    } 
}
