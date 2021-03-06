package edu.yu.introtoalgs;

/**
 * @author Tom Bohbot
 * @version October 29, 2020
 * MergeAnInterval Assignment - Intro To Algorithms
 */
import java.util.*;

public class MergeAnInterval {

  /** An immutable class, holds a left and right integer-valued pair that
   * defines a closed interval
   */
  public static class Interval implements Comparable<Interval>{
    public final int left;
    public final int right;

    /** Constructor
     * 
     * @param left the left endpoint of the interval
     * @param right the right endpoint of the interval
     */
    public Interval(int l, int r) {
      this.left = l;
      this.right = r;
    }

    @Override
    public int compareTo(Interval o) {
      int left = o.left;
      if (this.left < left) {
        return -1;
      }
      return 1;
    }

    @Override 
    public boolean equals (Object that) {
      if (this == that) {
        return true;
      }
      if (that == null) {
        return false;
      }
      if (this.getClass() != that.getClass() ) {
        return false;
      }
      Interval thatInterval = (Interval) that;
      if (thatInterval.left == this.left && thatInterval.right == this.right) {
        return true;
      }
      return false;
    }
    
    @Override 
    public int hashCode () {
      return this.left;
    }
    // fill in the rest yourself!
  } // Interval class

  /** Merges the new interval into an existing set of disjoint intervals.
   *
   * @param intervals the existing set of intervals
   * @param newInterval the interval to be added
   * @return a new set of disjoint intervals containing the original intervals
   * and the new interval, merging the new interval if necessary into existing
   * interval(s), to preseve the "disjointedness" property.
   */
  public static Set<Interval> merge (final Set<Interval> intervals, Interval newInterval) {
    if(intervals == null || newInterval == null) {
      throw new IllegalArgumentException("Input cannot be null.");
    }
    if (newInterval.left >= newInterval.right) {
      throw new IllegalArgumentException("left side must be less than right side.");
    }
    boolean hasMerged = false;
    // make a copy of intervals so that I can modify a set initially set to final:
    HashSet <Interval> calendar = (HashSet<Interval>) intervals; 
    HashSet <Interval> iterateThrough = new HashSet <Interval>();
    // This is to avoid a compile time issue: O(n) operation
    for (Interval interval : intervals) { 
      if (interval == null) {
        throw new IllegalArgumentException("Interval cannot be null.");
      }
      if (interval.left >= interval.right) {
        throw new IllegalArgumentException("left side must be less than right side.");
      }      
      iterateThrough.add(interval);
    }
    // Constant Operations:
    if (intervals.size() == 0) {
      calendar.add(newInterval);
      return calendar;
    }
    // loop through intervals to check if merges must be made. O(n) operation. In loop are only O(1) operations, potentially amortized O(n) ops.
    for (Interval interval : iterateThrough) {
      int beginning = interval.left;
      int end = interval.right;
      // the case that an interval is a subset of another no changes need to be made:
      if (newInterval.left >= beginning && newInterval.right <= end) {
        return intervals;
      }
      // If right end is included in interval:
      if (newInterval.right >= beginning && newInterval.right <= end) {
        // a merge must take place:
        if (newInterval.left < beginning) {
          calendar.remove(interval);
          if (hasMerged == true) { calendar.remove(newInterval); }
          Interval updateLeftSide = new Interval(newInterval.left , end);
          calendar.add(updateLeftSide);
          newInterval = updateLeftSide;
          hasMerged = true;
        }
      }
      // If left end is included in interval:
      if (newInterval.left >= beginning && newInterval.left <= end) {
        if (newInterval.right > end) {
          calendar.remove(interval);
          if (hasMerged == true) { calendar.remove(newInterval); }
          Interval updateRightSide = new Interval(beginning , newInterval.right);
          calendar.add(updateRightSide);
          newInterval = updateRightSide;
          hasMerged = true;
        }
      }
      // If new interval swallows old interval:
      if (newInterval.left <= beginning && newInterval.right >= end) {
        calendar.remove(interval);
        calendar.add(newInterval);
        hasMerged = true;
      }
    }
    // If a new interval must be added b/c it does not intersect:
    if (hasMerged == false) {
      calendar.add(newInterval);
    }
    // Sorting the return variable: O(nlogn) Sorting is unnessary per Piazza post Question 90, so muting out following code. 
    // LinkedList <Interval> sortedCalendar = new LinkedList <Interval> (calendar);
    // Collections.sort(sortedCalendar);
    // LinkedHashSet <Interval> finalSortedCalendar = new LinkedHashSet <Interval> (sortedCalendar);
    return calendar;
  }


}
