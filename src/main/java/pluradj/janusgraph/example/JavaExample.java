package pluradj.janusgraph.example;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.janusgraph.core.JanusGraph;
import org.janusgraph.core.JanusGraphFactory;
import org.janusgraph.core.attribute.Geo;
import org.janusgraph.core.attribute.Geoshape;
import org.janusgraph.example.GraphOfTheGodsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Map;

public class JavaExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaExample.class);

    public static void main(String[] args) {
        JanusGraph graph = JanusGraphFactory.open("conf/remote-graph.properties");
        GraphTraversalSource g = graph.traversal();

        Vertex v1 = g.addV("Person").property("name", "Aiman")
                .property("age", 23).property("gender", "M").next();

        g.tx().commit();
        
        LOGGER.info(v1.toString());
        System.exit(0);
    }
}
