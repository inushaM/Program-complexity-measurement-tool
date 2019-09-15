package com.spm.projectws.service;

public class CalculateCncService
{
    public int calculateCondionationalCS(final String value) {
        final String que1 = value;
        int countIf = 0;
        int countReturn = 0;
        int countFor = 0;
        final String[] split;
        final String[] alphabets = split = que1.split("");
        for (final String alphabet : split) {
            System.out.print(alphabet);
        }
        try {
            for (int i = 0; i < alphabets.length && (que1.charAt(i) != '/' || que1.charAt(i + 1) != '/'); ++i) {
                if (que1.charAt(i) == 'i' && que1.charAt(i + 1) == 'f') {
                    ++countIf;
                }
                else if (que1.charAt(i) == 'r' && que1.charAt(i + 1) == 'e' && que1.charAt(i + 2) == 't' && que1.charAt(i + 3) == 'u' && que1.charAt(i + 4) == 'r' && que1.charAt(i + 5) == 'n') {
                    ++countReturn;
                }
                else if (que1.charAt(i) == 'f' && que1.charAt(i + 1) == 'o' && que1.charAt(i + 2) == 'r' && que1.charAt(i + 3) == ' ' && que1.charAt(i + 4) == '(') {
                    countFor += 2;
                }
                else if (que1.charAt(i) == 'f' && que1.charAt(i + 1) == 'o' && que1.charAt(i + 2) == 'r' && que1.charAt(i + 3) == '(') {
                    ++countFor;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("if " + countIf);
        return countIf + countReturn + countFor;
    }
}