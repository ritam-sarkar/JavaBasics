package com.riversand.collectionframework;

import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		Map<String, Integer> countMap = new ConcurrentHashMap<String, Integer>();
		Map<String, Double> priceMap = new ConcurrentHashMap<String, Double>();
		@Override
		public void putNewPrice(String symbol, double price) {
			synchronized(countMap) {
				if(countMap.containsKey(symbol)) {
					Integer count = countMap.get(symbol);
					count++;
					countMap.put(symbol, count);
				}else {
					countMap.put(symbol, 1);
				}
			}
			synchronized (priceMap) {
				if(priceMap.containsKey(symbol)) {
					Double p = priceMap.get(symbol);
					p = p+price;
					priceMap.put(symbol, p);
					
				}else {
					priceMap.put(symbol, price);
				}
			}
			
			
			
		}

		@Override
		public double getAveragePrice(String symbol) {
			double avg = priceMap.get(symbol) / countMap.get(symbol);
			return avg;
			
		}

		@Override
		public int getTickCount(String symbol) {
			return countMap.get(symbol);
		}
		
		
	}
	

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}
