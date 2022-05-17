package cn.gaple.extra.feature.events;

import cn.hutool.core.lang.Dict;
import cn.maple.core.framework.event.GXBaseEvent;

public class GXMediaLibraryEvent<T> extends GXBaseEvent<T> {
    public GXMediaLibraryEvent(T source, Dict param) {
        this(source, "", param, "");
    }

    public GXMediaLibraryEvent(T source, String eventName, Dict param) {
        this(source, eventName, param, "");
    }

    public GXMediaLibraryEvent(T source, String eventName, Dict param, String scene) {
        super(source, eventName, param, scene);
    }
}
