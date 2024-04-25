//package com.codility;
//
//import java.util.*;
//import java.util.stream.*;
//
//class VisitCounter {
//
//    Map<Long, Long> count(Map<String, UserStats>... visits) {
//        if (visits == null || visits.length == 0) {
//            return Collections.emptyMap();
//        }
//
//        return Arrays.stream(visits)
//                .filter(Objects::nonNull)
//                .flatMap(map -> map.entrySet().stream())
//                .filter(entry -> Objects.nonNull(entry.getKey())   && Objects.nonNull(entry.getValue() ) && entry.getValue().getVisitCount().isPresent())
//                .map(entry -> new AbstractMap.SimpleEntry<>(parseLong(entry.getKey()), entry.getValue().getVisitCount().get()))
//                .filter(entry -> entry.getKey() != null) // Filter out non-parseable keys
//                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)));
//    }
//
//    private Long parseLong(String s) {
//        try {
//            return Long.parseLong(s);
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}