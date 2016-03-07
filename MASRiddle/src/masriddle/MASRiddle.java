/*
 * Program for the course Multi-Agent Systems
 * The program solves and explains the Cheryl's Birthday Riddle
 */
package masriddle;

public class MASRiddle {

    /**
     * @param args the command line arguments
     */
    private static String printDates(int[][] possibleDates, Riddle a) {
        String generatedText = "";
        
        for (int i = 0; i < possibleDates.length; i++) {
            int monthFlag = 0;
            
            for (int j = 0; j < possibleDates[0].length; j++) {
                if (possibleDates[i][j] == 1) {
                    generatedText = (generatedText + (a.months[i] + " " + j + " | "));
                    monthFlag = 1;
                }
            }
            if (monthFlag == 1) generatedText = generatedText + "\n";
        }
        
        return generatedText;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        //Create Riddle
        Riddle first = new Riddle();
        
        //Print Riddle
        System.out.println(first.getRiddle());
        
        //Create Agent for the Reader
        Reader agentR = new Reader(first.possibleDates);
        
        System.out.print("\n TESTING GIVEN DATES \n");
        System.out.print(printDates(first.possibleDates, first));
        
        System.out.print("\n TESTING READER KNOWLEDGE \n");
        System.out.print(printDates(agentR.possibleDates, first));
        
    }
    
}
