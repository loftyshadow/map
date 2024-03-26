package com.nmz.maptodo.enums;

/**
 * @Description: 待办事项状态枚举
 * @Author: 聂明智
 * @Date: 3/26/2024-7:37 PM
 */
public enum PlanStatusEnum {

    AVAILABLE(1, "待完成"),
    FINISH(2, "完成"),
    TIMEOUT(3, "超时");

    private final int planStatusCode;
    private final String planStatusName;

    PlanStatusEnum(int planStatusCode, String planStatusName) {
        this.planStatusCode = planStatusCode;
        this.planStatusName = planStatusName;
    }

    public int getPlanStatusCode() {
        return planStatusCode;
    }

    public String getPlanStatusName() {
        return planStatusName;
    }
}
