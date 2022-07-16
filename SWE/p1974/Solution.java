package p1974;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static boolean answerCheck;
    static int[][] board = new int[9][9];
    static boolean[] check;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    board[i][j] = sc.nextInt();
                }
            }
            answerCheck = checkRow();
            if (answerCheck)
                answerCheck = checkColumn();
            if (answerCheck)
                answerCheck = checkArea();
             
            sb.append("#" + test_case + " ");
            if (answerCheck)
                sb.append(1 + "\n");
            else
                sb.append(0 + "\n");
        }
        System.out.println(sb.toString());
    }
    public static boolean checkRow()
    {
        for (int i = 0; i < 9; i++)
        {
            check = new boolean[10];
            for (int j = 0; j < 9; j++)
            {
                if (check[board[i][j]])
                {
                    return false;
                }
                check[board[i][j]] = true;
            }
        }
        return true;
    }
    public static boolean checkColumn()
    {
        for (int j = 0; j < 9; j++)
        {
            check = new boolean[10];
            for (int i = 0; i < 9; i++)
            {
                if (check[board[i][j]])
                {
                    return false;
                }
                check[board[i][j]] = true;
            }
        }
        return true;
    }
    public static boolean checkArea()
    {
        for (int i = 0; i < 9; i += 3)
        {
            for (int j = 0; j < 9; j += 3)
            {
                check = new boolean[10];
                for (int a = i; a < i + 3; a++)
                {
                    for (int b = j; b < j + 3; b++)
                    {
                        if (check[board[a][b]])
                        {
                            return false;
                        }
                        check[board[a][b]] = true;
                    }
                }
            }
        }
        return true;
    }
}