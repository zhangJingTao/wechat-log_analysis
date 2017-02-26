package com.sleep.wechat.domain;

import com.sun.javafx.beans.annotations.Default;

import java.util.Date;

/**
 * 对象
 */
public class WordDomain {
    String word;
    Date firstDisplay;
    Date lastDisplay;
    Integer count;

    public WordDomain() {
    }

    public WordDomain(String word, Date firstDisplay) {
        this.word = word;
        this.firstDisplay = firstDisplay;
    }

    public WordDomain(String word) {
        this.word = word;
    }

    public WordDomain(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getFirstDisplay() {
        return firstDisplay;
    }

    public void setFirstDisplay(Date firstDisplay) {
        this.firstDisplay = firstDisplay;
    }

    public Date getLastDisplay() {
        return lastDisplay;
    }

    public void setLastDisplay(Date lastDisplay) {
        this.lastDisplay = lastDisplay;
    }

    public Integer getCount() {
        return count == null? 0:count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void addCount(){
        this.setCount(this.getCount()+1);
        this.setLastDisplay(new Date());
    }

    @Override
    public int hashCode() {
        return  this.word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WordDomain){
            return this.word.equals(((WordDomain) obj).word);
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
