package org.example;

import org.example.article.ArticleController;
import org.example.system.SystemController;

public class App {
    ArticleController articleController;
    SystemController systemController;

    App() {
        Container.init();
        articleController = new ArticleController();
        systemController = new SystemController();
    }

    void run() {
        System.out.println("== 게시판 앱 ==");
        while (true) {
            try {
                System.out.print("명령) ");
                String a = Container.getSc().nextLine().trim();
                Request r = new Request(a);

                if (r.isError()) {
                    System.out.println("잘못된 명령어 입니다.");
                } else if (r.getCommand().equals("종료")) {
                    systemController.exit();
                    Container.close();
                    break;
                } else if (r.getCommand().equals("등록")) {
                    articleController.boardInsert();
                } else if (r.getCommand().equals("목록")
                        || r.getCommand().equals("삭제")
                        || r.getCommand().equals("수정")) {
                    articleController.BaNotEmpty(r.getCommand(), r.getIdx());
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
