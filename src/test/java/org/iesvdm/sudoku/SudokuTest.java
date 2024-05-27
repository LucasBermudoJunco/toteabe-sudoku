package org.iesvdm.sudoku;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SudokuTest {

    private Sudoku sudoku;
    private int gridSize = 9;
    private int numClues = 63;

    @BeforeEach
    void setUp() {
        sudoku = new Sudoku();
    }

//    @Test
//    void failTest() {
//        sudoku = new Sudoku();
//        sudoku.fillBoardBasedInCluesRandomlySolvable();
//        //sudoku.fillBoardBasedInCluesRandomly();
//        sudoku.printBoard();
//    }

    /**
     * Comprobación de que todos los números de la tabla estén dentro del ragno
     * de números establecidos (entre 0 y 9)
     */
    @Test
    void fillBoardRandomly(){
        // WHEN & DO
        sudoku.fillBoardRandomly();

        // THEN

        // Recorrido de todos los números de la tabla
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                assertThat(sudoku.getBoard()[i][j]).isBetween(0,9);
            }
        }
    }

    /**
     * Comprobación de que numClues se corresponde con el valor de numClues adecuado
     */
    @Test
    void fillBoardBasedInCluesRandomly(){
        // WHEN & DO
        sudoku.fillBoardBasedInCluesRandomly();

        int numCluesLocal = 0;

        // THEN

        // Recorrido de todos los números de la tabla
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                if(sudoku.getBoard()[i][j] != 0){
                    numCluesLocal++;
                }
            }
        }

        assertThat(numCluesLocal).isEqualTo(numClues);
    }

    // Comprobación de que el tablero del sudoku no está nulo después de ejecutarse este método
    @Test
    void fillBoardBasedInCluesRandomlySolvable(){
        // WHEN & DO
        sudoku.fillBoardBasedInCluesRandomlySolvable();

        // THEN
        assertThat(sudoku.getBoard()).isNotNull();
    }

    // Comprobación de que el board es resoluble después de ejecutar el test
    @Test
    void fillBoardSolvableTest(){
        // WHEN & DO
        sudoku.fillBoardSolvable();

        // THEN
        assertThat(sudoku.solveBoard()).isTrue();
    }

    // Comprobación de que este método copia correctamente el tablero
    // que se le pasa como parámetro
    @Test
    void copyBoardTest(){
        // WHEN
        int[][] tableroCopia = new int[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                tableroCopia[i][j] = (int)(Math.random()*9+1);
            }
        }

        // & DO
        sudoku.copyBoard(tableroCopia);

        // THEN
        assertThat(sudoku.getBoard()).isEqualTo(tableroCopia);
    }

    // Comprobación de que el método coloca correctamente el número
    // en el lugar debido
    @Test
    void putNumberInBoardTest(){
        // WHEN
        int numero = (int)(Math.random()*9+1);
        int fila = (int)(Math.random()*9);
        int columna = (int)(Math.random()*9);

        int[][] tablero = new int[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                tablero[i][j] = (int)(Math.random()*9+1);
            }
        }

        // DO
        sudoku.setBoard(tablero);

        sudoku.putNumberInBoard(numero, fila, columna);

        // THEN
        assertThat(sudoku.getBoard()[fila][columna]).isEqualTo(numero);
    }

    // Comprobación de que el número seleccionado se encuentre en la fila seleccionada
    @Test
    void isNumberInRowTest(){
        // WHEN
        int numero = (int)(Math.random()*9+1);
        int fila = (int)(Math.random()*9);

        // Llenado del tablero con el numero
        int[][] tablero = new int[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                tablero[i][j] = numero;
            }
        }

        // DO
        sudoku.setBoard(tablero);

        boolean numeroPresente = sudoku.isNumberInRow(numero, fila);

        // THEN
        assertThat(numeroPresente).isTrue();
    }

}
