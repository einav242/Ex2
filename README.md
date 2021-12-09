# **Ex2**
### :pushpin: Design and implementation of directed and weighted graphs in Java 




## The First part:

Location class implemets GeoLocation

| Methods  | Details |
| ------------- | ------------- |
| distance(GeoLocation g)  | Returns the distance between two points  |

Node class implemets NodeData

| Methods  | Details |
| ------------- | ------------- |
| 'getKey()'  |Returns the key (id) associated with this node |
| getLocation()  | 	Returns the location of this node, if none return null  |
| setLocation(GeoLocation p) | 	Allows changing this node's location  |
| getWeight()  | Returns the weight associated with this node  |
| setWeight(double w))  | Allows changing this node's weight |
| getInfo()  | 	Returns the remark (meta data) associated with this node|
| setInfo(String s) |Allows changing the remark (meta data) associated with this node |
| getTag()) |	Temporal data |
| setTag(int t)) | Allows setting the "tag" value for temporal marking an node  |

Edge class implemets EdgeData

| Methods  | Details |
| ------------- | ------------- |
| getSrc()  | Returns The id of the source node of this edge |
| getDest()  | 	Returns The id of the destination node of this edge  |
| getWeight() | Returns	the weight of this edge (positive value)  |
| getInfo()  | Returns the remark (meta data) associated with this edge  |
| setInfo(String s)  | Allows changing the remark (meta data) associated with this edge |
| getTag()  | 	Returns Temporal data , white = 0 |
| setTag(int t) |  setting the "tag" value for temporal marking an edge |

DWGraph class implements DirectedWeightedGraph:

| Methods  | Details |
| ------------- | ------------- |
| getSrc()  | Returns The id of the source node of this edge |
| getDest()  | 	Returns The id of the destination node of this edge  |
| getWeight() | Returns	the weight of this edge (positive value)  |
| getInfo()  | Returns the remark (meta data) associated with this edge  |
| setInfo(String s)  | Allows changing the remark (meta data) associated with this edge |
| getTag()  | 	Returns Temporal data , white = 0 |
| setTag(int t) |  setting the "tag" value for temporal marking an edge |

:pushpin:  
