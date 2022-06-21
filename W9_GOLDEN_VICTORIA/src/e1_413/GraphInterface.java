package e1_413;

public interface GraphInterface {

    int V();
    int E();
    Iterable<Integer> adjacent(int vertex);

}