import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Maze
 */
public class Maze {
    private int[][] maze;

    public Maze() {
        this.maze = new int[][] {
                { 0, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0 },
        };

        Celda inicio = new Celda(0, 0);
        Celda fin = new Celda(2, 0);
        List<Celda> camino = new ArrayList<>();
        Set<Celda> visitados = new HashSet<>();

        boolean encontrado = findPath(
                maze, inicio, fin, visitados, camino);
        if (encontrado) {
            System.out.println("Camino encontrado");
            printMazeWithPath(visitados, camino);

            System.out.println("Celdas del camino");
            System.out.println(camino);
        } else {
            System.out.println("No existe un camino");
        }

    }

    private void printMazeWithPath(Set<Celda> visitados, List<Celda> camino) {
        System.out.println("Camino encontrado:");

        for (int i = 0; i < maze.length; i++) {

            for (int j = 0; j < maze[0].length; j++) {

                Celda actual = new Celda(i, j);

                if (camino.contains(actual)) {
                    System.out.print("*  ");
                } else if (maze[i][j] == 1) {
                    System.out.print("#  ");
                } else {
                    System.out.print(".  ");
                }
            }
            System.out.println();
        }

    }

    private boolean findPath(int[][] maze, Celda inicio, Celda fin,
            Set<Celda> visitados, List<Celda> camino) {

        int fila = inicio.getX();
        int columan = inicio.getY();

        if (fila < 0 || fila >= maze.length || columan < 0 || columan >= maze[0].length) {
            return false;
        }

        if (maze[fila][columan] == 1) {
            return false;
        }

        if (visitados.contains(inicio)) {
            return false;
        }

        visitados.add(inicio);
        camino.add(inicio);

        if (inicio.equals(fin)) {
            return true;
        }


        
        Celda derecha = new Celda(fila, columan + 1);
        if (findPath(maze, derecha, fin, visitados, camino)) {
            return true;
        }
        

        Celda abajo = new Celda(fila + 1, columan);
        if (findPath(maze, abajo, fin, visitados, camino)) {
            return true;
        }
        
        Celda izquierda = new Celda(fila, columan - 1);
        if (findPath(maze, izquierda, fin, visitados, camino)) {
            return true;
        }
        
        Celda arriba = new Celda(fila - 1, columan);
        if (findPath(maze, arriba, fin, visitados, camino)) {
            return true;
        }

        // Backtracking
        camino.remove(camino.size() - 1);
        return false;
    }

}
