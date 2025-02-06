package Basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Create a formatter for "MMMM yyyy" (e.g., January 2025)
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");

        // Print the current month
        String formattedDate1 = currentDate.format(monthYearFormatter);
        String formattedDay = currentDate.format(dayFormatter);
        
        System.out.println("\"" + formattedDate1 + "\", \"" + formattedDay + "\"");
        
        // Get the 3rd month from now
        LocalDate thirdMonth = currentDate.plusMonths(3);
        String formattedThirdMonth = thirdMonth.format(monthYearFormatter);
        String formattedThirdDay = thirdMonth.format(dayFormatter);
        System.out.println(formattedThirdDay);
    }
}
