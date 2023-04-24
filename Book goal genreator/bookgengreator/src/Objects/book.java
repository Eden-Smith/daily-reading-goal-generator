package Objects;

import java.util.Arrays;

public class book {



    //variables
    private String myTitle;
    private int myLastPage;
    

    private String myAuthor; //maybe make this a separate obj
    private int[] myChapters; //maybe make this a separate obj


    public book(String myTitle, int myLastPage, String myAuthor, int[] myChapters) {
        this.myTitle = myTitle;
        this.myLastPage = myLastPage;
        this.myAuthor = myAuthor;
        this.myChapters = myChapters;
    } //posssibly add a defualt constructor and defualt values


    public String getMyTitle() {
        return myTitle;
    }


    public void setMyTitle(String myTitle) {
        this.myTitle = myTitle;
    }


    public int getMyLastPage() {
        return myLastPage;
    }


    public void setMyLastPage(int myLastPage) {
        this.myLastPage = myLastPage;
    }


    public String getMyAuthor() {
        return myAuthor;
    }


    public void setMyAuthor(String myAuthor) {
        this.myAuthor = myAuthor;
    }


    public int[] getMyChapters() {
        return myChapters;
    }


    public void setMyChapters(int[] myChapters) {
        this.myChapters = myChapters;
    }


    @Override
    public String toString() {
        return "book [myTitle=" + myTitle + ", myLastPage=" + myLastPage + ", myAuthor=" + myAuthor + ", myChapters="
                + Arrays.toString(myChapters) + "]";
    }    
    
}
