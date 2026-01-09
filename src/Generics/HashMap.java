package Generics;
import javax.swing.text.html.parser.Entity;
import java.util.*;
 class Map {
    public static void main(String[] args) {
       HashMap<String, Integer> map = new HashMap<>();
       map.put("Tinku", 2);
       map.put("Mush", 1);
       map.put("Muskan", 3);
        System.out.println(map.get("Mush"));

        // remove auto-mattyle duplacted data
        HashSet<Integer> set = new HashSet<>();
         set.add(4);
         set.add(5);
         set.add(5);
         set.add(6);
         set.add(7);
         set.add(56);
         set.add(9);
        set.add(7);

        System.out.println(set);

       TreeMap<String, Integer> map1 = new TreeMap<>();
       map1.put("Hi", 5);
       map1.put("Hi", 1);
       map1.put("Hii", 2);
        System.out.println(map1.containsKey("Hii"));

        MapUsingHash mapUsingHash = new MapUsingHash();
        mapUsingHash.put("Chiku", "Nick name");
        mapUsingHash.put("Mango", "King of fruit");
        mapUsingHash.put("Banana", "Health fruit");
        System.out.println(mapUsingHash.get("Mango"));
    }
}
    class MapUsingHash{
     private Entity[] entities;

     public MapUsingHash(){
         entities = new Entity[100];
     }

     public void put(String key, String value){
         int hash = Math.abs(key.hashCode() % entities.length);
         entities[hash] = new Entity(key, value); // overriding
     }

     public String get (String key){
         int hash = Math.abs(key.hashCode() % entities.length);
         if (entities[hash] != null && entities[hash].key.equals(key)){
             return entities[hash].value;
         }
         return null;
     }

     public void remove(String key){
         int hash = Math.abs(key.hashCode() % entities.length);
         if (entities[hash] != null && entities[hash].key.equals(key)){
             entities[hash] = null;
         }
     }
     private class Entity{
         String key;
         String value;

         public Entity(String key, String value) {
             this.key = key;
             this.value = value;
         }
     }
    }






