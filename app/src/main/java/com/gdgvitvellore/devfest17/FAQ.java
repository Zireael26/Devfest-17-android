package com.gdgvitvellore.devfest17;

/**
 * Created by Raina on 17-10-2017.
 */

public class FAQ {
    private String question;
    private String answer;
    private int quesIcon;
    private int ansIcon;

    public FAQ(String question, String answer, int quesIcon, int ansIcon) {
        this.question = question;
        this.answer = answer;
        this.quesIcon = quesIcon;
        this.ansIcon = ansIcon;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getQuesIcon() {
        return quesIcon;
    }

    public int getAnsIcon() {
        return ansIcon;
    }
}
