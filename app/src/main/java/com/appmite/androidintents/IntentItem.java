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

package com.appmite.androidintents;

import android.net.Uri;
import android.os.Bundle;

import java.util.List;

public class IntentItem {

    private String mGroup;
    private String mComponentName;
    private String mAction;
    private Uri mData;
    private String mCategory;
    private Bundle mExtrasBundle;
    private String mFlags;
    private List<String> mExtrasList;

    public IntentItem(String componentName) {
        this.mComponentName = componentName;
    }

    public IntentItem(String group, String action, Uri data, List<String> extrasList, Bundle bundle) {
        this.mAction = action;
        this.mData = data;
        this.mGroup = group;
        this.mExtrasBundle = bundle;
        this.mExtrasList = extrasList;
    }

    // getters & setters
    public String getComponentName() {
        return this.mComponentName;
    }

    public String getAction() {
        return this.mAction;
    }

    public Uri getData() {
        return this.mData;
    }

    public Bundle getExtrasBundle() {
        return this.mExtrasBundle;
    }
}
