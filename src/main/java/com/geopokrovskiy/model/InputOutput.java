package com.geopokrovskiy.model;

import java.util.Scanner;

public class InputOutput {
    private static final GameField gameField = new GameField();
    private static final GameFieldAI gameFieldAI = new GameFieldAI();
    private static final Scanner scanner = new Scanner(System.in);

    public static void startGameBetweenTwoPlayers() {
        gameField.startGame(scanner);
        scanner.close();
    }

    public static void startGameBetweenHumanAndAI() {
        gameFieldAI.startGame(scanner);
        scanner.close();
    }
}
