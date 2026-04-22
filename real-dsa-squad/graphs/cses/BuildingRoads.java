package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BuildingRoads {

    public static void main(String[] args) throws Exception {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<n+1 ; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        int[] visited = new int[n+1];
        int count =0;
        List<Integer> components = new ArrayList<>();
        for(int i=1 ; i<n+1 ; i++){
            if(visited[i]==0){
                count++;
                components.add(i);

                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i]=1;
                while (!q.isEmpty()){
                    int node = q.poll();
                    for(int neighbour : list.get(node)){
                        if(visited[neighbour]==0){
                            visited[neighbour]=1;
                            q.offer(neighbour);
                        }
                    }
                }
            }
        }
        System.out.println(count-1);
        for(int i=1 ; i<components.size() ; i++){
            System.out.println(components.get(i-1) + " " + components.get(i));
        }

    }

}
