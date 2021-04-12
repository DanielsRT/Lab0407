import java.util.*;
import java.io.*;

public class Lab0407 {

    static Random rand = new Random();
    static ArrayList<String> courses = new ArrayList<String>();
    static ArrayList<String> titles = new ArrayList<String>();
    static ArrayList<String> stages = new ArrayList<String>();
    static ArrayList<String> areas = new ArrayList<String>();
    static ArrayList<String> hours = new ArrayList<String>();

    public static void main(String[] args) {


        // Remember that this is a 200-point lab and is due by Sunday, April 18th at 11:59pm.



        // TODO 1 (20 points) - The file "courses.txt" has 5 columns.  Create and call a function
        // that given a file name and a column number, returns an ArrayList of Strings with the
        // values from that column of data.  For example, if the column number is 2 then an
        // ArrayList of titles will be returned.  If the column number is 5 then an ArrayList of
        // credit hours (stored as Strings) will be returned.  Call this function 5 times to create
        // the 5 ArrayLists for each of the columns of data.
        courses = getColumnData("courses.txt", 1);
        titles = getColumnData("courses.txt", 2);
        stages = getColumnData("courses.txt", 3);
        areas = getColumnData("courses.txt", 4);
        hours = getColumnData("courses.txt", 5);
        

        // TODO 2 (20 points) - Create and call a user-defined function that given two indexes,
        // swaps the data for those two courses.  For example, if the two indices are 0 and 1, then
        // the first two courses in the ArrayLists must be exchanged.
        swapCourseData(0, 1);

        // TODO 3 (20 points) - The real fun of this project is to make it easy for users to rate
        // XCore courses.  These ratings are for reading, writing, thinking,and fun.  For each of
        // the courses, randomly generate 4 ratings in the range 0..6. The 4 ratings must be stored
        // in an array.  Don't write a function for this, do this in main().
        int[][] crseRatings = new int[courses.size()][4];
        for (int ndx = 0; ndx < courses.size(); ndx++) {
            crseRatings[ndx][0] = rand.nextInt(7); // reading rating
            crseRatings[ndx][1] = rand.nextInt(7); // writing rating
            crseRatings[ndx][2] = rand.nextInt(7); // thinking rating
            crseRatings[ndx][3] = rand.nextInt(7); // fun rating
        }


        // TODO 4 (20 points) - Write a function that returns an ArrayList of titles for all
        // courses that have an {X} fun rating where X is a parameter to this function.
        ArrayList<String> funParameterTitles = getTitlesThatMeetParameter(crseRatings, 5);
        System.out.println(funParameterTitles);

        // TODO 5 (20 points) - What are the titles of courses with the sum of ratings at least {X}
        // where X is a parameter to this function.



    }

    // TODO 1 - ArrayList<String> courses = getColumnData("courses.txt", 2);
    public static ArrayList<String> getColumnData(String filename, int columnNumber) {
        ArrayList<String> ColumnData = new ArrayList<>();
        columnNumber -= 1;
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\\|");
                ColumnData.add(parts[columnNumber]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ColumnData;
    }

    // TODO 2 - swapCourseData(0, 1);
    public static void swapCourseData(int ndx1, int ndx2) {
        String temp;
        
        temp = courses.get(ndx1);
        courses.set(ndx1, courses.get(ndx2));
        courses.set(ndx2, temp);

        temp = titles.get(ndx1);
        titles.set(ndx1, titles.get(ndx2));
        titles.set(ndx2, temp);

        temp = stages.get(ndx1);
        stages.set(ndx1, stages.get(ndx2));
        stages.set(ndx2, temp);

        temp = areas.get(ndx1);
        areas.set(ndx1, areas.get(ndx2));
        areas.set(ndx2, temp);

        temp = hours.get(ndx1);
        hours.set(ndx1, hours.get(ndx2));
        hours.set(ndx2, temp);
    }

    // TODO 4 - ArrayList<String> funParameterTitles = getTitlesThatMeetParameter(5);
    public static ArrayList<String> getTitlesThatMeetParameter(int[][] crseRatings, int paramter) {
        ArrayList<String> selectedTitles = new ArrayList<>();
        for (int ndx = 0; ndx < courses.size(); ndx++) {
            if (crseRatings[ndx][3] == paramter) {
                selectedTitles.add(titles.get(ndx));
            }
        }
        return selectedTitles;
    }
}