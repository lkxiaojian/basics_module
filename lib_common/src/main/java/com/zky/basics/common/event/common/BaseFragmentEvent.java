package com.zky.basics.common.event.common;
import com.zky.basics.common.event.BaseEvent;

/**
 * Description: <BaseFragmentEvent><br>
 *
 * Date:        2018/4/4<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class BaseFragmentEvent<T> extends BaseEvent<T> {
    public BaseFragmentEvent(int code) {
        super(code);
    }
}
