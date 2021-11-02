package cn.gaple.extension;

import cn.gaple.Application;
import cn.gaple.extension.register.GXExtensionRegister;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ExtensionRegisterTest {
    @Resource
    private GXExtensionRegister extensionRegister;

    @Resource
    private GXExtensionExecutor extensionExecutor;

    @Test
    public void test() {
        extensionExecutor.executeVoid(SomeExtPoint.class, GXBizScenario.valueOf("A"), SomeExtPoint::doSomeThing);
        extensionExecutor.executeVoid(SomeExtPoint.class, GXBizScenario.valueOf("B"), SomeExtPoint::doSomeThing);
    }
}
