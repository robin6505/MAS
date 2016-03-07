/*
 * Class containing all ridlle info
 */
package masriddle;

/**
 *
 * @author Robin
 */
public class Riddle {
    //all text needed in the dialog. dialogSection could be expended for more complex riddles
    private final String riddleP1 = "Albert and Bernard just become friends with Cheryl, and they want to know when her birthday is. \nCheryl gives them a list with 10 possible dates.";
    private final String riddleP2 = "Cheryl then tell Albert and Bernard separately the month and the day of her birthday respectively.";
    private final String riddleP3 = "So when is Cheryl's birthday?";
    
    private final String dialogA1 = "Albert: I don’t know when Cheryl’s birthday is, but I know that Bernard does not know too.";
    private final String dialogB1 = "Bernard: At first I don’t know when Cheryl’s birthday is, but I know now.";
    private final String dialogA2 = "Albert: Then I also know when Cheryl’s birthday is.";
    
    //List of months to convert month index to string
    String[] months = new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "okt", "nov", "dec"};
    
    //Variable containing all given dates in string format
    private String dates = "";
    
    //complete text of riddle
    private String riddleText;
    
    //Array with all dates. Set to 1 if date is in riddle.
    // For coding convenience we use a 12 by 31, else we need to built a
    //complicated array for every new set of dates
    int[][] possibleDates = new int[12][31];
    
    //constructor for Riddles
    Riddle() {
        setDates(); //Could change to give custom dates
        genDateText();  
        riddleText = riddleP1 + "\n\n"+ dates + "\n\n"+ riddleP2 + "\n\n" + dialogA1 + "\n" + 
                dialogB1 + "\n" + dialogA2 + "\n\n" + riddleP3;  
    }
      
    //set dates in possibleDates array
    private void setDates() { //Modify to make this variable on start
        possibleDates[4][15] = 1; possibleDates[4][16] = 1; possibleDates[4][19] = 1;
        possibleDates[5][17] = 1; possibleDates[5][18] = 1;
        possibleDates[6][14] = 1; possibleDates[6][16] = 1;
        possibleDates[8][14] = 1; possibleDates[8][15] = 1; possibleDates[8][17] = 1;
        
    }
    
    //generate Date Text for printing the riddle
    private void genDateText() {
        String generatedText = "";
        
        for (int i = 0; i < possibleDates.length; i++) {
            int monthFlag = 0;
            
            for (int j = 0; j < possibleDates[0].length; j++) {
                if (possibleDates[i][j] == 1) {
                    generatedText = (generatedText + (months[i] + " " + j +  "   "));
                    monthFlag = 1;
                }
            }
            if (monthFlag == 1) generatedText = generatedText + "\n";
        }
        
        dates = generatedText;
    }
    
    //Get full riddle text
    public String getRiddle() {
        return riddleText;
    }
    
    //Method to create riddle. Needed if we create more complex riddles
    //and add extra dialog lines. Not finished
    /*public String generateRiddle() {
        String genText = riddleP1 + "\n\n"+ dates + "\n\n"+ riddleP2 + "\n\n" + dialogA1 + "\n" + 
                dialogB1 + "\n" + dialogA2 + "\n\n" + riddleP3;
        
        return genText;
    }*/
    
}
