package com.explore;

/**
 * @author xiaohb
 * @program
 * @description
 * @date 2018-11-13 10:58 PM
 **/
public class Custom implements Comparable<Custom>{

    private String name;
    private int score;

    public Custom() {
    }

    public Custom(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Custom that) {
        if(this.score > that.score) {
            return -1;
        }else if (this.score < that.score) {
            return 1;
        }else {
            return this.name.compareTo(that.name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Custom{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
