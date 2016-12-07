package jj8.firebase_test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Chetan on 11/29/2016.
 *
 * This file creates the data base for the calendar events
 *
 * the events can be accessed through the getEvents and getEvent
 */

public class CalendarEventDate_Db {
    private static CalendarEventDate_Db sCalEventDateDb;
    private List<CalendarEventsDateTableParm> mCalendarEventsDateTableParms;

    // create a singleton so that only one can instantiate this model
    public static CalendarEventDate_Db get() {
        if(sCalEventDateDb == null)
        {
            sCalEventDateDb = new CalendarEventDate_Db();
        }
        return sCalEventDateDb;
    }

    // private constructor
    // creat a database of all events in the calendar\
    // upload the database with the realtime information
    private CalendarEventDate_Db () {
        mCalendarEventsDateTableParms = new ArrayList<CalendarEventsDateTableParm>();
        // get size of the database
        // get the day
        // get the date
        // get the description

        Event_DataBase eDb = new Event_DataBase();
        for(int i = 0; i < eDb.getDatabaseTotalCnt(); i++)
        {
            CalendarEventsDateTableParm mEvent = new CalendarEventsDateTableParm();
            mEvent.setEventDetails(eDb.getDescription(i));
            mEvent.setDay(eDb.getDay(i));
            mEvent.setDate(eDb.getDate(i));
            mCalendarEventsDateTableParms.add(mEvent);
        }
    }

    // return the total list of events
    public List<CalendarEventsDateTableParm> getCalendarEvents(){
        return mCalendarEventsDateTableParms;
    }

    // return a specific date, day and its event
    public CalendarEventsDateTableParm getCalendarEvent(Date Day) {
        for(int cnt = 0; cnt < mCalendarEventsDateTableParms.size(); cnt++)
        {
            CalendarEventsDateTableParm mEvent = mCalendarEventsDateTableParms.get(cnt);
            if(mEvent.getDate().equals(Day))
                return mEvent;
        }
        return null;    // entry not found in the list
    }
}
