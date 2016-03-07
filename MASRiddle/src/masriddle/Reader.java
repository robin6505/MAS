/*
 * Description of the Reader agent class
 */
package masriddle;

public class Reader {
    int[][] possibleDates;
    
    Reader(int[][] posDates) {
        this.possibleDates = copyDates(posDates);
        this.possibleDates[0][0] = 1;
        
    }
    
    //Need to copy array or else it will point to the same array
    //Keep table size hardcoded as this size never changes
    //and makes it more readable
    private int[][] copyDates(int[][] posDates) {
        int[][] copiedDates = new int[12][31];
        
        for(int i = 0; i < 12; i++)
            copiedDates[i] = posDates[i].clone();
        
        return copiedDates;
    }
}
