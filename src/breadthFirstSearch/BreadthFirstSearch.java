package breadthFirstSearch;

import java.util.LinkedList;

class Vertex
{
    public final String name;
    public Vertex[] adjacencies;
    public Integer distance = null;
    public Vertex parent = null;
    public String color = "white";
    public Vertex(String argName) { name = argName; }
}

public class BreadthFirstSearch {

        public static void BFS(Vertex source) {
            Vertex u;
            source.color = "gray";
            source.distance = 0;
            source.parent = null;
            LinkedList<Vertex> vertexQueue = new LinkedList<Vertex>();
            vertexQueue.add(source);
            while (!vertexQueue.isEmpty()) {
                u = vertexQueue.poll();
                for (Vertex v: u.adjacencies) {
                    if (v.color.equals("white")) {
                        v.color = "gray";
                        v.distance = u.distance + 1;
                        v.parent = u;
                        vertexQueue.add(v);
                    }
                }
                u.color = "black";
            }
        }
                

    public static void main(String[] args) {
        Vertex v0 = new Vertex("Redvile");
	Vertex v1 = new Vertex("Blueville");
	Vertex v2 = new Vertex("Greenville");
	Vertex v3 = new Vertex("Orangeville");
	Vertex v4 = new Vertex("Purpleville");

	v0.adjacencies = new Vertex[]{ v1, v2, v3 };
	v1.adjacencies = new Vertex[]{ v0, v2, v4 };
	v2.adjacencies = new Vertex[]{ v0, v1 };
	v3.adjacencies = new Vertex[]{ v0, v4 };
	v4.adjacencies = new Vertex[]{ v1, v3 };
        
        BFS(v0);
        System.out.println(v0.name + "distance: " + v0.distance.toString());
        System.out.println(v1.name + "distance: " + v1.distance.toString());
        System.out.println(v2.name + "distance: " + v2.distance.toString());
        System.out.println(v3.name + "distance: " + v3.distance.toString());
        System.out.println(v4.name + "distance: " + v4.distance.toString());
    }
}
