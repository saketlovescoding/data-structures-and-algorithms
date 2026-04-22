package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BuildingTeams {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<n+1 ; i++)list.add(new ArrayList<>());

        for(int i=0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        int[] color = new int[n+1];
        boolean flag = true;

        for(int i=1 ; i<n+1 ; i++){
            if(color[i]==0){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 1;

                while (!q.isEmpty() && flag){
                    int node = q.poll();
                    for(int neighbour : list.get(node)){
                        if(color[node]==color[neighbour]){
                            flag=false;break;
                        }
                        if(color[neighbour]==0){
                            int nextCol=1;
                            if(color[node]==1)nextCol++;
                            color[neighbour]=nextCol;
                            q.offer(neighbour);
                        }
                    }
                }
            }
        }

        if(!flag) System.out.println("IMPOSSIBLE");
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=1 ; i<color.length ; i++){
                sb.append(color[i]).append(" ");
            }
            System.out.println(sb);
        }


    }
}
