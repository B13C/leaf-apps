package cn.gaple.extension;

import cn.maple.core.framework.util.GXLoggerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@GXExtension(bizId = "B")
@Component
@Slf4j
public class SomeExtensionB implements SomeExtPoint {
    @Override
    public void doSomeThing() {
        GXLoggerUtils.logInfo(log, "SomeExtensionB::doSomething");
    }
}
