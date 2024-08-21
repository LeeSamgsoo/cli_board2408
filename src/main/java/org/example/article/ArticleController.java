package org.example.article;

import org.example.Container;

import java.util.ArrayList;

public class ArticleController {
    static ArrayList<Board> ba;
    static int boardCount;

    public ArticleController() {
        boardCount = 0;
        ba = new ArrayList<>();
    }

    public void boardInsert() {
        System.out.print("제목 : ");
        String title = Container.getSc().nextLine();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine();

        boardCount++;
        ba.add(new Board(boardCount, title, content));
        System.out.println(boardCount + "번 게시글이 등록되었습니다.");
    }

    void boardShow() {
        System.out.println("번호 / 제목 / 내용");
        System.out.println("---------------------------");
        int countIns = boardCount - 1;
        while (countIns >= 0) {
            System.out.println(ba.get(countIns).getNumber() + " / " + ba.get(countIns).getTitle() + " / " + ba.get(countIns).getContent());
            countIns--;
        }
    }

    void boardDelete(int delInIndex, int delArrIndex) {
        ba.remove(delArrIndex);
        System.out.println(delInIndex + "번 게시물이 삭제되었습니다.");
        boardCount--;
    }

    void boardModify(int modInIndex, int modArrIndex) {
        System.out.println("제목(기존) : " + ba.get(modArrIndex).getTitle());
        System.out.print("제목 : ");
        ba.get(modArrIndex).setTitle(Container.getSc().nextLine());

        System.out.println("내용(기존) : " + ba.get(modArrIndex).getContent());
        System.out.print("내용 : ");
        ba.get(modArrIndex).setContent(Container.getSc().nextLine());

        System.out.println(modInIndex + "번 게시물이 수정되었습니다.");
        ba.addLast(ba.get(modArrIndex));
        ba.remove(modArrIndex);
    }


    public void BaNotEmpty(String s, int idx) {
        if (boardCount == 0) {
            System.out.println("게시물이 존재하지 않습니다.");
        } else if (s.equals("목록")) {
            boardShow();
        } else {
            for (int i = 0; i < ba.size(); i++) {
                if (ba.get(i).getNumber() == idx) {
                    if (s.equals("삭제")) {
                        boardDelete(idx, i);
                    } else if (s.equals("수정")) {
                        boardModify(idx, i);
                    }
                } else if (i == ba.size() - 1) {
                    System.out.println("존재하지 않는 게시물 번호입니다");
                }
            }
        }
    }
}
