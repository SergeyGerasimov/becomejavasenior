package ua.dobro;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String loginName = scan.nextLine();
        if (checkUserNameRegex(loginName)) {
            System.out.println("Good!");
        } else {
            System.out.println("You can use only letters, numbers and '_' for your login name!");
        }
        scan.close();
    }

    public static boolean checkUserNameRegex(String login) {
        return Pattern.matches("^[\\w_]{4,16}$", login);
        // internationalized solution
        // String userNamePattern = "^[\\w_]{4,16}$";
        // Pattern pattern = Pattern.compile(userNamePattern,
        // Pattern.UNICODE_CHARACTER_CLASS);
        // Matcher matcher = pattern.matcher(login);
        // return matcher.matches();
    }

    public static boolean checkUserName(String login) {
        if (login.length() < 4 || login.length() > 16) {
            return false;
        }
        for (char ch : login.toCharArray()) {
            if (ch == '_') {
                continue;
            }
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                continue;
            }
            return false;
        }
        return true;
        // internationalized solution
        // if (login.length() < 4 || login.length() > 16) {
        // return false;
        // }
        // for (char ch : login.toCharArray()) {
        // if (!Character.isLetterOrDigit(ch) && ch != '_') {
        // return false;
        // }
        // }
        // return true;
    }
}
