package main.java.com.stoiovici;

import java.util.HashMap;
import java.util.Map;

public class FindChessboardEndPositionSolution {
    public static String findEndPosition(String startPosition, int rowsNumber, int colsNumber ){
        Map<Integer, Integer> rowMap = createRowMap();
        Map<Character, Integer> colMap = createColMap();
        String first = Character.toString(startPosition.charAt(0));
        int row = rowMap.get(Integer.valueOf(first));
        int col = colMap.get(Character.valueOf(startPosition.charAt(1)));
        row = updateRow(row, rowsNumber);
        col = updateColumn(col, colsNumber);

        String endPosition ="";
        for (Map.Entry<Integer,Integer> entry : rowMap.entrySet()) {
            if(entry.getValue() == row){
                endPosition += String.valueOf(entry.getKey());
            }
        }
        for (Map.Entry<Character,Integer> entry : colMap.entrySet()) {
            if(entry.getValue() == col){
                endPosition += String.valueOf(entry.getKey());
            }
        }
        return endPosition;

    }

    private static int updateRow(int startRow, int rowsNumber){
        while (rowsNumber >0){
            if(startRow == 0){
                startRow = 7;
            } else {
                startRow = startRow -1;}
            rowsNumber --;

        }
        return startRow;
    }
    private static int updateColumn( int startCol, int colsNumber){
        while (colsNumber >0){
            if(startCol == 7){
                startCol = 0;
            } else {
                startCol = startCol + 1;}
            colsNumber --;

        }
        return startCol;
    }

    private static Map<Integer, Integer> createRowMap(){
        Map<Integer, Integer> rowMap = new HashMap<>();
        rowMap.put(8, 0);
        rowMap.put(7, 1);
        rowMap.put(6, 2);
        rowMap.put(5, 3);
        rowMap.put(4, 4);
        rowMap.put(3, 5);
        rowMap.put(2, 6);
        rowMap.put(1, 7);
        return rowMap;
    }

    private static Map<Character, Integer> createColMap(){
        Map<Character, Integer> colMap = new HashMap<>();
        colMap.put('a', 0);
        colMap.put('b', 1);
        colMap.put('c', 2);
        colMap.put('d', 3);
        colMap.put('e', 4);
        colMap.put('f', 5);
        colMap.put('g', 6);
        colMap.put('h', 7);
        return colMap;
    }
    public static void main(String[] args) {

        System.out.println(findEndPosition("2b", 3,2));
    }
}
