package com.santosh.practise.arrays;

import java.util.*;

/**
 * 2. You have ben given a task of reordering some data from a log file. In the log file every line is a space-delimited list of string, all lines begin with an alphanumeric identifier. There will be no lines consisteing of an identifier.
 * After the alphanumeric identifier a line will consist of either:
 * - a list of words using English Letters.
 * - or list of only integers
 * You have to reorder the data such that all thee lines with words are at the top if the log filee. The lines with words are ordered lexicographically, ignoring the identifier except in the case of ties. In the case of the ties(if there are two lines that are identical except for the identifier), the identifier is used to order lexicographically. Alphanumeric should be sorted ASCII order (numbers come before letters). The identifiers must still be part of the lines in the output strings. Lines with integers must be left in the original order they were in the file.
 * Write an algorithm to reorder the daya in the log file, according to the rules above.
 *
 * Input
 *  The input to the function consistes of two arguments -
 *  `logFileSize`, an integer representing the number of lines in the log file;
 *  `logLines`, a list of string representing the log file
 *
 *  Output
 *  Return a list of strings representing the reordered log file data
 *
 *  Note
 *  Identifiers consists of the only english letters and numbers
 *  The lines with words are not required to match case and sort needs to be case insensitive
 *
 *  Example:
 *  Input:
 *  logFileSize = 5
 *  logLines -
 *  [a1 9 2 3 1]
 *  [g1 Act car]
 *  [zo4 4 7]
 *  [ab1 off KEY dog]
 *  [a8 act zoo]
 *
 *  Output:
 *  [g1 Act car]
 *  [a8 act zoo]
 *  [ab1 off KEY dog]
 *  [a1 9 2 3 1]
 *  [z04 4 7]
 */
public class AmazonQuestion {
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("a1 alps cow bar");
        logs.add("mi2 jog mid pet");
        logs.add("wz3 34 54 398");
        logs.add("x4 45 21 7");

        List<String> result = reOrderLogs(logs);
        for(String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> reOrderLogs(List<String> logs) {
        List<String> result =  new ArrayList<>();
        List<LogModel> stringLines = new ArrayList<>();
        List<String> numberLines = new ArrayList<>();
        for(String line : logs) {
            LogModel obj = new LogModel();
            List<String> splits = Arrays.asList(line.split(" "));
            obj.identifier = splits.get(0);
            String remainingWord = line.substring(splits.get(0).length(), line.length());

            obj.remainingWords = remainingWord;

            if( (splits.get(1).charAt(0) >= 'a' && splits.get(1).charAt(0) <= 'z') || (splits.get(1).charAt(0) >= 'A' && splits.get(1).charAt(0) <= 'Z')) {
                stringLines.add(obj);
            } else {
                numberLines.add(line);
            }
        }

        // now we have sagregated the lines. Now we need to only sort the string line objects. we need a comparator.

        Comparator<LogModel> remainingWordsComparator = new Comparator<LogModel>() {
            @Override
            public int compare(LogModel o1, LogModel o2) {
                int diff =  o1.remainingWords.compareTo(o2.remainingWords);

                if(diff == 0) { // which means they are equal by their words, now compare with their identifier
                    int identifierDiff = o1.identifier.compareTo(o2.identifier);
                    if(identifierDiff == 0) {
                        // no issues return anything
                        return 0;
                    } else {
                        return identifierDiff;
                    }
                } else {
                    return diff;
                }
            }
        };

        Comparator<LogModel> newStyle = Comparator.comparing(LogModel::getRemainingWords).thenComparing(LogModel::getIdentifier);

        Collections.sort(stringLines, newStyle);
        for(LogModel obj : stringLines) {
            result.add(obj.identifier + " " + obj.remainingWords);
        }
        result.addAll(numberLines);
        return result;
    }
}

class LogModel {
    String identifier;
    String remainingWords;

    public String getIdentifier() {
        return identifier;
    }

    public String getRemainingWords() {
        return remainingWords;
    }
}
