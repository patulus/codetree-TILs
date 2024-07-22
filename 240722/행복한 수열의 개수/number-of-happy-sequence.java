import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  codetree.ai
 * @problemNumber   missions/2/problems/number-of-happy-sequence
 * @problemTitle    행복한 수열의 개수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int row, col;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 격자의 크기
        int M = Integer.parseInt(userInput[1]); // 연속해야 하는 숫자의 수

        // 격자 초기화
        int[][] mat = new int[N][N];
        for (row = 0; row < N; row++) {
            userInput = br.readLine().split(" ");
            for (col = 0; col < N; col++) {
                mat[row][col] = Integer.parseInt(userInput[col]);
            }
        }
        
        int cntHappySeq = 0; // 행복한 수열의 개수
        int prevNum; // 이전 원소
        int cntNum; // 이전 원소와 연속되는 원소의 개수
        for (row = 0; row < N; row++) {
            prevNum = mat[row][0];
            cntNum = 0;
            for (col = 0; col < N; col++) {
                if (mat[row][col] == prevNum) {
                    cntNum++;
                } else {
                    prevNum = mat[row][col];
                    cntNum = 1;
                }
                if (cntNum >= M) {
                    cntHappySeq++;
                    break;
                }
            }
        }
        for (col = 0; col < N; col++) {
            prevNum = mat[0][col];
            cntNum = 0;
            for (row = 0; row < N; row++) {
                if (mat[row][col] == prevNum) {
                    cntNum++;
                } else {
                    prevNum = mat[row][col];
                    cntNum = 1;
                }
                if (cntNum >= M) {
                    cntHappySeq++;
                    break;
                }
            }
        }
        
        bw.write(cntHappySeq + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}