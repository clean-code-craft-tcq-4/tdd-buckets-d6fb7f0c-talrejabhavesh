import org.junit.Test;



public class CurrentReadingTest{
 
 @Test 
 public static void testCurrentRanges() {
    List<Integer> currentReadings= Arrays.asList(2,3,2,5,6,9,8,8,10);
    String output= CurrentReadings.processReadings(currentReadings);
    assertTrue(output.equals("2-3,3\n5-6,2\n8-10,4"));
   
   
  @Test  
  public static void testCurrentRangesWith12bit() {
    List<Integer> bitReadings= Arrays.asList(409,1228,2048,2457,3686,3277,3277,4094);
    List<Integer> currentReadings=  CurrentReadings.convert12BitToAmps(bitReadings);
    String output= CurrentReadings.processReadings(currentReadings);
    assertTrue(output.equals("5-6,2\n8-10,4"));
    }

   @Test 
  public static void testConvertRanges12bit() {
    List<Integer> bitReadings= Arrays.asList(409,820,1228);
    assertTrue(CurrentReadings.convert12BitToAmps(bitReadings).equals(Arrays.asList(1,2,3)));

  }
   
 @Test  
  public static void testConvertRanges10bit() {
    List<Integer> bitReadings= Arrays.asList(1022,10,545,477,100); 
    assertTrue(CurrentReadings.convert10BitToAmps(bitReadings).equals(Arrays.asList(15, -15, 1, -1, -12)));
  }
  
  @Test 
   public static void testCurrentRangesWith10bit() {
    List<Integer> bitReadings= Arrays.asList(545,579,579,613,477,715,749,273);
    List<Integer> currentReadings=  CurrentReadings.convert10BitToAmps(bitReadings);
    String output= CurrentReadings.processReadings(currentReadings);
    assertTrue(output.equals("1-3,5\n6-7,3"));

  }
  
}
