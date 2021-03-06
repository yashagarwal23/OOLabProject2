package com.example.oolabproject2.calendar;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;
import com.roomorama.caldroid.WeekdayArrayAdapter;

import java.util.Date;

public class CalendarFragment extends CaldroidFragment
{
    private Date selectedDate;

// --------------------------------------->

    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year)
    {
        return new CalendarGridAdapter(getActivity(), month, year, getCaldroidData(), extraData);
    }

    @Override
    public void setSelectedDates(Date fromDate, Date toDate)
    {
        this.selectedDate = fromDate;
        super.setSelectedDates(fromDate, toDate);
        try
        {
            super.moveToDate(fromDate);
        }
        catch (Exception ignored){} // Exception that occurs if we call this code before the calendar being initialized
    }

    public Date getSelectedDate()
    {
        return selectedDate;
    }

    public void setFirstDayOfWeek(int firstDayOfWeek)
    {
        if( firstDayOfWeek != startDayOfWeek )
        {
            startDayOfWeek = firstDayOfWeek;
            WeekdayArrayAdapter weekdaysAdapter = getNewWeekdayAdapter(getThemeResource());
            getWeekdayGridView().setAdapter(weekdaysAdapter);
            nextMonth();
            prevMonth();
        }
    }
}

