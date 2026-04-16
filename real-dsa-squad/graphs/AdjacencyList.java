import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    private List<List<Integer>> adjList;
    private int vertices;

    public AdjacencyList(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for(int i=0 ; i<vertices ; i++){
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    public void print(){
        System.out.println("Adjacency List");
        for(int i=0 ; i<adjList.size() ; i++){
            System.out.print(i + ": ");
            for(int j=0 ; j<adjList.get(i).size() ; j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
