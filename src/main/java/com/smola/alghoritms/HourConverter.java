package com.smola.alghoritms;

public class HourConverter {
    String convert(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String lastTwoChars = s.substring(s.length() - 2);
        String firstTwoNumbers = s.substring(0, 2);
        int i = Integer.valueOf(firstTwoNumbers) %12;
        if (lastTwoChars.equalsIgnoreCase("AM")) {
            return String.valueOf(stringBuilder.append(0).append(i).append(s, 2, s.length()-2));
        } else {
            if (i == 0){
                return String.valueOf(stringBuilder.append(firstTwoNumbers).append(s, 2, s.length()-2));
            }
            return String.valueOf(stringBuilder.append(Integer.valueOf(firstTwoNumbers) +12).append(s, 2, s.length()-2));
        }

    }
}
