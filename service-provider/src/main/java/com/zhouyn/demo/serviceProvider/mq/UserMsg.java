package com.zhouyn.demo.serviceProvider.mq;

import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserMsg {

    public static final String UA_UPDATE = "update";

    public static final String UA_DELETE = "delete";

    private String action;

    private Long id;

    private String traceId;

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this)
                .add("action", this.getAction())
                .add("id", this.getId())
                .add("traceId", this.getTraceId());
    }

}
