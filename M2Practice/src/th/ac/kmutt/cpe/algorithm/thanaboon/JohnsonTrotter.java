package th.ac.kmutt.cpe.algorithm.thanaboon;

import java.util.ArrayList;
import java.util.Collections;

import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.QuickSort;
import th.ac.kmutt.cpe.algorithm.thanaboon.sorting.SortContext;

public class JohnsonTrotter {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> order = new ArrayList<>();
        SortContext<Integer> sorter = new SortContext<>(new QuickSort<Integer>());
        sorter.executeSort(list);
        ArrayList<Integer> direction = new ArrayList<>();
        order.add(new ArrayList<>(list));
        for (int i = 0; i < list.size(); i++) {
            direction.add(-1);
        }
        int k;
        do{
            k = checkMobile(list, direction);
            if(k == -1){
                break;
            }

            int mobileVal = list.get(k);
            int swapper = direction.get(k)+k;
            Collections.swap(list, k, swapper);
            Collections.swap(direction, k, swapper);
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j) > mobileVal){
                    direction.set(j,direction.get(j)*-1);
                }
            }
            order.add(new ArrayList<>(list));
        }while(true);
        return order;
    }

    public int checkMobile(ArrayList<Integer> curOrder,ArrayList<Integer> dir){
        int mobile = -1;
        int mobileVal = Integer.MIN_VALUE;
        for (int i = 0; i < curOrder.size() ; i++) {
            int cur = curOrder.get(i);
            int curdir = dir.get(i);
            int next = i + curdir;
            if(next >=  0 &&  next < curOrder.size()){
                if(cur > curOrder.get(next) && cur > mobileVal){
                    mobile = i;
                    mobileVal = cur;
                }
            }
        }
        return mobile;
    }
}
