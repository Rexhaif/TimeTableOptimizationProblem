package xyz.rexhaif.ttop;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    public static void main(String[] args) {
        System.out.println("TimeTable Optimizer");
        System.out.println("Enter number of available meetings and starting minute and duration for each");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Pair<Integer, Integer>> meetings = new ArrayList<>();
        while (meetings.size() < n)
            meetings.add(new Pair<>(in.nextInt(), in.nextInt()));
        Comparator<Pair<Integer, Integer>> meetingComparator = (o1, o2) -> {
            int o1e = o1.getKey() + o1.getValue();
            int o2e = o2.getKey() + o2.getValue();
            return Math.max(Integer.compare(o1e, o2e), Integer.compare(o1.getValue(), o2.getValue()));
        };
        Collections.sort(meetings, meetingComparator);
        System.out.println("\n----------------------" +
                "\nReceived list of meetings: ");
        meetings.forEach(p -> System.out.print("Start time: " + p.getKey() + " | Duration: " + p.getValue() + "\n"));

        Queue<Pair<Integer, Integer>> queue = new ConcurrentLinkedDeque<>(meetings);
        List<Pair<Integer, Integer>> timetable = new ArrayList<>();
        timetable.add(queue.poll());
        int counter = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> meeting = queue.poll();
            Pair<Integer, Integer> prev = timetable.get(counter);
            if (!(meeting.getKey() > prev.getKey() + prev.getValue())) continue;
            counter++;
            timetable.add(meeting);
        }

        System.out.println("----------------------\n" +
                "Computed optimized timetable: ");
        timetable.forEach(p -> System.out.print("Start time: " + p.getKey() + " | Duration: " + p.getValue() + "\n"));
        System.out.println("-----------------------");
        System.out.println("Number of meetings: " + timetable.size());
    }
}
