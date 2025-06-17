package ui;

import entity.User;
import service.EmotionService;
import service.UserService;
import utils.DateUtils;

import java.util.List;
import java.util.Scanner;

public class MainUI {
    private UserService userService = new UserService();
    private EmotionService emotionService = new EmotionService();
    private Scanner scanner = new Scanner(System.in);
    private User currentUser;

    public void start() {
        while (true) {
            System.out.println("1 - Cadastrar | 2 - Login | 0 - Sair");
            int op = scanner.nextInt();
            scanner.nextLine();
            if (op == 1) register();
            else if (op == 2 && login()) menu();
            else if (op == 0) break;
        }
    }

    private void register() {
        System.out.print("Usuário: ");
        String user = scanner.nextLine();
        System.out.print("Senha: ");
        String pass = scanner.nextLine();
        if (userService.register(user, pass)) System.out.println("Cadastro feito!");
        else System.out.println("Usuário já existe.");
    }

    private boolean login() {
        System.out.print("Usuário: ");
        String user = scanner.nextLine();
        System.out.print("Senha: ");
        String pass = scanner.nextLine();
        return userService.login(user, pass).map(u -> {
            currentUser = u;
            return true;
        }).orElseGet(() -> {
            System.out.println("Login falhou.");
            return false;
        });
    }

    private void menu() {
        while (true) {
            System.out.println("\n1 - Anotar Emoção | 2 - Ver Semana | 3 - Ver Gráfico Mês | 0 - Logout");
            int op = scanner.nextInt();
            scanner.nextLine();
            if (op == 1) recordEmotion();
            else if (op == 2) showWeekEmotions();
            else if (op == 3) showMonthGraph();
            else if (op == 0) break;
        }
    }

    private void recordEmotion() {
        System.out.print("Como está se sentindo hoje? ");
        String feeling = scanner.nextLine();
        emotionService.recordEmotion(currentUser.getId(), feeling);
        System.out.println("Emoção registrada!");
    }

    private void showWeekEmotions() {
        List<?> emotions = emotionService.getWeekEmotions(currentUser.getId());
        System.out.println("Emoções da Semana:");
        emotions.forEach(System.out::println);
    }

    private void showMonthGraph() {
        int month = java.time.LocalDate.now().getMonthValue();
        String emotion = emotionService.getMostFrequentEmotion(currentUser.getId(), month);
        System.out.println("Emoção mais presente no mês: " + emotion);
        System.out.println("Conselho: " + emotionService.getAdvice(emotion));
        System.out.println("Tema de fundo: " + DateUtils.getMonthName(month));
    }
}
