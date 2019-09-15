package com.spm.projectws.service;

public class CalculateCtcService
{
    public int calculateCondionationalCS(final String value) {
        final String que1 = value;
        final String[] split;
        final String[] alphabets = split = que1.split("");
        for (final String alphabet : split) {
            System.out.print(alphabet);
        }
        int countIf = 0;
        int countAndAnd = 0;
        int countOrOr = 0;
        int countAnd = 0;
        int countOr = 0;
        try {
            for (int i = 0; i < alphabets.length && (que1.charAt(i) != '/' || que1.charAt(i + 1) != '/'); ++i) {
                if (que1.charAt(i) == 'i' && que1.charAt(i + 1) == 'f') {
                    ++countIf;
                }
                else if (que1.charAt(i) == '&' && que1.charAt(i + 1) == '&') {
                    ++countAndAnd;
                }
                else if (que1.charAt(i) == '|' && que1.charAt(i + 1) == '|') {
                    ++countOrOr;
                }
                else if (que1.charAt(i) == '&') {
                    if (que1.charAt(i) != '&' && que1.charAt(i + 1) != '&') {
                        ++countAnd;
                    }
                }
                else if (que1.charAt(i) == '|' && que1.charAt(i + 1) != '|' && que1.charAt(i) != '|' && que1.charAt(i + 1) != '|') {
                    ++countOr;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return countIf + countAnd + countOrOr + countAnd + countOr;
    }
    
    public int calculateIteratice(final String value) {
        final String que1 = value;
        final String[] alphabets = que1.split("");
        int countFor = 0;
        int countWhile = 0;
        final int countDoWhile = 0;
        try {
            for (int i = 0; i < alphabets.length && (que1.charAt(i) != '/' || que1.charAt(i + 1) != '/'); ++i) {
                if (que1.charAt(i) == 'f' && que1.charAt(i + 1) == 'o' && que1.charAt(i + 2) == 'r' && que1.charAt(i + 3) == '(') {
                    countFor += 2;
                }
                else if (que1.charAt(i) == 'f' && que1.charAt(i + 1) == 'o' && que1.charAt(i + 2) == 'r' && que1.charAt(i + 3) == ' ' && que1.charAt(i + 4) == '(') {
                    countFor += 2;
                }
                else if (que1.charAt(i) == 'w' && que1.charAt(i + 1) == 'h' && que1.charAt(i + 2) == 'i' && que1.charAt(i + 3) == 'l' && que1.charAt(i + 4) == 'e' && que1.charAt(i + 5) == '(') {
                    countWhile += 2;
                }
                else if (que1.charAt(i) == 'c' && que1.charAt(i + 1) == 'a' && que1.charAt(i + 2) == 't' && que1.charAt(i + 3) == 'c' && que1.charAt(i + 4) == 'h' && que1.charAt(i + 5) == '(') {
                    countWhile += 2;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return countFor + countWhile;
    }
    
    public int calculateProgramStatements(final String value) {
        final String que1 = value;
        final String[] alphabets = que1.split("");
        int countCatch = 0;
        int countCases = 0;
        try {
            for (int i = 0; i < alphabets.length && (que1.charAt(i) != '/' || que1.charAt(i + 1) != '/'); ++i) {
                if (que1.charAt(i) == 'c' && que1.charAt(i + 1) == 'a' && que1.charAt(i + 2) == 't' && que1.charAt(i + 3) == 'c' && que1.charAt(i + 4) == 'h' && que1.charAt(i + 5) == '(') {
                    ++countCatch;
                }
                else if (que1.charAt(i) == 'c' && que1.charAt(i + 1) == 'a' && que1.charAt(i + 2) == 's' && que1.charAt(i + 3) == 'e') {
                    ++countCases;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return countCatch + countCases;
    }
}