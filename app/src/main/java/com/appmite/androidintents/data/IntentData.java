/*
 * Copyright (C) 2015 Fungi Solutions
 *
 *     http://www.fungisolutions.com
 *     http://www.appmite.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.appmite.androidintents.data;

import android.os.Bundle;
import android.provider.AlarmClock;

import com.appmite.androidintents.IntentItem;
import com.appmite.androidintents.constants.IntentGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create all of the possible intent items to use in our
 */
public class IntentData {

    private  List<IntentItem> mIntentItems = new ArrayList<IntentItem>();

    public IntentData() {

        // Alarm Clock Group
        addAlarmSet();
        addTimerSet();
        addShowAlarms();
    }

    public List<IntentItem> getIntentData() {
        return mIntentItems;
    }

    private void addAlarmSet() {
        List<String> extras = Arrays.asList(
                AlarmClock.EXTRA_HOUR,
                AlarmClock.EXTRA_MINUTES,
                AlarmClock.EXTRA_MESSAGE,
                AlarmClock.EXTRA_DAYS,
                AlarmClock.EXTRA_RINGTONE,
                AlarmClock.EXTRA_VIBRATE,
                AlarmClock.EXTRA_SKIP_UI
                //AlarmClock.EXTRA_ALARM_SEARCH_MODE,
                //AlarmClock.EXTRA_ALARM_SNOOZE_DURATION,
                //AlarmClock.EXTRA_IS_PM,
                //AlarmClock.EXTRA_LENGTH
        );

        Bundle bundle = new Bundle();
        bundle.putString(AlarmClock.EXTRA_MESSAGE, "This is a test alarm");
        bundle.putInt(AlarmClock.EXTRA_HOUR, 11);
        bundle.putInt(AlarmClock.EXTRA_MINUTES, 35);

        IntentItem item = new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SET_ALARM, null, extras, bundle);
        mIntentItems.add(item);
    }

    private void addTimerSet() {
        List<String> extras = Arrays.asList(
                AlarmClock.EXTRA_MESSAGE,
                AlarmClock.EXTRA_SKIP_UI,
                AlarmClock.EXTRA_LENGTH
        );

        Bundle bundle = new Bundle();
        bundle.putString(AlarmClock.EXTRA_MESSAGE, "This is a test timer");
        bundle.putInt(AlarmClock.EXTRA_LENGTH, 5);
        bundle.putBoolean(AlarmClock.EXTRA_SKIP_UI, false);

        IntentItem item = new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SET_TIMER, null, extras, bundle);
        mIntentItems.add(item);
    }

    private void addShowAlarms() {
        Bundle bundle = new Bundle();
        IntentItem item = new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SHOW_ALARMS, null, null, bundle);
        mIntentItems.add(item);
    }


//    // this is data fro recycler view
//    IntentItem itemsData[] = {
//            new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SET_ALARM, null, null),
//            new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SET_TIMER, null, null),
//            new IntentItem(IntentGroups.ALARM_CLOCK, AlarmClock.ACTION_SHOW_ALARMS, null, null),
//            new IntentItem(IntentGroups.CALENDAR, Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI),
//    };

}
