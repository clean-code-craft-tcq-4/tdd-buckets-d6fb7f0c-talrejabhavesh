
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrentReading{
  
  
  public static String processReadings(List<Integer> currentReadings) {
    List<Integer> rangelist = new ArrayList<>();
    String outputMessage = "";
    Collections.sort(currentReadings);
    rangelist.add(currentReadings.get(0));
    for (int i = 1; i < currentReadings.size(); i++) {

      outputMessage = detectRanges(currentReadings, rangelist, i, outputMessage);

      outputMessage = checkForLastReading(currentReadings, rangelist, i, outputMessage);
      
    }
    return outputMessage.trim();
  }

  

  public static String formMessage(String message, List<Integer> range) {
    return message + range.get(0).toString() + "-" + range.get(range.size() - 1).toString() + "," + range.size() + "\n";
  }

 
  
  public static void clearList(List<Integer> currentReadings, List<Integer> range, int index) {
    range.clear();
    range.add(currentReadings.get(index));
  }

 
  
  public static String detectRanges(List<Integer> currentReadings, List<Integer> rangeList, int index, String message) {
    String localMessage = message;
    if (currentReadings.get(index).equals(currentReadings.get(index - 1)) ||
        currentReadings.get(index).equals(currentReadings.get(index - 1) + 1)) {
      rangeList.add(currentReadings.get(index));
    }
    else if (rangeList.size() > 1) {
      localMessage = formMessage(message, rangeList);
      clearList(currentReadings, rangeList, index);
    }
    else {
      clearList(currentReadings, rangeList, index);
    }
    return localMessage;
  }


  
  public static String checkForLastReading(List<Integer> currentReadings, List<Integer> rangeList, int index,
      String message) {
    String localMessage = message;
    if (index == currentReadings.size() - 1 && rangeList.size() > 1) {
      localMessage = formMessage(message, rangeList);
      clearList(currentReadings, rangeList, index);
    }
    return localMessage;
  }
  
}
