package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import src.Meal;

public class FileParser{
  
  private String path;
  private ArrayList<Meal> lmeal ;
  private String year;
  private String month;
  
  public FileParser(String i_path, String i_year, String i_month) {
    path= i_path;
    lmeal = new ArrayList<Meal>();
    year = i_year;
    // the month must use 2 digits
    NumberFormat fmt = new DecimalFormat("00");
    month = fmt.format(Integer.parseInt(i_month));
  }
  
  
  public void parseFile () throws IOException,ArrayIndexOutOfBoundsException {
   String lineText = null;
   int line = 0;
   String day = "-1";
   String[] tokens;

   BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(path), "windows-1252") );

    while( ( lineText = br.readLine() ) != null && lineText.length() > 0 ){
        tokens = lineText.split("A:|J:");
        if(tokens.length < 3)
            throw new ArrayIndexOutOfBoundsException();
        NumberFormat fmt = new DecimalFormat("00");
        day = fmt.format(Integer.parseInt(tokens[0]) );
        //removing the last character ( '/' )
        String lunch = tokens[1].substring(0, tokens[1].length() - 1);
        this.lmeal.add(new Meal(lunch, true, year, month, day));
        
        this.lmeal.add( new Meal( tokens[2], false, year, month, day));
    }
  }
  
  //get the meals, parsed for the events
  public List<Meal> getParsedMeals() throws IOException, ArrayIndexOutOfBoundsException{
    parseFile();
    return lmeal;
  }

  public String getPath() {
    return path;
  }



  public void setPath(String path) {
    this.path = path;
  }



  public ArrayList<Meal> getLmeal() {
    return lmeal;
  }



  public void setLmeal(ArrayList<Meal> lmeal) {
    this.lmeal = lmeal;
  }
  
}