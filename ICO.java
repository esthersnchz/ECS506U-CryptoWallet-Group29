import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Main {
  private static List<List<String>> table; 

  public static void main(String[] args) {
    initTable();
    int spacing = 3;
    printTable(spacing);
  }

  private static void initTable() {
    List<String> row1 = Arrays.asList("ICO Name", "AI TECH", "Veritise", "Cryptocurrency Network (CCN)", "STREAM COIN", "XCAVATOR (XCA)", "RastaSwap" ,"TETRIX TOKEN", "Lucrosus Capital", "VAYU DeFI Ecosystem", "MYCRYPTOCITY");
    List<String> row2 = Arrays.asList("Sale Start", "Nov 18,2021", "Sep 3,2021", "March 14,2021", "Feb 1,2022", "Mar 23,2022", "Dec 21,2021", "Aug 1,2021", "Jan 17,2022", "Mar 16,2022", "Mar 15,2022");
    List<String> row3 = Arrays.asList("Sale End", "Apr 30,2022", "Sep 30,2022", "May 5,2022", "Apr 30,2022", "May 8,2022", "Apr 15,2022", "Jul 31,2022", "Apr 30,2022", "Apr 15,2022", "Apr 3,2022");
    List<String> row4 = Arrays.asList("Rating", "9.9", "9.8", "9.7", "9.6", "9.5", "9.4", "9.4", "9.3", "9.2", "9.0");
    table = Arrays.asList(row1, row2, row3, row4);
  }

  private static void printTable(int spacing) {
    List<Integer> maxLengths = findMaxLengths();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < table.get(0).size(); i++) {
      for (int j = 0; j < table.size(); j++) {
        String currentValue = table.get(j).get(i);
        sb.append(currentValue);
        for (int k = 0; k < (maxLengths.get(j) - currentValue.length() + spacing); k++) {
          sb.append(' ');
        }
      }
      sb.append('\n');
    }
    System.out.println();
    System.out.println("ICO Recommendations \n");
    System.out.println("An ICO (Initial Coin Offerings) is another form of \ncryptocurrency that businesses use in order to raise capital. ");
    System.out.println("Through ICO trading platforms, investors receive unique \ncryptocurrency “tokens” in exchange for their monetary \ninvestment in the business.");
    System.out.println();
    System.out.println("Here are the current top 10 ICOs\n(Ratings provided by icolistingonline.com)");
    System.out.println();
    System.out.println(sb);
    System.out.println();
    System.out.println("*Be aware this is not investment advice*\n*Please be aware of the consequences of investing*\n*Make sure you do your research*");
  }

  private static List<Integer> findMaxLengths() {
    List<Integer> maxLengths = new ArrayList<>();
    for (List<String> row : table) {
      int maxLength = 0;
      for (String value : row) {
        if (value.length() > maxLength) {
          maxLength = value.length();
        }
      }
      maxLengths.add(maxLength);
    }
    return maxLengths;
  }
}