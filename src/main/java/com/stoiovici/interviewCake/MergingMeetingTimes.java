package main.java.com.stoiovici.interviewCake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MergingMeetingTimes {
  ArrayList<MergingMeetingTimes.Meeting> getAvailableSlots(HashMap<Integer, Boolean> unavailableSlots){
    ArrayList<MergingMeetingTimes.Meeting> availableSlots = new ArrayList();
    Object[] array = unavailableSlots.keySet().toArray();


    return availableSlots;
  }

  public static HashMap<Integer, Boolean> getMap(ArrayList<MergingMeetingTimes.Meeting> meetings) {
    HashMap<Integer, Boolean> slotMap = new HashMap<>();
    //Hashtable<Integer, Boolean> slotTable  = new Hashtable<>(); // if multithreading
    for (MergingMeetingTimes.Meeting meeting : meetings){
      int diff = meeting.getEndTime() - meeting.getStartTime();
      for (int i=0; i<diff; i++) {
        if (!slotMap.containsKey(meeting.getStartTime() + i)) {
          slotMap.put(meeting.getStartTime() + i, true);
        }
      }
    }
    System.out.println(slotMap.entrySet().toString());
    return slotMap;
  }

  public static void main(String[] args){
    // MergingMeetingTimes.Meeting meeting = new Meeting(2, 3);
    // MergingMeetingTimes.Meeting meetingTwo = new Meeting(5, 9);
    //
    // System.out.println(meeting.getEndTime());
    // ArrayList<MergingMeetingTimes.Meeting> myList = new ArrayList<MergingMeetingTimes.Meeting>();
    // myList.add(meeting);
    // myList.add(meetingTwo);
    // System.out.println(getMap(myList));
    MergingMeetingTimes.Meeting meeting = new Meeting(0, 1);
    MergingMeetingTimes.Meeting meetingTwo = new Meeting(3, 5);
    MergingMeetingTimes.Meeting meetingThree = new Meeting(4, 8);

    ArrayList<MergingMeetingTimes.Meeting> myList = new ArrayList<MergingMeetingTimes.Meeting>();
    myList.add(meeting);
    myList.add(meetingTwo);
    myList.add(meetingThree);
    System.out.println(getMap(myList));
    System.out.println(Arrays.toString(getMap(myList).keySet().toArray()));
}
  public static class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
      // number of 30 min blocks past 9:00 am
      this.startTime = startTime;
      this.endTime   = endTime;
    }

    public int getStartTime() {
      return startTime;
    }

    public void setStartTime(int startTime) {
      this.startTime = startTime;
    }

    public int getEndTime() {
      return endTime;
    }

    public void setEndTime(int endTime) {
      this.endTime = endTime;
    }
  }
}

