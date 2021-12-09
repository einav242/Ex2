# **Ex2**
### :pushpin: Design and implementation of directed and weighted graphs in Java 

As part of this project, we can use a data structure and algorithms on graphs (oriented and weighted) when this program can create directional graphs and perform the following functions:

- **isConnected** - will returns true if and only if there is a valid path from each node to each other node
- **shortestPathDist** - Computes the length of the shortest path between src to dest 
- **shortestPath** - Computes the length of the shortest path between src to dest 
:bulb: the diffrent betwin **shortestPath** & **shortestPathDist** is in shortestPathDist Computes the length of the shortest path between src to dest and shortestPath will give you the list of nodes that you need to pass from src to dest (src--> n1-->n2-->...dest)





## :heavy_check_mark: Main Classes and Methods:

Location class implemets GeoLocation

| Methods  | Details |
| ------------- | ------------- |
| `distance(GeoLocation g)`  | Returns the distance between two points  |

Node class implemets NodeData

| Methods  | Details |
| ------------- | ------------- |
| `getKey()`  |Returns the key (id) associated with this node |
| `getLocation()` | 	Returns the location of this node, if none return null  |
| `setLocation(GeoLocation p)` | 	Allows changing this node's location  |
| `getWeight()` | Returns the weight associated with this node  |
| `setWeight(double w)` | Allows changing this node's weight |
| `getInfo()` | 	Returns the remark (meta data) associated with this node|
| `setInfo(String s)` |Allows changing the remark (meta data) associated with this node |
| `getTag()` |	Temporal data |
| `setTag(int t)` | Allows setting the "tag" value for temporal marking an node  |

Edge class implemets EdgeData

| Methods  | Details |
| ------------- | ------------- |
| `getSrc()`| Returns The id of the source node of this edge |
| `getDest()` | 	Returns The id of the destination node of this edge  |
| `getWeight()` | Returns	the weight of this edge (positive value)  |
| `getInfo()` | Returns the remark (meta data) associated with this edge  |
|`setInfo(String s)`| Allows changing the remark (meta data) associated with this edge |
|` getTag() ` | 	Returns Temporal data , white = 0 |
| `setTag(int t)` |  setting the "tag" value for temporal marking an edge |

DWGraph class implements DirectedWeightedGraph:

| Methods  | Details |
| ------------- | ------------- |
| `getNode(int key)` | returns the node_data by the node_id |
| `getEdge(int src, int dest)`| returns the data of the edge (src,dest), null if none |
| `addNode(NodeData n)`|adds a new node to the graph with the given node_data |
| `connect(int src, int dest, double w)` | Connects an edge with weight w between node src to node dest |
| `nodeIter()` | This method returns an Iterator for the collection representing all the nodes in the graph |
| `edgeIter()` | This method returns an Iterator for all the edges in this graph |
| `edgeIter(int node_id)` |  This method returns an Iterator for edges getting out of the given node |
| `removeNode(int key)` | Deletes the node (with the given ID) from the graph |
| `removeEdge(int src, int dest)` | Deletes the edge from the graph |
| `nodeSize()` | Returns the number of vertices (nodes) in the graph|
| `edgeSize()` | Returns the number of edges |
| `getMC()` | Returns the Mode Count - for testing changes in the graph |

GraphAlgo class implements DirectedWeightedGraphAlgorithms:

| Methods  | Details |
| ------------- | ------------- |
| `init(DirectedWeightedGraph g)` | Inits the graph on which this set of algorithms operates on |
| `getGraph()`| 	Returns the underlying graph of which this class works  |
| `copy()`| Computes a deep copy of this weighted graph  |
| `isConnected()` | Returns true if and only if (iff) there is a valid path from each node to each other node  |
| `shortestPathDist(int src, int dest)` | Computes the length of the shortest path between src to dest |
| `shortestPath(int src, int dest)` | Computes the the shortest path between src to dest|
| `center()` |  Finds the NodeData which minimizes the max distance to all the other nodes |
| `tsp(List<NodeData> cities)` | Computes a list of consecutive nodes which go over all the nodes in cities |
| `save(String file)` |  Saves this weighted (directed) graph to the given file name - in JSON format |
| `load(String file)` |  This method loads a graph to this graph algorithm |

:pushpin:  
