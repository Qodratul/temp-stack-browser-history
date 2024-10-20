package com.github.affandes.kuliah.pm;

import java.util.Stack;
import java.util.Scanner;

public class BrowserHistory {
    private Stack<String> historyStack;

    public BrowserHistory() {
        historyStack = new Stack<>();
    }

    public void browse(String website) {
        historyStack.push(website);
        System.out.println("Browsing: " + website);
    }

    public void back() {
        if (!historyStack.isEmpty()) {
            String lastWebsite = historyStack.pop();
            System.out.println("Back: Removed " + lastWebsite);
        } else {
            System.out.println("There is no more history to go back to.");
        }
    }

    public void view() {
        if (historyStack.isEmpty()) {
            System.out.println("No more history.");
        } else {
            System.out.println("Recent web history:");
            for (int i = historyStack.size() - 1; i >= 0; i--) {
                System.out.println(historyStack.get(i));
            }
        }
    }
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\n(1) Browse | (2) Back | (3) View | (4) Exit");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter website URL: ");
                    String website = sc.nextLine();
                    browserHistory.browse(website);
                    break;
                case "2":
                    browserHistory.back();
                    break;
                case "3":
                    browserHistory.view();
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid, please try again.");
            }
        }
    }
}
