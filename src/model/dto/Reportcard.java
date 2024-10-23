package model.dto;

import java.util.Objects;

public class Reportcard {
    private String title;
    private double score;

    public Reportcard(String title, double score) {
        this.title = title;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reportcard karname = (Reportcard) o;
        return Double.compare(score, karname.score) == 0 && Objects.equals(title, karname.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, score);
    }

    @Override
    public String toString() {
        return "Karname{" +
                "title='" + title + '\'' +
                ", score=" + score +
                '}';
    }
}
