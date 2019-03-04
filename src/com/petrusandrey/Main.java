package com.petrusandrey;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@test.com",
                "test.e.mail+bob.cathy@test.com",
                "testemail+david@lee.test.com"};
        System.out.println(Arrays.toString(emails));
        System.out.println(numUniqueEmails(emails));

    }

    public static int numUniqueEmails(String[] emails) {
        StringBuilder strib = new StringBuilder();
        HashSet<String> setEmails = new HashSet<>();

        for (String email : emails) {
            boolean deleteNext = false;
            strib.append(email);
            for (int i = 0; i < strib.length(); i++) {
                if (strib.charAt(i) == '@') {
                    break;
                } else if (strib.charAt(i) == '.') {
                    strib.deleteCharAt(i);
                } else if (strib.charAt(i) == '+') {
                    deleteNext = true;
                }
                if (deleteNext) {
                    strib.deleteCharAt(i);
                    i--;
                }
            }
            setEmails.add(strib.toString());
            strib.delete(0, strib.length());
        }
        return setEmails.size();
    }
}


