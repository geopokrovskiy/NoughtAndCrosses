package com.geopokrovskiy.model;

import java.util.Scanner;

public class GameFieldAI extends GameField {

    /**
     * default constructor
     */
    public GameFieldAI() {
        super();
    }

    /**
     * returns an index where AI should make its turn in order to win.
     * if there is no way to win right now, returns -1
     *
     * @return
     */
    private int canAIWin() {
        if ((gameField[0][1] == 'o' && gameField[0][2] == 'o' && !isTaken[0][0]) ||
                (gameField[1][0] == 'o' && gameField[2][0] == 'o' && !isTaken[0][0]) ||
                (gameField[1][1] == 'o' && gameField[2][2] == 'o') && !isTaken[0][0]) return 0;

        else if ((gameField[0][0] == 'o' && gameField[0][2] == 'o' && !isTaken[0][1]) ||
                (gameField[1][1] == 'o' && gameField[2][1] == 'o' && !isTaken[0][1])) return 1;

        else if ((gameField[0][0] == 'o' && gameField[0][1] == 'o' && !isTaken[0][2]) ||
                (gameField[1][2] == 'o' && gameField[2][2] == 'o' && !isTaken[0][2]) ||
                (gameField[1][1] == 'o' && gameField[2][0] == 'o') && !isTaken[0][2]) return 2;

        else if ((gameField[0][0] == 'o' && gameField[2][0] == 'o' && !isTaken[1][0]) ||
                (gameField[1][1] == 'o' && gameField[1][2] == 'o' && !isTaken[1][0])) return 3;

        else if ((gameField[0][0] == 'o' && gameField[2][2] == 'o' && !isTaken[1][1]) ||
                (gameField[0][1] == 'o' && gameField[2][1] == 'o' && !isTaken[1][1]) ||
                (gameField[0][2] == 'o' && gameField[2][0] == 'o' && !isTaken[1][1]) ||
                (gameField[1][0] == 'o' && gameField[1][2] == 'o' && !isTaken[1][1])) return 4;

        else if ((gameField[0][2] == 'o' && gameField[2][2] == 'o' && !isTaken[1][2]) ||
                (gameField[1][0] == 'o' && gameField[1][1] == 'o') && !isTaken[1][2]) return 5;

        else if ((gameField[0][0] == 'o' && gameField[1][0] == 'o' && !isTaken[2][0]) ||
                (gameField[2][2] == 'o' && gameField[2][1] == 'o' && !isTaken[2][0]) ||
                (gameField[1][1] == 'o' && gameField[0][2] == 'o') && !isTaken[2][0]) return 6;

        else if ((gameField[0][1] == 'o' && gameField[1][1] == 'o' && !isTaken[2][1]) ||
                (gameField[2][0] == 'o' && gameField[2][2] == 'o') && !isTaken[2][1]) return 7;

        else if ((gameField[0][0] == 'o' && gameField[1][1] == 'o' && !isTaken[2][2]) ||
                (gameField[0][2] == 'o' && gameField[1][2] == 'o' && !isTaken[2][2]) ||
                (gameField[2][0] == 'o' && gameField[2][1] == 'o') && !isTaken[2][2]) return 8;
        return -1;
    }

    /**
     * returns an index where AI should make its turn in order to intercept an opponent to win .
     * if there is no way to intercept right now, returns -1
     *
     * @return
     */
    private int canAIIntercept() {
        if ((gameField[0][1] == 'x' && gameField[0][2] == 'x' && !isTaken[0][0]) ||
                (gameField[1][0] == 'x' && gameField[2][0] == 'x' && !isTaken[0][0]) ||
                (gameField[1][1] == 'x' && gameField[2][2] == 'x') && !isTaken[0][0]) return 0;

        else if ((gameField[0][0] == 'x' && gameField[0][2] == 'x' && !isTaken[0][1]) ||
                (gameField[1][1] == 'x' && gameField[2][1] == 'x' && !isTaken[0][1])) return 1;

        else if ((gameField[0][0] == 'x' && gameField[0][1] == 'x' && !isTaken[0][2]) ||
                (gameField[1][2] == 'x' && gameField[2][2] == 'x' && !isTaken[0][2]) ||
                (gameField[1][1] == 'x' && gameField[2][0] == 'x') && !isTaken[0][2]) return 2;

        else if ((gameField[0][0] == 'x' && gameField[2][0] == 'x' && !isTaken[1][0]) ||
                (gameField[1][1] == 'x' && gameField[1][2] == 'x' && !isTaken[1][0])) return 3;

        else if ((gameField[0][0] == 'x' && gameField[2][2] == 'x' && !isTaken[1][1]) ||
                (gameField[0][1] == 'x' && gameField[2][1] == 'x' && !isTaken[1][1]) ||
                (gameField[0][2] == 'x' && gameField[2][0] == 'x' && !isTaken[1][1]) ||
                (gameField[1][0] == 'x' && gameField[1][2] == 'x' && !isTaken[1][1])) return 4;

        else if ((gameField[0][2] == 'x' && gameField[2][2] == 'x' && !isTaken[1][2]) ||
                (gameField[1][0] == 'x' && gameField[1][1] == 'x') && !isTaken[1][2]) return 5;

        else if ((gameField[0][0] == 'x' && gameField[1][0] == 'x' && !isTaken[2][0]) ||
                (gameField[2][2] == 'x' && gameField[2][1] == 'x' && !isTaken[2][0]) ||
                (gameField[1][1] == 'x' && gameField[0][2] == 'x') && !isTaken[2][0]) return 6;

        else if ((gameField[0][1] == 'x' && gameField[1][1] == 'x' && !isTaken[2][1]) ||
                (gameField[2][0] == 'x' && gameField[2][2] == 'x') && !isTaken[2][1]) return 7;

        else if ((gameField[0][0] == 'x' && gameField[1][1] == 'x' && !isTaken[2][2]) ||
                (gameField[0][2] == 'x' && gameField[1][2] == 'x' && !isTaken[2][2]) ||
                (gameField[2][0] == 'x' && gameField[2][1] == 'x') && !isTaken[2][2]) return 8;
        return -1;
    }

    /**
     * finds a free angle with the lowest coordinates
     *
     * @return
     */
    private int findMinimalFreeAngle() {
        if (!isTaken[0][0]) {
            return 0;
        } else if (!isTaken[0][2]) {
            return 2;
        } else if (!isTaken[2][0]) {
            return 6;
        } else if (!isTaken[2][2]) {
            return 8;
        }
        return -1;
    }

    /**
     * finds a free angle with the lowest coordinates
     *
     * @return
     */
    private int findMinimalCell() {
        if (!isTaken[0][1]) {
            return 1;
        } else if (!isTaken[1][0]) {
            return 3;
        } else if (!isTaken[1][2]) {
            return 5;
        } else if (!isTaken[2][1]) {
            return 7;
        }
        return -1;
    }


    /**
     * returns a cell number where AI should make its turn
     *
     * @return
     */
    private int makeChoiceForAI() {
        int cellNumber = canAIWin();
        if (cellNumber != -1) {
            return cellNumber;
        } else {
            cellNumber = canAIIntercept();
            if (cellNumber != -1) {
                return cellNumber;
            } else if (!this.isTaken[1][1]) {
                return 4;
            } else {
                cellNumber = this.findMinimalFreeAngle();
                if (cellNumber != -1) {
                    return cellNumber;
                } else {
                    cellNumber = this.findMinimalCell();
                    return cellNumber;
                }
            }
        }
    }

    /**
     * AI makes its turn
     */
    protected void makeTurn() {
        isTurnOfTheFirstPlayer = true;
        int choiceOfAI = this.makeChoiceForAI();
        int i = getCoordinatesOfCell(choiceOfAI)[0];
        int j = getCoordinatesOfCell(choiceOfAI)[1];
        this.isTaken[i][j] = true;
        this.gameField[i][j] = 'o';
        this.numberOfTakenCells++;
    }

    /**
     * initiates a game between a player and AI
     *
     * @param scanner
     */
    @Override
    public void startGame(Scanner scanner) {
        int numberOfTurn = 1;
        while (!fieldIsFull()) {
            int numberOfCell = -1;
            if (isTurnOfTheFirstPlayer) {
                while (!theChoiceIsCorrect(numberOfCell)) {
                    System.out.println(numberOfTurn + ". Turn: x\n>");
                    numberOfCell = scanner.nextInt();
                }
                super.makeTurn(numberOfCell);
            } else {
                System.out.println(numberOfTurn + ". Turn: o\n>");
                this.makeTurn();
            }
            for (int i = 0; i < 3; i++) {
                System.out.print('\n');
                for (int j = 0; j < 3; j++) {
                    System.out.print(this.gameField[i][j]);
                }
            }
            System.out.println('\n');
            if (oWon()) {
                System.out.println("Winner: o\n");
                break;
            } else if (xWon()) {
                System.out.println("Winner: x\n");
                break;
            }
            numberOfTurn++;
        }
        if (fieldIsFull()) {
            System.out.println("No Winner.");
        }
    }
}
