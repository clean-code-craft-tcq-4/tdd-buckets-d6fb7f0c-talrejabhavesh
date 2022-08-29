import org.junit.Test;



public class CurrentReadingTest{
  /**
   * @param args
   */
  public static void main(String[] args) {
   
    testCurrentRanges();

  }
  
 public static void testCurrentRanges() {
    List<Integer> currentReadings= Arrays.asList(2,3,2,5,6,9,8,8,10);
    String output= CurrentReadings.processReadings(currentReadings);
    assertTrue(output.equals("2-3,3\n5-6,2\n8-10,4"));
}
