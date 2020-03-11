package com.user.app.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * 资源状态枚举
 * Created by xuzhicheng on 2018/10/18
 */
public enum ResourceStatusType {

    /**
     * 资源状态
     */
    ORDER_UNUSED(0, "未使用"),

    ORDER_BESPEAK_SUCCESSFUL(2, "已预约"),

    ORDER_CONSUMED(3, "已使用"),

    ORDER_REFUNDED(6, "已退订"),

    ORDER_CANCELED(7, "已取消"),

    ORDER_OVERTIME(8, "已过期"),

    ORDER_BESPEAK_REFUND(9, "预约后退订");
    /**
     * 状态下标
     */
    private int statusIndex;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 资源状态
     */
    ResourceStatusType(int statusIndex, String statusName) {
        this.statusIndex = statusIndex;
        this.statusName = statusName;
    }

    /**
     * 根据资源状态ID类型获取枚举对象
     *
     * @param orderStatusIndex 支付类型值
     * @return 支付类型枚举
     */
    public static ResourceStatusType typeOf(int orderStatusIndex) {
        ResourceStatusType[] resourceStatusTypes = ResourceStatusType.values();
        for (ResourceStatusType resourceStatusType : resourceStatusTypes) {
            if (resourceStatusType.getStatusIndex() == orderStatusIndex) {
                return resourceStatusType;
            }
        }
        throw new IllegalArgumentException("非法订单类型: " + orderStatusIndex);
    }

    /**
     * 枚举转Map
     *
     * @return Map
     */
    public static Map<Integer, String> convertToMap() {
        Map<Integer, String> resourceStatusTypeMap = new HashMap<Integer, String>();
        ResourceStatusType[] resourceStatusTypes = ResourceStatusType.values();
        for (ResourceStatusType resourceStatusType : resourceStatusTypes) {
            resourceStatusTypeMap.put(resourceStatusType.getStatusIndex(), resourceStatusType.getStatusName());
        }
        return resourceStatusTypeMap;
    }


    public int getStatusIndex() {
        return statusIndex;
    }

    public void setStatusIndex(int statusIndex) {
        this.statusIndex = statusIndex;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "ResourceStatusType{" +
                "statusIndex=" + statusIndex +
                ", statusName='" + statusName + '\'' +
                '}';
    }


    }
