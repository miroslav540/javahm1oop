package FamilyTree;

import java.util.ArrayList;

public class Program {
  public static void main(String[] args) {
  var olya = new Person("Оля");
  var vasya = new Person("Вася");
  var masha = new Person("Маша");
  var kate = new Person("Катя");
  var ivan = new Person("Ваня");
  GeoTree gt = new GeoTree();
  gt.append(olya, vasya);
  gt.append(olya, masha);
  gt.append(vasya, kate);
  gt.append(vasya, ivan);
  
  System.out.println(new Reserch(gt).spend(olya,
                     Relationship.parent));
  }
}
enum Relationship {
  parent,
  children
}

class Person {
  public String fullName;
  public String getFullName() {
    return fullName;
  }

  public Person(String fullName) {
    this.fullName = fullName;
  }
}
  
class Node {
  public Node(Person p1, Relationship re, Person p2) {
       this.p1 = p1;
       this.re = re;
       this.p2 = p2;
   }

   Person p1;
   Relationship re;
   Person p2;

   @Override
   public String toString() {
       return String.format("<%s %s %s>", p1, re, p2);
   }
}

class GeoTree {
  private ArrayList<Node> tree = new ArrayList<>();
  public ArrayList<Node> getTree() {
    return tree;
  }

  public void append(Person parent, Person children) {
    tree.add(new Node(parent, Relationship.parent, children));
    tree.add(new Node(children, Relationship.children, parent));
  }
}

class Reserch {
  ArrayList<Node> tree;
  public Reserch(GeoTree geoTree) {
    tree = geoTree.getTree();
  }
  
  public ArrayList<Person> spend(Person p, Relationship re) {
    ArrayList<Person> result = new ArrayList<>();
    for (Node t : tree) {
      if (t.p1.fullName == p.fullName && t.re == re) {
        result.add(t.p2);
      }
    }
    return result;
  }
}

class Reserch2 {
// ...
}

class Reserch3 {
// ...
}

class Printer {
// ...
}