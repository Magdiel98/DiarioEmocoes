package entity;

import java.time.LocalDate;

public class Emotion extends Entity{
    private int userId;
    private String feeling;
    private LocalDate date;

    public Emotion(int userId, String feeling, LocalDate date)
    {
        this.userId = userId;
        this.feeling = feeling;
        this.date = date;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getFeeling()
    {
        return feeling;
    }

    public LocalDate getDate()
    {
        return date;
    }
}
