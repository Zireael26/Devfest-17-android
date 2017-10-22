package com.gdgvitvellore.devfest17;

/**
 * Created by Raina on 17-10-2017.
 */

class FAQ {
    private String question;
    private String answer;
    private int quesIcon;
    private int ansIcon;
    private int cardBackground;

    FAQ(String question, String answer, int quesIcon, int ansIcon, int cardBackground) {
        this.question = question;
        this.answer = answer;
        this.quesIcon = quesIcon;
        this.ansIcon = ansIcon;
        this.cardBackground = cardBackground;
    }

    String getQuestion() {
        return question;
    }

    String getAnswer() {
        return answer;
    }

    int getQuesIcon() {
        return quesIcon;
    }

    int getAnsIcon() {
        return ansIcon;
    }

    int getCardBackground() {
        return cardBackground;
    }
}
