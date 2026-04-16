
public class Main {
    public static void main(String[] args) {
//        AdjacencyMatrix matrix = new AdjacencyMatrix(4);
//        matrix.addEdge(0, 1);
//        matrix.addEdge(0, 2);
//        matrix.addEdge(1, 3);
//        matrix.print();

        AdjacencyList list = new AdjacencyList(4);
        list.addEdge(0, 1);
        list.addEdge(0, 2);
        list.addEdge(1, 3);
        list.print();
    }
}