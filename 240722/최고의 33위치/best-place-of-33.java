import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  codetree.ai
 * @problemNumber   missions/2/problems/best-place-of-33
 * @problemTitle    최고의 33위치
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int row, col, row33, col33;
        int N = Integer.parseInt(br.readLine());
        String[] userInput;
        
        // 격자 초기화
        int[][] mat = new int[N][N];
        for (row = 0; row < N; row++) {
            userInput = br.readLine().split(" ");
            for (col = 0; col < N; col++) {
                mat[row][col] = Integer.parseInt(userInput[col]);
            }
        }
        
        int cur = 0; // 현재 3*3 격자에서 얻을 수 있는 동전의 개수
        int max = 0; // 3*3 격자에서 얻을 수 있는 동전의 최대 개수
        for (row = 0; row < N-2; row++) {
            for (col = 0; col < N-2; col++) {
                for (row33 = row; row33 < row+3; row33++) {
                    for (col33 = col; col33 < col+3; col33++) {
                        if (mat[row33][col33] == 1) cur++;
                    }
                }
                if (max < cur) max = cur;
                cur = 0;
            }
        }
        
        bw.write(max + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}