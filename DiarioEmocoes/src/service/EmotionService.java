package service;

import dao.EmotionDAO;
import entity.Emotion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmotionService {
    private EmotionDAO emotionDAO = new EmotionDAO();

    public void recordEmotion(int userId, String feeling) {
        emotionDAO.save(new Emotion(userId, feeling, LocalDate.now()));
    }

    public List<Emotion> getWeekEmotions(int userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = now.with(DayOfWeek.MONDAY);
        LocalDate end = start.plusDays(6);
        return emotionDAO.findByUserAndWeek(userId, start, end);
    }

    public String getMostFrequentEmotion(int userId, int month) {
        List<Emotion> monthEmotions = emotionDAO.findByUserAndMonth(userId, month);
        return monthEmotions.stream()
                .collect(Collectors.groupingBy(Emotion::getFeeling, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Nenhuma emoção registrada.");
    }

    public String getAdvice(String emotion){
        switch (emotion.toLowerCase()){
            case "triste":
                return "Tente sair, conversar com alguém, ouvir uma música calma.";
            case "feliz":
                return "Continue espalhando essa energia positiva";
            case "ansioso":
                return "Respire fundo. Faça uma caminhada ou pratique meditação";
            default:
                return "Se cuide! Procure sempre expressar seus sentimentos.";
        }
    }
}
