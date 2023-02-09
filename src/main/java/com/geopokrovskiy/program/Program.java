package com.geopokrovskiy.program;

import com.geopokrovskiy.model.InputOutput;

public class Program {
    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("ki")) {
            InputOutput.startGameBetweenHumanAndAI();
        } else {
            InputOutput.startGameBetweenTwoPlayers();
        }
    }
}
