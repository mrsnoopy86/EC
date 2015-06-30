package com.smithysoft.englishclub.utils;

/**
 * Created by User on 30.06.2015.
 */
public class Item {
    int imageViewLogo;
    String textViewTitle;
    String textViewContent;
    String textViewQuestion;

    public Item(int imageViewLogo, String textViewTitle, String textViewContent, String textViewQuestion) {

        this.imageViewLogo = imageViewLogo;
        this.textViewTitle = textViewTitle;
        this.textViewContent = textViewContent;
        this.textViewQuestion = textViewQuestion;
    }

    public int getImageViewLogo() {
        return imageViewLogo;
    }

    public String getTextViewTitle() {
        return textViewTitle;
    }

    public String getTextViewContent() {
        return textViewContent;
    }

    public String getTextViewQuestion() {
        return textViewQuestion;
    }
}
