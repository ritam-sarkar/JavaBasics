package com.riversand.collectionframework;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.util.stream.IntStream;

public class BloomFilterDemo {
    public static void main(String[] args) {
        // expectedinsertions = 10000 values can be inserted maximum, fpp 0.01 means 0.01 is the probability of being false positive
        // means when the result returns true there will be 1 % chance of wrong answer
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),10000, 0.01);
        IntStream.range(100,9999).forEach(i->bloomFilter.put(i));
        System.out.println(bloomFilter.mightContain(14));
        System.out.println(bloomFilter.mightContain(101));
        System.out.println(bloomFilter.mightContain(1000));
        System.out.println(bloomFilter.mightContain(2000));
        System.out.println(bloomFilter.mightContain(90000000));
        System.out.println(bloomFilter.mightContain(9999));


    }

}
