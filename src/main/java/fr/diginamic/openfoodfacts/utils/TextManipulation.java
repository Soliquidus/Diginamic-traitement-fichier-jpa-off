package fr.diginamic.openfoodfacts.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Main text manipulations like String converter to Double type.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class TextManipulation {

    /**
     * Convert to double a String if it contains a number.
     *
     * @param string the string
     * @return the double
     */
    public static Double convertToDouble(String string) {
        if (NumberUtils.isCreatable(string)) {
            return Double.parseDouble(string);
        }
        return null;
    }

    /**
     * Always put the first letter of a String to upper case and the rest to lower case.
     *
     * @param string the string
     * @return the string
     */
    public static String firstLetterToUpperCase(String string) {
        return string.toUpperCase().charAt(0) + string.toLowerCase().substring(1);
    }

    /**
     * Split a string in order to get a list and suppress useless data like
     * special chars, parenthesis, accents...
     *
     * @param string the string to split
     * @return the list of String
     */
    public static List<String> splitString(String string) {

        String toSplit = string.toLowerCase();
        //Special chars
        toSplit = toSplit.replaceAll("[_\\*'/\\?\\+=]*", "").trim();
        //Parenthesis
        toSplit = toSplit.replaceAll("\\(.*?\\)", "").replaceAll("[\\(\\)\\[\\]]", "");
        //Accents
        toSplit = toSplit.replaceAll("[éèê]", "e").replaceAll("à", "a").trim();
        //Percents
        toSplit = toSplit.replaceAll("[0-9]*\\s*%", "").trim();
        //Numerations
        toSplit = toSplit.replaceAll("[0-9]*\\.*", "").trim();

        return splitStr(toSplit);
    }

    /**
     * Split a String with , ; or : parameters.
     *
     * @param string the string to split
     * @return the list of String
     */
    private static List<String> splitStr(String string) {

        if (string == null || string.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> list = new ArrayList<>();
        String[] parts = string.split("[,;:]");
        for (String part : parts) {
            String stringToTreat = part.trim();
            if (!stringToTreat.isEmpty()) {
                stringToTreat = firstLetterToUpperCase(stringToTreat);
                list.add(stringToTreat);
            }
        }
        return list;
    }
}