
public class AdjacencyMatrix {

    private int[][] matrix;
    private int vertices;

    public AdjacencyMatrix(int vertices){
        this.vertices = vertices;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
        matrix[dest][src] = 1;
    }

    public void print(){
        System.out.println("Adjacency Matrix");
        for(int i=0 ; i<vertices ; i++){
            for(int j=0 ; j<vertices ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}