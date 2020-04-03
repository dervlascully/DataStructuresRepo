package projectCode20280.Practical_5_HashMaps;

import projectCode20280.Practical_4_PriorityQueues.Entry;
import projectCode20280.Practical_4_PriorityQueues.HeapPriorityQueue;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {

        /* Key: word, Value: frequency */
        ChainHashMap<String, Integer> wordCounter = new ChainHashMap<>();

        File file = new File("/Users/DervlaScully/Desktop/2nd Year Semester 2/Data Structures/datastructures-dervlascully/src/projectCode20280/Practical_5_HashMaps/sample_text");

        try {
            Scanner s = new Scanner(file);

            while (s.hasNext()){

                // read in word
                String word = s.next();

                // If the word has a ',' '.' '?' or '!' at the end then remove it
                char lastChar = word.charAt(word.length() - 1);
                if(lastChar == ',' || lastChar == '.' || lastChar == '?' || lastChar == '!' )
                    word = word.substring(0, word.length() - 2);

                // if this word has not already been added, add it and set its frequency to 1
                if(wordCounter.get(word) == null)
                    wordCounter.put(word, 1);

                // if this word is already in the chain hash map, increment its frequency counter
                else{
                    int count = wordCounter.get(word);
                    wordCounter.put(word, count + 1);
                }

            }

        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        /*
        To find the 10 most frequently occurring words in the file I used a HeapPriorityQueue,
        which I implemented in the previous practical.
        I iterated through the entries in my ChainHashMap 'wordCounter' and added each to the HeapPriorityQueue 'heap'.
        In wordCounter the word is the key and the frequency is the value.
        In heap the frequency is the key and the word is the value, as when an entry is added the frequency of the entry is used to compare.

        I then removed minimum entries from the heap until only 10 were remaining.
        For the remaining 10 entries I printed the word and frequency and removed the entry.
         */

        HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>();

        for(Entry<String, Integer> entry : wordCounter.entrySet()){
            heap.insert(entry.getValue(), entry.getKey()); // key is now the frequency and value is the word
        }

        while(heap.size() > 10)
            heap.removeMin();


        System.out.println("\n10 Most Frequent Words:\n[frequency, word]\n");
        while (heap.size() > 0) {
            String word = heap.removeMin().getValue();
            System.out.println("[" + wordCounter.get(word) + ", " + word + "]");
        }

    }


}
