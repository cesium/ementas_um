package src;

public class Meal {

	
	private String description;
	private boolean is_lunch;
	private String year, month, day ;
	
	
	
	public Meal(String description, boolean is_lunch , String year,
			String month, String day) {
		this.description = description;
		this.is_lunch = is_lunch;
		this.year = year;
		this.month = month;
		this.day = day;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getMonth() {
		return month;
	}



	public void setMonth(String month) {
		this.month = month;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}
	


	public String getMealStartTime(){
		if (this.is_lunch)
			return "T12:00:00" ;
		else
			return "T19:00:00" ;
		
	}
	
	public String getMealEndTime(){
		if (this.is_lunch)
			return "T13:00:00" ;
		else
			return "T20:00:00" ;
		
	}
	
	public boolean is_lunch(){
		return this.is_lunch;
	}
	
}
