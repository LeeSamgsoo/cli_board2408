package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc;
    int boardCount = 0;
    ArrayList<Board> ba = new ArrayList<>();

    App(Scanner sc) {
        this.sc = sc;
    }

    void boardInsert() {
        System.out.print("제목 : ");
        String title = sc.nextLine();
        System.out.print("내용 : ");
        String content = sc.nextLine();

        boardCount++;
        Board b = new Board(boardCount, title, content);
        ba.add(b);
        System.out.println(boardCount + "번 게시글이 등록되었습니다.");
    }

    void boardShow() {
        if (boardCount == 0) {
            System.out.println("게시물이 존재하지 않습니다.");
        } else {
            System.out.println("번호 / 제목 / 내용");
            System.out.println("---------------------------");
            int countIns = boardCount - 1;
            while (countIns >= 0) {
                System.out.println(ba.get(countIns).getNumber() + " / " + ba.get(countIns).getTitle() + " / " + ba.get(countIns).getContent());
                countIns--;
            }
        }
    }

    void boardDelete(int delIndex) {
        if (boardCount == 0) {
            System.out.println("게시물이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < ba.size(); i++) {
                if (ba.get(i).getNumber() == delIndex) {
                    ba.remove(i);
                    System.out.println(delIndex + "번 게시물이 삭제되었습니다.");
                    boardCount--;
                    break;
                } else if (ba.size() - 1 == i) {
                    System.out.println("존재하지 않는 게시물 입니다.");
                }
            }
        }
    }

    void boardModify(int modIndex) {
        if (boardCount == 0) {
            System.out.println("게시물이 존재하지 않습니다.");
        } else {
            for (int i = 0; i < ba.size(); i++) {
                if (ba.get(i).getNumber() == modIndex) {
                    System.out.println("제목(기존) : " + ba.get(i).getTitle());
                    System.out.print("제목 : ");
                    ba.get(i).setTitle(sc.nextLine());
                    System.out.println("내용(기존) : " + ba.get(i).getContent());
                    System.out.print("내용 : ");
                    ba.get(i).setContent(sc.nextLine());
                    System.out.println(modIndex + "번 게시물이 수정되었습니다.");
                    ba.addLast(ba.get(i));
                    ba.remove(i);
                    break;
                } else if (ba.size() - 1 == i) {
                    System.out.println("존재하지 않는 게시물 입니다.");
                }
            }
        }
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
                    boardInsert();
                } else if (a.equals("목록")) {
                    boardShow();
                } else if (a.startsWith("삭제?id=")
                        && !a.replace("삭제?id=", "").isBlank()) {
                    boardDelete(Integer.parseInt(a.replace("삭제?id=", "")));
                } else if (a.startsWith("수정?id=")
                        && !a.replace("수정?id=", "").isBlank()) {
                    boardModify(Integer.parseInt(a.replace("수정?id=", "")));
                } else {
                    System.out.println("잘못된 명령어 입니다.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
