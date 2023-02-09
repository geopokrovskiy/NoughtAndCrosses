package com.geopokrovskiy.model;

import java.util.Scanner;

public class GameField {

    protected char[][] gameField = new char[3][3];
    protected boolean isTurnOfTheFirstPlayer = true;
    protected boolean[][] isTaken = new boolean[3][3];
    protected int numberOfTakenCells;


    /**
     * default constructor
     */
    public GameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.gameField[i][j] = '-';
            }
        }
    }

    /**
     * returns an array with coordinates of the cell
     * from a cell number
     *
     * @param a
     * @return
     */
    protected int[] getCoordinatesOfCell(int a) {
        return new int[]{a / 3, a % 3};
    }

    /**
     * verifies whether a player can make a turn at a given cell
     *
     * @param a
     * @return
     */
    protected boolean theChoiceIsCorrect(int a) {
        if (a < 0 || a > 8) return false;
        int i = getCoordinatesOfCell(a)[0];
        int j = getCoordinatesOfCell(a)[1];
        return (!this.isTaken[i][j]);
    }

    /**
     * makes a turn
     *
     * @param numberOfCell
     */
    protected void makeTurn(int numberOfCell) {
        int i = getCoordinatesOfCell(numberOfCell)[0];
        int j = getCoordinatesOfCell(numberOfCell)[1];

        this.isTaken[i][j] = true;
        this.numberOfTakenCells++;
        if (isTurnOfTheFirstPlayer) {
            isTurnOfTheFirstPlayer = false;
            this.gameField[i][j] = 'x';
        } else {
            isTurnOfTheFirstPlayer = true;
            this.gameField[i][j] = 'o';
        }
    }

    /**
     * verifies whether the field is full
     *
     * @return
     */
    protected boolean fieldIsFull() {
        return (numberOfTakenCells == 9);
    }

    /**
     * verifies whether X player Won
     *
     * @return
     */
    protected boolean xWon() {
        return ((this.gameField[0][0] == 'x' && this.gameField[0][1] == 'x' && this.gameField[0][2] == 'x') ||
                (this.gameField[1][0] == 'x' && this.gameField[1][1] == 'x' && this.gameField[1][2] == 'x') ||
                (this.gameField[2][0] == 'x' && this.gameField[2][1] == 'x' && this.gameField[2][2] == 'x') ||
                (this.gameField[0][0] == 'x' && this.gameField[1][0] == 'x' && this.gameField[2][0] == 'x') ||
                (this.gameField[0][1] == 'x' && this.gameField[1][1] == 'x' && this.gameField[2][1] == 'x') ||
                (this.gameField[0][2] == 'x' && this.gameField[1][2] == 'x' && this.gameField[2][2] == 'x') ||
                (this.gameField[0][0] == 'x' && this.gameField[1][1] == 'x' && this.gameField[2][2] == 'x') ||
                (this.gameField[2][0] == 'x' && this.gameField[1][1] == 'x' && this.gameField[0][2] == 'x'));
    }

    /**
     * verifies whether O player Won
     *
     * @return
     */
    protected boolean oWon() {
        return ((this.gameField[0][0] == 'o' && this.gameField[0][1] == 'o' && this.gameField[0][2] == 'o') ||
                (this.gameField[1][0] == 'o' && this.gameField[1][1] == 'o' && this.gameField[1][2] == 'o') ||
                (this.gameField[2][0] == 'o' && this.gameField[2][1] == 'o' && this.gameField[2][2] == 'o') ||
                (this.gameField[0][0] == 'o' && this.gameField[1][0] == 'o' && this.gameField[2][0] == 'o') ||
                (this.gameField[0][1] == 'o' && this.gameField[1][1] == 'o' && this.gameField[2][1] == 'o') ||
                (this.gameField[0][2] == 'o' && this.gameField[1][2] == 'o' && this.gameField[2][2] == 'o') ||
                (this.gameField[0][0] == 'o' && this.gameField[1][1] == 'o' && this.gameField[2][2] == 'o') ||
                (this.gameField[2][0] == 'o' && this.gameField[1][1] == 'o' && this.gameField[0][2] == 'o'));
    }

    /**
     * initiates a game between two players
     *
     * @param scanner
     */
    public void startGame(Scanner scanner) {
        int numberOfTurn = 1;
        while (!fieldIsFull()) {
            int numberOfCell = -1;
            while (!theChoiceIsCorrect(numberOfCell)) {
                if (isTurnOfTheFirstPlayer) System.out.println(numberOfTurn + ". Turn: x\n>");
                else System.out.println(numberOfTurn + ". Turn: o\n>");
                numberOfCell = scanner.nextInt();
            }
            makeTurn(numberOfCell);

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
