package com.riversand.collectionframework;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class MapSortByValue {
    public static void main(String[] args) throws Exception {
        // Usecase 1
        groupTransactions(List.of("notebook", "notebook", "mouse", "keyboard", "mouse"));
        // Use case 2
        exampleGroupBy(List.of(
                new BlogPost("t1", "g", BlogPostType.GUIDE, 2),
                new BlogPost("t2", "s", BlogPostType.NEWS, 4),
                new BlogPost("t3", "t", BlogPostType.NEWS, 5),
                new BlogPost("t4", "r", BlogPostType.REVIEW, 10)
        ));
        // Use case 3
        List<String> l = Arrays.asList("a_1", "b_1", "c_5", "a_1", "b_1", "c_5");
        // o/p: [a:1, b:2, c:5] split string by "_" and find avg of the value
        System.out.println(splitStringByUnderScore(l));
    }

    private static void exampleGroupBy(List<BlogPost> blogPosts) {
        // Group by only key
        Map<BlogPostType, List<BlogPost>> likesPerType = blogPosts.stream().collect(groupingBy(BlogPost::getType));
        // Group by on key and value both to modify returned map value type
        Map<BlogPostType, Set<BlogPost>> likesPerTypeSet = blogPosts.stream().collect(groupingBy(BlogPost::getType, Collectors.toSet()));
        // Group by multiple key only


    }

    private static List<String> splitStringByUnderScore(List<String> l) {


        return l.stream()
                .collect(Collectors.groupingBy(
                        s-> s.split("_")[0],
                        Collectors.averagingDouble(s->Double.valueOf(s.split("_")[1]))
                )).entrySet().stream()
                .sorted(
                        Comparator.comparingDouble(es -> (double) ((Map.Entry)es).getValue())
                                .reversed()
                                .thenComparing(es -> ((Map.Entry)es).getKey().toString())
                )
                .map(es -> es.getKey()+ " : "+es.getValue().intValue())
                .collect(Collectors.toList());
    }

    public static List<String> groupTransactions(List<String> transactions) {
        Map<String, Long> groupedTransactions = transactions.stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        Set<Map.Entry<String, Long>> set = groupedTransactions.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(set);
        return null;
    }

    private static class BlogPost {
        private String title;
        private String author;
        private BlogPostType type;
        private int likes;

        public BlogPost(String title, String author, BlogPostType type, int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public BlogPostType getType() {
            return type;
        }

        public int getLikes() {
            return likes;
        }
    }

    enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }
}
