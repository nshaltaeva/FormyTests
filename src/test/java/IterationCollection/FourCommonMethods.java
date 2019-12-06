package IterationCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FourCommonMethods {

   //reusable dynamic method
    public List<String> Datalist(){
        //order is matter
        //duplicates are allows
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Mustafa");
        names.add("Mehmet");
        names.add("Tugba");
        names.add("Talha");
        names.add("Serkan");
     //   System.out.println(names);
        return names;
    }

    public List<Integer> DataNumbers(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        return numbers;

    }
    @Test
    public void ClassicForLoop(){
        System.out.println(Datalist());
        System.out.println("Size is: "+Datalist().size());
        System.out.println("First index: "+Datalist().get(1));

        List<String> myDataNames = new ArrayList<>(Datalist());
        System.out.println(myDataNames);
        for(int i=0; i<myDataNames.size();i++){
            System.out.println(myDataNames.get(i));
        }
    }

    @Test //lambda expression
    public void ForEachMethod(){
        List<String> data = new ArrayList<>(Datalist());
        data.forEach(item -> System.out.println(item));

        List<Integer> data2 = new ArrayList<>(DataNumbers());
        data2.forEach(x -> System.out.println("Number: "+x));
    }

    @Test
    public void IteratorMethod(){
        Iterator<String> iterator = Datalist().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Iterator<Integer> iterator2 = DataNumbers().iterator();
        while (iterator2.hasNext()){
            System.out.println("Number: "+ iterator2.next());
        }
    }

    @Test
    public void ForEachMethod2(){
        List<String> data = new ArrayList<>(Datalist());
        for(String item: data){
            System.out.println(item);
        }

        for(Integer numbers: DataNumbers()){
            System.out.println(numbers);
        }
    }
}
