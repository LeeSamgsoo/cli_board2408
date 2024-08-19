package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    Scanner sc;
    static int boardCount = 0;
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> contents = new ArrayList<>();
    App (Scanner sc) {
        this.sc =sc;
    }

    void run () {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            try {
                System.out.print("명령) ");
                String a = sc.nextLine().trim();
                if (a.equals("종료")) {
                    break;
                } else if (a.equals("등록")) {
                    System.out.print("제목 : ");
                    String title = sc.nextLine();
                    System.out.print("내용 : ");
                    String content = sc.nextLine();
                    boardCount++;
                    titles.add(title);
                    contents.add(content);
                    System.out.println(boardCount + "번 게시글이 등록되었습니다.");
                } else if (a.equals("목록")) {
                    System.out.println("번호 / 제목 / 내용");
                    System.out.println("---------------------------");
                    int countIns = 0;
                    while (countIns < boardCount) {
                        System.out.println((countIns + 1) + " / " + titles.get(countIns) + " / " + contents.get(countIns));
                        countIns++;
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
