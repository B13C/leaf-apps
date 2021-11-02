package cn.gaple.extension;

import cn.maple.core.framework.util.GXCommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@GXExtension(bizId = "A")
@Component
@Slf4j
public class SomeExtensionA implements SomeExtPoint {
    @Override
    public void doSomeThing() {
        GXCommonUtils.logInfo(log, "SomeExtensionA::doSomething", null);
    }
}
