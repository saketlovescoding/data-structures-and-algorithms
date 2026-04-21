package cses;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class IndexPair{
    int x;
    int y;

    public IndexPair(int x, int y){
        this.x = x;
        this.y=y;
    }
}

public class Labyrinth {

    private static final int dx[] = new int[]{-1, 0, 0, 1};
    private static final int dy[] = new int[]{0, -1, 1, 0};
    private static final char direction[] = new char[]{'U', 'L', 'R', 'D'};
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        char[][] matrix = new char[n][m];
        int startX = 0, startY=0, endX=0, endY=0;
        for(int i=0 ; i<n ; i++){
            String st = sc.next();
            for(int j=0 ; j<m ; j++){
                matrix[i][j]=st.charAt(j);
                if(matrix[i][j]=='A'){
                    startX = i;
                    startY = j;
                }
                if(matrix[i][j]=='B'){
                    endX=i;
                    endY=j;
                }
            }
        }

        int[][] pathDirection = new int[matrix.length][matrix[startX].length];
        Queue<IndexPair> st = new LinkedList<>();
        st.offer(new IndexPair(startX, startY));
        matrix[startX][startY] = '#';

        boolean found=false;

        while (!st.isEmpty()){
            int l=st.size();
            for(int k=0 ; k<l ; k++){
                IndexPair p = st.poll();
                int i= p.x, j=p.y;
                if(i==endX && j==endY){
                    found=true;
                    break;
                }

                for(int z=0 ; z<4 ; z++){
                    int x = i+dx[z], y=j+dy[z];
                    if(x>=0 && x<matrix.length && y>=0 && y<matrix[x].length && matrix[x][y]!='#'){
                        matrix[x][y] = '#';
                        pathDirection[x][y]=z;
                        st.offer(new IndexPair(x, y));
                    }
                }
            }
        }
        if(!found){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            int currX = endX, currY = endY;

            while (currX!=startX || currY!=startY){
                int dir = pathDirection[currX][currY];
                sb.append(direction[dir]);

                currX = currX -dx[dir];
                currY = currY - dy[dir];
            }

            System.out.println(sb.toString().length());
            System.out.println(sb.reverse());
        }

    }
}
