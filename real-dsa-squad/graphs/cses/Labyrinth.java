package cses;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class IndexPair{
    int x;
    int y;
    String path;

    public IndexPair(int x, int y, String str){
        this.x = x;
        this.y=y;
        path = str;
    }
}

public class Labyrinth {

    private static final int dx[] = new int[]{-1, 0, 0, 1};
    private static final int dy[] = new int[]{0, -1, 1, 0};
    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        char[][] matrix = new char[n][m];
        int startX = 0, startY=0;
        for(int i=0 ; i<n ; i++){
            String st = sc.next();
            for(int j=0 ; j<m ; j++){
                matrix[i][j]=st.charAt(j);
                if(matrix[i][j]=='A'){
                    startX = i;
                    startY = j;
                }
            }
        }

        String str = tracePath(matrix, startX, startY);
        if(str.isEmpty()){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.println(str.length());
            System.out.println(str);
        }

    }

    private static String tracePath(char[][] matrix, int startX, int startY) {

        Queue<IndexPair> st = new LinkedList<>();
        st.offer(new IndexPair(startX, startY, ""));
        matrix[startX][startY] = '#';

        while (!st.isEmpty()){
            int l=st.size();
            for(int k=0 ; k<l ; k++){
                IndexPair p = st.poll();
                int i= p.x, j=p.y;
                String path = p.path;
                if(matrix[i][j]=='B')return path;

                for(int z=0 ; z<4 ; z++){
                    int x = i+dx[z], y=j+dy[z];
                    if(x>=0 && x<matrix.length && y>=0 && y<matrix[x].length && matrix[x][y]!='#'){
                        if(matrix[x][y]!='B')matrix[x][y] = '#';
                        char c;
                        if(z==0)c='U';
                        else if(z==1)c='L';
                        else if(z==2)c='R';
                        else c='D';
                        st.offer(new IndexPair(x, y, path+c));
                    }
                }
            }
        }



        return "";
    }
}
