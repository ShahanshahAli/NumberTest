package org.example;

public class NumberToWord /*Ok Ey */{


    private static final String[] SINGLES = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] TWINS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] TRICE = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};


    public String convert(int input) {

        if(input < 0) {
            throw new RuntimeException("Number Can not be negative :"+ input);
        }

        if(input < 10) { // till 9
            return SINGLES[input];
        } else if(input < 100) { // till 99
            int remind = input % 10;
            if(remind == 0) // If it is one of the multiple of 10.
                return TWINS[input / 10];
            else if( input > 20 ) {
                return convert(input - (remind)) + " " + convert(remind);
            }
            else
                return TRICE[input - 10];
        } else if(input < 1000) { // till 999
            int remind = input % 100;
            int result = input / 100;
            return convert(result) + " hundred" + convertRemind(remind);
        } else if(input < 1000000) { // till 999 999
            int remind = input % 1000;
            int result = input / 1000;
            return convert(result) + " thousand" + convertRemind(remind);
        } else if(input < 1000000000) { //till 999 999 999
            int remind = input % 1000000;
            int result = input / 1000000;
            return convert(result) + " million" + convertRemind(remind);
        }

        else {
            throw new RuntimeException("Invalid Number :" + input);
        }
    }

    private String convertRemind(int input) {
        if(input > 0) {
            return getWithAnd(input) + " "+ convert(input);
        } else
            return "";
    }

    private String getWithAnd(int input) {
        if(input < 100) {
            return " and";
        } else {
            return "";
        }
    }
}
