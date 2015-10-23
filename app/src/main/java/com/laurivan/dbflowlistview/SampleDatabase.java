/*
 * Copyright (c) 2015 Laur IVAN.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.laurivan.dbflowlistview;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Sample database
 * <p/>
 * Created by ivanlla on 22/10/2015.
 */
@Database(name = SampleDatabase.NAME, version = SampleDatabase.VERSION)
public class SampleDatabase {

    public static final String NAME = "Sample";

    public static final int VERSION = 1;
}
