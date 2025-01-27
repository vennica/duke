package parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A parser for datetime formatting. Any datetime format will be formatted
 * from "dd/MM/yyyy" to "MMM dd yyyy" in <code>DateTimeParser</code> .
 */
public class DateTimeParser {
    /*
    method to extract date from inputString and format it.
    find date matches format dd/mm/yyyy, which is a required format from user side,
    parse it to dd-MM-yyyy format
     */
    /**
     * Returns a date in "MMM dd yyyy" format string based on user input.
     * if date is not in "dd/MM/yyyy" format, method will return an empty string with a prompt
     * @param inputString datetime string input by the user.
     * @return date in "MMM dd yyyy" format and will be use in Tasklist.
     */
    public static String toDate(String inputString){
        String printedDate = " ";

        //need to check if the date fit into the format
        //compile regex format to match the expected result
        // input should be "dd/MM/yyyy"
        Pattern pattern = Pattern.compile("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[1,2])/((19|20)\\d\\d)");

        //create matcher to check if the string matches expected results
//        try {
//            Matcher matcher = pattern.matcher(inputString);
//        }catch (NullPointerException e){
//            System.out.println("please enter a Date (dd/MM/yyyy)!");
//        }

        Matcher matcher = pattern.matcher(inputString);



        //validate if the inputDate matches expected pattern
        if (matcher.find()){
            // Extract the matched date
            String inputDate = matcher.group();

            // Parse the extracted date
            //inputFormatter = inputFormatter.withLocale(Locale.getDefault() );
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate formattedDate = LocalDate.parse(inputDate, inputFormatter);


            //print date to MMM dd yyyy
            printedDate = formattedDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy")); // -> Example: Oct 15 2019
        }
        else {
            printedDate = inputString;
        }
        return printedDate;
    }

}
