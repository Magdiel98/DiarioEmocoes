package dao;

import entity.Emotion;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EmotionDAO implements DAO<Emotion> {
    private Map<Integer, Emotion> emotions = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(Emotion emotion) {
        emotion.setId(nextId++);
        emotions.put(emotion.getId(), emotion);
    }

    @Override
    public Collection<Emotion> findAll() {
        return emotions.values();
    }

    @Override
    public void update(int id, Emotion emotion) {
        emotions.put(id, emotion);
    }

    @Override
    public void delete(int id) {
        emotions.remove(id);
    }

    public List<Emotion> findByUserAndWeek(int userId, LocalDate start, LocalDate end) {
        return emotions.values().stream()
                .filter(e -> e.getUserId() == userId && !e.getDate().isBefore(start) && !e.getDate().isAfter(end))
                .collect(Collectors.toList());
    }

    public List<Emotion> findByUserAndMonth(int userId, int month) {
        return emotions.values().stream()
                .filter(e -> e.getUserId() == userId && e.getDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }
}
