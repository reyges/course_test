package ru.parsentev.task_017;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;

import java.util.*;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < values.length - 1; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                list.add(values[j]);
            }
            ArrayList<Integer> tmp = getMaxNominals(note, list);
            if (isNotContain(result, tmp)){
                result.add(tmp);
            }
            if (sum(result.get(result.size() - 1)) >= values[i + 1]) {
                result.add(
                        concat(values[i + 1],
                                getMaxNominals(note - values[i + 1], list)));
            }
        }
        for (ArrayList<Integer> l : result) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }

        return convert(result);
    }

    public static void main(String[] args) {
        CashMachine machine = new CashMachine(new int[]{1, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
    }

    public ArrayList<Integer> getMaxNominals(int note, ArrayList<Integer> values) {
        ArrayList<Integer> listBankNotes = new ArrayList<Integer>();
        ArrayList<Integer> valuesList = copy(values);
        while (valuesList.size() > 0) {
            Integer maxNom = getMax(valuesList);
            Integer minNom = getMin(valuesList);
            if (note >= maxNom) {
                while ((note / maxNom) > 0) {
                    listBankNotes.add(maxNom);
                    note -= maxNom;
                }
            }
            valuesList.remove(valuesList.indexOf(maxNom));
        }
        return listBankNotes;
    }

    private static ArrayList<Integer> convert(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : arr) {
            list.add(i);
        }
        return list;
    }

    private static int getMax(ArrayList<Integer> valuesList) {
        return new Integer(Collections.max(valuesList));
    }

    private static int getMin(ArrayList<Integer> valuesList) {
        return new Integer(Collections.min(valuesList));
    }

    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    private static ArrayList<Integer> concat(Integer a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(a);

        for (int i : b) {
            result.add(i);
        }
        return result;
    }

    private static ArrayList<Integer> copy(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i:list){
            result.add(i);
        }
        return result;
    }

    private static List<List<Integer>> convert(ArrayList<ArrayList<Integer>> in){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = in.size()-1; i >= 0; i--) {
            result.add(in.get(i));
        }
        return result;
    }

    private static boolean isNotContain(ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> intls){
        for (ArrayList<Integer> list: ls){
            if (list.equals(intls))
                return false;
        }
        return true;
    }
}
