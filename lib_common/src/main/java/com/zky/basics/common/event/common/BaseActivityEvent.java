package com.zky.basics.common.event.common;

import com.zky.basics.common.event.BaseEvent;

/**
 * Description: <BaseActivityEvent><br>
 *
 * Date:        2018/4/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class BaseActivityEvent<T> extends BaseEvent<T> {
    public BaseActivityEvent(int code) {
        super(code);
    }
}
