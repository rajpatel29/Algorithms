package Boggle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MainClass {
	public static void main(String[] args) {
		String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
		
//		char[][] boggle = {
//				{'G','I','Z'},
//                {'U','E','K'},
//                {'Q','S','E'}
//        };
		
		char[][] boggle = {
				{'A','B'},
                {'C','D'},
        };
				
		findWords(boggle, dictionary, boggle.length, boggle[0].length);
	}

	private static void findWords(char[][] boggle, String[] dictionary, int rows, int cols) {
		HashSet<String> words = new HashSet<>();
		HashSet<String> result = new HashSet<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean[][] visited = new boolean[rows][cols];
				
				words.addAll( findWordsDFS(boggle, i, j, visited, result, ""));
				System.out.println();
				System.out.println();
				System.out.println();
			}
		}
	
		System.out.println(words);
	}

	private static HashSet<String> findWordsDFS(char[][] boggle, int row, int col, boolean[][] visited, HashSet<String> result, String str) {
		
		if(row < 0 || col < 0 || row >= boggle.length || col >= boggle[0].length) 
			return result;
		
		if(visited[row][col])
			return result;
		
		visited[row][col] = true;
		str = str + boggle[row][col];
		result.add(str);
		System.out.println(str);
		
		for (int i = row-1; i <= row+1; i++) {
			for (int j = col-1; j <= col+1; j++) {
				findWordsDFS(boggle, i, j, visited, result, str);
			}
		}
		
		str = removeLastChar(str);
		visited[row][col] = false;
		return result;
	}
	
	public static String removeLastChar(String str) {
	    if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
	        str = str.substring(0, str.length() - 1);
	    }
	    return str;
	}
}
