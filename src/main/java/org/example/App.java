package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc;
    static int boardCount = 1;
    ArrayList<Board> ba = new ArrayList<>();

    App(Scanner sc) {
        this.sc = sc;
    }


    void run() {
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

                    Board b = new Board(boardCount, title, content);
                    ba.add(b);
                    System.out.println(boardCount + "번 게시글이 등록되었습니다.");
                    boardCount++;
                } else if (a.equals("목록")) {
                    System.out.println("번호 / 제목 / 내용");
                    System.out.println("---------------------------");
                    int countIns = 0;
                    while (countIns < boardCount - 1) {
                        System.out.println(ba.get(countIns).getNumber() + " / " + ba.get(countIns).getTitle() + " / " + ba.get(countIns).getContent());
                        countIns++;
                    }

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
