package org.example;

public class Request {
    private static String[] commandArray;

    private String command;
    private int idx;
    private boolean wrongCommand;

    public Request(String a) {
        if (commandArray == null) {
            commandArray = new String[]{"종료", "등록", "목록", "삭제", "수정"};
        }
        wrongCommand = false;
        idx = -1;

        String[] s = a.split("\\?", 2);
        for (String c : commandArray) {
            if (c.equals(s[0])) {
                command = s[0];
                break;
            } else if (c.equals(commandArray[commandArray.length - 1])) {
                wrongCommand = true;
            }
        }

        if (s.length > 1) {
            if (s[1].startsWith("id=") && isInt(s[1].replace("id=", ""))) {
                idx = Integer.parseInt(s[1].replace("id=", ""));
            } else {
                wrongCommand = true;
            }
        }


    }

    public boolean isInt(String isInt) {
        if (isInt == null) return false;
        try {
            Integer.parseInt(isInt);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int getIdx() {
        return idx;
    }

    public String getCommand() {
        return command;
    }

    public boolean isError() {
        return wrongCommand;
    }
}
