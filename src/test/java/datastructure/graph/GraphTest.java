package datastructure.graph;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GraphTest {

    @Test
    public void shouldAddVerticesToGraph() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        assertThat(graph.getVertices()).containsExactlyInAnyOrder(new Vertex<>(1), new Vertex<>(2), new Vertex<>(3));
    }

    @Test
    public void shouldAddEdgesToVertice() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertThat(graph.getAdjacentVertices(1)).containsExactlyInAnyOrder(new Vertex<>(2), new Vertex<>(3));
        assertThat(graph.getAdjacentVertices(2)).containsExactlyInAnyOrder(new Vertex<>(1));
        assertThat(graph.getAdjacentVertices(3)).containsExactlyInAnyOrder(new Vertex<>(1));
    }

    @Test
    public void shouldRemoveVertexWhenItExistsInGraphAndDoesNotHaveAdjacents() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);

        graph.removeVertex(2);
        assertThat(graph.getVertices()).containsExactlyInAnyOrder(new Vertex<>(1));
    }

    @Test
    public void shouldRemoveVertexWhenItExistsInGraphAndHasAdjacents() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.removeVertex(1);
        assertThat(graph.getVertices()).containsExactlyInAnyOrder(new Vertex<>(2), new Vertex<>(3));
    }

    @Test
    public void shouldLeaveGraphUntouchedWhenTryingToRemoveVertexThatDoesntExist() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);

        graph.removeVertex(99);
        assertThat(graph.getVertices()).containsExactlyInAnyOrder(new Vertex<>(1), new Vertex<>(2));
    }

    @Test
    public void shouldDeleteEdgesWhenRemovingAVertex() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        graph.removeVertex(2);
        assertThat(graph.getAdjacentVertices(2)).isNull();
        assertThat(graph.getAdjacentVertices(1)).containsExactlyInAnyOrder(new Vertex<>(3));
        assertThat(graph.getAdjacentVertices(3)).containsExactlyInAnyOrder(new Vertex<>(1));
    }

    @Test
    public void shouldRemoveEdgeBetweenTwoExistingVertices() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.removeEdge(1, 3);
        assertThat(graph.getAdjacentVertices(1)).containsExactlyInAnyOrder(new Vertex<>(2));
        assertThat(graph.getAdjacentVertices(2)).containsExactlyInAnyOrder(new Vertex<>(1), new Vertex<>(3));
        assertThat(graph.getAdjacentVertices(3)).containsExactlyInAnyOrder(new Vertex<>(2));

    }

    @Test
    public void shouldLeaveGraphUntouchedWhenTryingToRemoveEdgeThatDoesntExist() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        graph.removeEdge(1, 99);
        assertThat(graph.getAdjacentVertices(1)).containsExactlyInAnyOrder(new Vertex<>(2), new Vertex<>(3));
        assertThat(graph.getAdjacentVertices(2)).containsExactlyInAnyOrder(new Vertex<>(1), new Vertex<>(3));
        assertThat(graph.getAdjacentVertices(3)).containsExactlyInAnyOrder(new Vertex<>(1), new Vertex<>(2));

    }
}