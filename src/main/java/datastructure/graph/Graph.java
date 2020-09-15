package datastructure.graph;

import java.util.*;

public class Graph<T> {
    Map<Vertex, List<Vertex>> adjacents;


    public Graph() {
        this.adjacents = new HashMap<>();
    }

    public void addVertex(T data){
        adjacents.putIfAbsent(new Vertex(data), new ArrayList<>());
    }

    public void removeVertex(T data){
        Vertex<T> vertex = new Vertex<>(data);
        adjacents.values().stream().forEach(edges -> edges.remove(vertex));
        adjacents.remove(vertex);
    }

    public void addEdge(T data1, T data2){
        Vertex vertex1 = new Vertex(data1);
        Vertex vertex2 = new Vertex(data2);
        adjacents.get(vertex1).add(vertex2);
        adjacents.get(vertex2).add(vertex1);
    }

    public void removeEdge(T data1, T data2){
        Vertex<T> vertex1 = new Vertex<>(data1);
        Vertex<T> vertex2 = new Vertex<>(data2);
        List<Vertex> edges1 = adjacents.get(vertex1);
        List<Vertex> edges2 = adjacents.get(vertex2);
        if(edges1 != null){
            edges1.remove(vertex2);
        }
        if(edges2 != null){
            edges2.remove(vertex1);
        }
    }

    public List<Vertex> getAdjacentVertices(T data){
        return adjacents.get(new Vertex<>(data));
    }

    public List<Vertex> getVertices(){
        return new ArrayList<>(adjacents.keySet());
    }
}


