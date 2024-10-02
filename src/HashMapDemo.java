import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

  public static void show(HashMap<Integer, String> hashMap){
    Set<Integer> keySet = hashMap.keySet();
    for(Integer key: keySet){
      System.out.println(key + " - " + hashMap.get(key));
    }
  }

  public static void main(String[] args) {
    // khai bao va them phan tu vao hashmap
    HashMap<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1,"Java");
    hashMap.put(2, "Python");
    hashMap.put(3, "C++");
    hashMap.put(4, "Javascript");
    System.out.println(hashMap);
    //update hashMap
    hashMap.put(4,"GoLang");
    hashMap.remove(2);
    System.out.println("This is hash Map");
    show(hashMap);
    //iterator
    Iterator<Integer> itr = hashMap.keySet().iterator();
    while (itr.hasNext()){
      System.out.println(hashMap.get(itr.next()));
    }

    // HashSetDemo

    HashSet<String> setA = new HashSet<>();
    setA.add("Java");
    setA.add("Python");
    setA.add("C++");
    System.out.println(setA);
    // add all setB to set A
    HashSet<String> setB = new HashSet<>();
    setB.add("JavaScript");
    setB.add("Java");
    setA.addAll(setB);
    System.out.println(setA);
    //
    System.out.println(setA.size());
    System.out.println(setA.contains("Java")); // return true or false
    //iterator
    Iterator<String> iterator = setA.iterator();
    while (iterator.hasNext()){
      System.out.println(iterator.next());
    }
    for(String element: setA){
      System.out.println(element);
    }
    //remove and clear
    setA.remove("Java");
    //setA.clear();

    //ArrayList Demo
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("1");
    arrayList.add("2");
    arrayList.add("3");
    System.out.println(arrayList.get(1));
    arrayList.set(1,"Nam Doan");
    arrayList.remove(1);
    arrayList.contains("Nam Doan");
    System.out.println(arrayList.indexOf("Nam Doan")); // return the first or -1, last using lastIndexOf

  }
}
