package designPattern;

import java.util.ArrayList;
import java.util.List;

interface SortStrategy{
  <T> void sort(List<T> items);
}

class QuickSort implements SortStrategy{

  @Override
  public <T> void sort(List<T> items) {
    System.out.println("Quick Sort");
  }
}

class MergeSort implements SortStrategy{

  @Override
  public <T> void sort(List<T> items) {
    System.out.println("Merge Sort");
  }
}

class BubbleSort implements SortStrategy{

  @Override
  public <T> void sort(List<T> items) {
    System.out.println("Bubble Sort");
  }
}

class SortList{
  private SortStrategy sortStrategy;
  List<String> items = new ArrayList<>();
  public void setSortStrategy(SortStrategy sortStrategy) {
    this.sortStrategy = sortStrategy;
  }

  public void sort(){
    sortStrategy.sort(items);
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
    sortList.setSortStrategy(sort2 );
    sortList.sort();
  }
}
