package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    private final Scanner scanner;
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;
    public App(Scanner scanner) {
        this.scanner = scanner;
    }
    public void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if(cmd.equals("종료")) {
                break;
            }

            else if(cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();
                System.out.print("작가 : ");
                String author = scanner.nextLine();

                wiseSayings.add(new WiseSaying(++lastId, content, author));
                System.out.println(lastId +"번 명언이 등록되었습니다.");
            }

            else if(cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                List<WiseSaying> findForList = wiseSayings.reversed();

                for(WiseSaying wiseSaying : findForList) {
                    System.out.println(wiseSaying.getId()
                            + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
                }
            }

            else if(cmd.startsWith("삭제")) {
                StringTokenizer st = new StringTokenizer(cmd,"삭제?id=");
                int deleteId = Integer.parseInt(st.nextToken());
                boolean isDeleted = false;

                for(WiseSaying wiseSaying : wiseSayings) {
                    if(wiseSaying.getId() == deleteId) {
                        isDeleted = wiseSayings.remove(wiseSaying);
                        System.out.println(deleteId + "번 명언이 삭제되었습니다." );
                        break;
                    }
                }

                if(!isDeleted) {
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다." );
                }
            }

            else if(cmd.startsWith("수정")) {
                StringTokenizer st = new StringTokenizer(cmd,"수정?id=");
                int reviseId = Integer.parseInt(st.nextToken());
                boolean isRevised = false;

                for(WiseSaying wiseSaying : wiseSayings) {
                    if(wiseSaying.getId() == reviseId) {
                        System.out.println("명언(기존) : " + wiseSaying.getContent());
                        System.out.print("명언 : ");
                        String content = scanner.nextLine();

                        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                        System.out.print("명언 : ");
                        String author = scanner.nextLine();

                        // 수정
                        wiseSaying.setContent(content);
                        wiseSaying.setAuthor(author);

                        isRevised = true;
                    }
                }

                if(!isRevised) {
                    System.out.println(reviseId + "번 명언은 존재하지 않습니다." );
                }
            }
        }
    }
}
