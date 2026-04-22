package cses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MessageRoute {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0 ; i<n+1 ; i++)list.add(new ArrayList<>());

        for(int i=0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        int[] parent = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        q.offer(1);
        parent[1] = 1;
        boolean found = false;

        while (!q.isEmpty()){
            int node = q.poll();
            for(int neighbour : list.get(node)){
                if(parent[neighbour]==0){
                    parent[neighbour]=node;
                    if(neighbour==n){
                        found=true;
                        break;
                    }
                    q.offer(neighbour);
                }
            }
        }

        if(!found){
            System.out.println("IMPOSSIBLE");
        }else{

            List<Integer> ans = new ArrayList<>();
            int i=n;
            while (parent[i]!=i){
                ans.add(i);
                i=parent[i];
                count++;
            }
            ans.add(i);
            count++;
            System.out.println(count);

            for(int j = ans.size()-1 ; j>=0 ; j--){
                System.out.print(ans.get(j)+ " ");
            }
        }
    }
}
