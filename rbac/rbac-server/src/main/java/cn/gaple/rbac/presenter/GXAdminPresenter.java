package cn.gaple.rbac.presenter;

import cn.maple.core.framework.ddd.presenter.GXBasePresenter;
import org.springframework.stereotype.Component;

@Component
public class GXAdminPresenter implements GXBasePresenter {
    public String fullName() {
        return "Hello World!!!";
    }
}
