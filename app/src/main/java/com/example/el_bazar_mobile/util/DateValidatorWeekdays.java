package com.example.el_bazar_mobile.util;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.material.datepicker.CalendarConstraints.DateValidator;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;


/** A {@link DateValidator} that only allows dates from a given point onward to be clicked. */
public class DateValidatorWeekdays implements DateValidator {

    public DateValidatorWeekdays() {}

    private Calendar utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    public static final Creator<DateValidatorWeekdays> CREATOR =
            new Creator<DateValidatorWeekdays>() {
                @Override
                public DateValidatorWeekdays createFromParcel(Parcel source) {
                    return new DateValidatorWeekdays();
                }

                @Override
                public DateValidatorWeekdays[] newArray(int size) {
                    return new  DateValidatorWeekdays[size];
                }
            };

    @Override
    public boolean isValid(long date) {
        utc.setTimeInMillis(date);
        int dayOfWeek = utc.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DateValidatorWeekdays)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        Object[] hashedFields = {};
        return Arrays.hashCode(hashedFields);
    }
}