package designPattern;

import java.util.ArrayList;
import java.util.List;

interface SortStrategy{
  void sort();
}

class QuickSort implements SortStrategy{

  @Override
  public void sort() {
    System.out.println("Quick Sort");
  }
}

class MergeSort implements SortStrategy{

  @Override
  public void sort() {
    System.out.println("Merge Sort");
  }
}

class BubbleSort implements SortStrategy{

  @Override
  public void sort() {
    System.out.println("Bubble Sort");
  }
}

class SortList{
  private SortStrategy sortStrategy;
  List<String> strings = new ArrayList<>();
  public void setSortStrategy(SortStrategy sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  public void sort(){
    sortStrategy.sort();
  }

}

public class StrategyPattern {

  public static void main(String[] args) {
    SortStrategy sort1 = new QuickSort();
    SortStrategy sort2 = new MergeSort();
    SortStrategy sort3 = new BubbleSort();
    SortList sortList= new SortList();
    sortList.setSortStrategy(sort1);
    sortList.sort();
    sortList.setSortStrategy(sort2);
    sortList.sort();
  }
}
