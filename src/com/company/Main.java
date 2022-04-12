package com.company;

import java.io.IOException;
import java.util.*;

class Main {
    public static StringBuffer sortByFrequency(int arr1[], int l1) {
        // Строим карту элементов массива по ее количеству
        Map<Integer, Integer> countMap = getCountMap(arr1, l1);
        StringBuffer result = new StringBuffer();
        // Сортировка карты с использованием компаратора comparingByValue
        // строим результат, добавляя ключи количество раз к результату
        countMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
                .forEach(e -> {
                    int key = e.getKey();
                    int val = e.getValue();
                    for (int i = 0; i < val; i++) {
                        result.append(key + " ");
                    }
                });
        return result;
    }
    // вспомогательная функция для возврата карты количества элементов
    private static Map<Integer, Integer> getCountMap(int[] arr, int l1) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for (int i = 0; i < l1; i++) {
            if (countMap.containsKey(arr[i])) {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            } else {
                countMap.put(arr[i], 1);
            }
        }
        return countMap;
    }
    // Драйвер программы
    public static void main(String[] args) throws IOException {
        int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 };
        System.out.println(sortByFrequency(a, a.length));
    }
}