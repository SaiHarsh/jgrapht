package org.jgrapht.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;

/**
 * A vertex-based representation of a simple path. The graph must be simple for
 * the vertices to uniquely determine a path. See {@link SimpleGraph}
 */
public class SimpleGraphPath<V, E>
    implements GraphPath<V, E>
{

    private SimpleGraph<V, E> graph;
    private List<V> vertices;

    /**
     * @param simpleGraph The simple graph where the path is.
     * @param vertices A list of vertices that make up the path.
     * @throws IllegalArgumentException if the vertices are not in the path or
     *         if they do not define a path in the graph.
     */
    public SimpleGraphPath(SimpleGraph<V, E> simpleGraph, List<V> vertices)
    {
        this.graph = simpleGraph;
        this.vertices = vertices;

        for (int i = 0; i < getVertexList().size() - 1; i++) {
            if (getGraph().getEdge(
                getVertexList().get(i),
                getVertexList().get(i + 1)) == null)
            {
                throw new IllegalArgumentException(
                    "The specified vertices do not form a path");
            }
        }

    }

    @Override
    public SimpleGraph<V, E> getGraph()
    {
        return this.graph;
    }

    @Override
    public V getStartVertex()
    {
        return this.getVertexList().get(0);
    }

    @Override
    public V getEndVertex()
    {
        return this.getVertexList().get(getVertexList().size() - 1);
    }

    @Override
    public List<E> getEdgeList()
    {
        List<E> result = new ArrayList<E>();
        for (int i = 0; i < getVertexList().size() - 1; i++) {
            result.add(this.getGraph().getEdge(
                getVertexList().get(i),
                getVertexList().get(i + 1)));
        }
        return result;
    }

    public List<V> getVertexList()
    {
        return vertices;
    }

    @Override
    public double getWeight()
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
