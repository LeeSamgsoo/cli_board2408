package org.example;

import java.util.Scanner;

public class App {
    Scanner sc;
    App (Scanner sc) {
        this.sc =sc;
    }

    void run () {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            try {
                System.out.print("명령) ");
                String a = sc.nextLine();
                if ("종료".equals(a)) {
                    break;
                } else if ("등록".equals(a)) {
                    System.out.print("제목 : ");
                    String title = sc.nextLine();
                    System.out.print("내용 : ");
                    String content = sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
