package th.ac.kmutt.cpe.algorithm.thanaboon.sorting;

import java.util.ArrayList;

public class SortContext <T extends Comparable<T>> {
    private SortStrategy<T> strategy;
    
    public SortContext(SortStrategy<T> strategy){
        this.strategy = strategy;
    }

    public void SetStrategy(SortStrategy<T> strategy){
        this.strategy = strategy;
    }

    public void executeSearch(ArrayList<T> list){
        strategy.sort(list);
    }

    public SortStrategy<T> getStrategy(){
        return this.strategy;
    }
}
