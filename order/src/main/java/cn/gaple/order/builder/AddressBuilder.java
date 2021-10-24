package cn.gaple.order.builder;

import cn.gaple.order.builder.dto.AddressDto;

public class AddressBuilder {
    public String getListByCondition(AddressDto dto) {
        return "select * from address";
    }
}
