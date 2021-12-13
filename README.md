# **Ex2**
### :pushpin: Design and implementation of directed and weighted graphs in Java 

As part of this project, we can use a data structure and algorithms on graphs (oriented and weighted) when this program can create directional graphs and perform the following functions:

- **isConnected** - will returns true if and only if there is a valid path from each node to each other node
- **shortestPathDist** - Computes the length of the shortest path between src to dest 
- **shortestPath** - Computes the length of the shortest path between src to dest 

:bulb: the diffrent betwin **shortestPath** & **shortestPathDist** is in shortestPathDist Computes the length of the shortest path between src to dest and shortestPath will give you the list of nodes that you need to pass from src to dest (src--> n1-->n2-->...dest) .

- **Center** - Finds the NodeData which minimizes the max distance to all the other nodes Assuming the graph isConnected, elese return null.
- **TSP** - Computes a list of consecutive nodes which go over all the nodes in cities the sum of the weights of all the consecutive (pairs) of nodes (directed) is the "cost" of the solution the lower the better.

 ### Plan the realization of the project We'll realize First the **Main Classes and Methods** and after the Gui:

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

dring implementation of :
- **isConnected**  - we used BFS algorithm and after we reverse the BFS.
-  **shortestPathDist** -  we used dykstra algorithm 
- **TSP** - we used in function shortestPathDist  


## :bar_chart: Gui
### :pushpin: Implements a graphical interface that includes a menu that allows you to load graphs from files, save them, Edit them and run algorithms on them.

Main menu:

<img width="304" alt="Capture" src="https://user-images.githubusercontent.com/93201414/145433523-704aa77e-c1b3-47d7-90a5-c68e52f96728.PNG">

you can edit the Graph:

<img width="255" alt="Capture111" src="https://user-images.githubusercontent.com/93201414/145687733-304b8448-b02f-46b2-a7a5-1bedb65f95c7.PNG">


you can run algorithms on your Graph:

<img width="201" alt="Capture32" src="https://user-images.githubusercontent.com/93201414/145689825-a31b7cf8-efbb-45c1-a6c1-53675ec64778.PNG">


you can show your Graph:

G1.json Graph

![WhatsApp Image 2021-12-13 at 12 22 49](https://user-images.githubusercontent.com/93201414/145796734-b9116494-fdce-42f5-bceb-515cd7c385db.jpeg)




## Analysis of the performance of our algorithm On graphs size 1000, 10000, 1000000, 1000000 : 

### copy:
1000:247ms

10000:623ms

100000:5sec 853ms

1000000000:time out

### init:
1000:185ms

10000:549ms

100000:5sec 137ms

1000000000:time out

### isConnected():
1000:248ms

10000:733ms

100000:6 sec 494ms

1000000000:time out

### shortestPath:
1000:300ms

10000:2 sec 642ms

100000:timeout

1000000000:time out

### shortestPathDist:
1000:269ms

10000:1sec 639ms

100000:timeout

1000000000:time out

### center:
1000:11sec 2ms

10000:time out

100000:time out

1000000000:time out

### tsp:
1000:943ms

10000:20sec 357ms

100000:time out

1000000000:time out

### save:
1000:348 ms

10000:1sec 84ms

100000:11 sec 985ms

1000000000:time out

### load:
1000:218ms

10000:548ms

100000:4sec 952ms

1000000000:time out

## UML

![diagram-10609367768205094712](https://user-images.githubusercontent.com/93201414/145797297-fe072322-c96c-4a3b-b8d1-cb4f56a1b670.png)

