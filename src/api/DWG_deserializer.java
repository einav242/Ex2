package api;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Map;

 public class DWG_deserializer implements JsonDeserializer<DirectedWeightedGraph> {

     @Override
     public DirectedWeightedGraph deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException
     {
         JsonObject jsonObject = json.getAsJsonObject();
         DirectedWeightedGraph gr = new DWGraph();

         JsonArray nodes = jsonObject.get("Nodes").getAsJsonArray();
         for (JsonElement node : nodes)
         {
             int k = node.getAsJsonObject().get("id").getAsInt();
             String geo = node.getAsJsonObject().get("pos").getAsString();
             String[] arr = geo.split(",");
             double x = Double.parseDouble(arr[0]);
             double y = Double.parseDouble(arr[1]);
             double z = Double.parseDouble(arr[2]);
             GeoLocation geoLoc = new Location(x,y,z);
             NodeData n = new Node(k,geoLoc);
             gr.addNode(n);
         }

         JsonArray edges = jsonObject.get("Edges").getAsJsonArray();
         for (JsonElement edge : edges)
         {
             int src = edge.getAsJsonObject().get("src").getAsInt();
             double weight = edge.getAsJsonObject().get("w").getAsDouble();
             int dest = edge.getAsJsonObject().get("dest").getAsInt();
             gr.connect(src, dest, weight);
         }
         return (DWGraph) gr;
     }
    }
