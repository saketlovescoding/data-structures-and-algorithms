package cses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CountingRooms {

    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, -1, 1, 0};
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        char[][] adjMatrix = new char[n][m];
        for(int i=0 ; i<n ; i++){
            String s = sc.next();
            for(int j=0 ; j<m ; j++){
                adjMatrix[i][j]= s.charAt(j);
            }
        }

        int ans=0;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(adjMatrix[i][j]=='.'){
                    ans++;
                    recursion(adjMatrix, i, j);
                }
            }
        }

        System.out.println(ans);

    }

    private static void recursion(char[][] adjMatrix, int i, int j) {

        adjMatrix[i][j]='#';

        Stack<List<Integer>> st = new Stack<>();
        st.push(new ArrayList<>(List.of(i, j)));
        while (!st.isEmpty()){
            int l = st.size();
            for(int k =0 ; k<l ; k++){
                List<Integer> list = st.pop();
                i=list.get(0);
                j=list.get(1);
                for(int m=0 ; m<4 ; m++){
                    int x = i+dx[m], y=j+dy[m];
                    if(x>=0 && y>=0 && x<adjMatrix.length && y<adjMatrix[x].length && adjMatrix[x][y]=='.'){
                        adjMatrix[x][y]='#';
                        st.push(new ArrayList<>(List.of(x, y)));
                    }
                }
            }

        }
    }
}
