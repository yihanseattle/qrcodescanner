package com.blikoon.qrcodescannerlibrary.main;

/**
 * Created by yihan on 10/19/18.
 */

public class DataModelMainActivity {

    private int mImageViewResourceId;
    private String mTextViewTitle;
    private String mTextViewContent;

    public DataModelMainActivity(int imageViewResourceId, String textViewTitle, String textViewContent) {
        mImageViewResourceId = imageViewResourceId;
        mTextViewTitle = textViewTitle;
        mTextViewContent = textViewContent;
    }

    public int getImageViewResourceId() {
        return mImageViewResourceId;
    }

    public void setImageViewResourceId(int imageViewResourceId) {
        mImageViewResourceId = imageViewResourceId;
    }

    public String getTextViewTitle() {
        return mTextViewTitle;
    }

    public void setTextViewTitle(String textViewTitle) {
        mTextViewTitle = textViewTitle;
    }

    public String getTextViewContent() {
        return mTextViewContent;
    }

    public void setTextViewContent(String textViewContent) {
        mTextViewContent = textViewContent;
    }
}
