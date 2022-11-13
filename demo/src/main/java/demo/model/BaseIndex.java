package demo.model;

/**
 * pushmail 基本指标信息
 */
public enum BaseIndex {
    ADV_CURRENT_COST("账户周期内日均消耗", MetricObject.ADV_CURRENT, "cost"),
    ADV_BEFORE_COST("账户自身日均消耗", MetricObject.ADV_BEFORE, "cost"),
    AGENCY_CURRENT_COST("客户周期内日均消耗", MetricObject.AGENCY_CURRENT, "cost"),
    AGENCY_BEFORE_COST("客户自身日均消耗", MetricObject.AGENCY_BEFORE, "cost"),
    AGENCY_BEFORE2_COST("客户自身两个周期日均消耗", MetricObject.AGENCY_BEFORE2, "cost"),
    NEW_ADV_COST("新户日均消耗", MetricObject.NEW_ADV, "cost"),
    ADV_CURRENT_CONVERSIONS_COUNT("账户周期内目标转化量", MetricObject.ADV_CURRENT, "conversions_count"),
    ADV_BEFORE_CONVERSIONS_COUNT("账户自身目标转化量", MetricObject.ADV_BEFORE, "conversions_count"),
    ADV_CURRENT_CONVERSIONS_COST("账户周期内目标转化成本", MetricObject.ADV_CURRENT, "conversions_cost"),
    ADV_BEFORE_CONVERSIONS_COST("账户自身目标转化成本", MetricObject.ADV_BEFORE, "conversions_cost"),
    AGENCY_CURRENT_CONVERSIONS_COST("客户周期内目标转化成本", MetricObject.AGENCY_CURRENT, "conversions_cost"),
    AGENCY_BEFORE_CONVERSIONS_COST("客户自身目标转化成本", MetricObject.AGENCY_BEFORE, "conversions_cost"),
    AGENCY_BEFORE2_CONVERSIONS_COST("客户自身两个周期目标转化成本", MetricObject.AGENCY_BEFORE2, "conversions_cost"),
    NEW_ADV_CONVERSIONS_COST("新户目标转化成本", MetricObject.NEW_ADV, "conversions_cost"),
    ADV_CURRENT_CONVERSIONS_RATE("账户周期内目标转化率", MetricObject.ADV_CURRENT, "conversions_rate"),
    ADV_BEFORE_CONVERSIONS_RATE("账户自身目标转化率", MetricObject.ADV_BEFORE, "conversions_rate"),
    AGENCY_CURRENT_CONVERSIONS_RATE("客户周期内目标转化率", MetricObject.AGENCY_CURRENT, "conversions_rate"),
    AGENCY_BEFORE_CONVERSIONS_RATE("客户自身目标转化率", MetricObject.AGENCY_BEFORE, "conversions_rate"),
    AGENCY_BEFORE2_CONVERSIONS_RATE("客户自身两个周期目标转化率", MetricObject.AGENCY_BEFORE2, "conversions_rate"),
    NEW_ADV_CONVERSIONS_RATE("新户目标转化率", MetricObject.NEW_ADV, "conversions_rate"),
    ADV_CURRENT_DEEP_CONVERSIONS_RATE("账户周期内深度目标转化率", MetricObject.ADV_CURRENT, "deep_conversions_rate"),
    ADV_BEFORE_DEEP_CONVERSIONS_RATE("账户自身深度目标转化率", MetricObject.ADV_BEFORE, "deep_conversions_rate"),
    AGENCY_CURRENT_DEEP_CONVERSIONS_RATE("客户周期内深度目标转化率", MetricObject.AGENCY_CURRENT, "deep_conversions_rate"),
    AGENCY_BEFORE_DEEP_CONVERSIONS_RATE("客户自身深度目标转化率", MetricObject.AGENCY_BEFORE, "deep_conversions_rate"),
    AGENCY_BEFORE2_DEEP_CONVERSIONS_RATE("客户自身两个周期深度目标转化率", MetricObject.AGENCY_BEFORE2, "deep_conversions_rate"),
    NEW_ADV_DEEP_CONVERSIONS_RATE("新户深度目标转化率", MetricObject.NEW_ADV, "deep_conversions_rate"),
    ADV_CURRENT_CPM("账户周期内CPM", MetricObject.ADV_CURRENT, "CPM"),
    ADV_BEFORE_CPM("账户自身CPM", MetricObject.ADV_BEFORE, "CPM"),
    AGENCY_CURRENT_CPM("客户周期内CPM", MetricObject.AGENCY_CURRENT, "CPM"),
    AGENCY_BEFORE_CPM("客户自身CPM", MetricObject.AGENCY_BEFORE, "CPM"),
    AGENCY_BEFORE2_CPM("客户自身两个周期CPM", MetricObject.AGENCY_BEFORE2, "CPM"),
    NEW_ADV_CPM("新户深度CPM", MetricObject.NEW_ADV, "CPM"),
    ADV_CURRENT_CLICK("账户周期内点击量", MetricObject.ADV_CURRENT, "click"),
    ADV_BEFORE_CLICK("账户自身点击量", MetricObject.ADV_BEFORE, "click"),
    ADV_CURRENT_CTR("账户周期内点击率", MetricObject.ADV_CURRENT, "ctr"),
    ADV_BEFORE_CTR("账户自身点击率", MetricObject.ADV_BEFORE, "ctr"),
    AGENCY_CURRENT_CTR("客户周期内点击率", MetricObject.AGENCY_CURRENT, "ctr"),
    AGENCY_BEFORE_CTR("客户自身点击率", MetricObject.AGENCY_BEFORE, "ctr"),
    AGENCY_BEFORE2_CTR("客户自身两个周期点击率", MetricObject.AGENCY_BEFORE2, "ctr"),
    NEW_ADV_CTR("新户点击率", MetricObject.NEW_ADV, "ctr"),
    ONLINE_AD_COUNT("在线广告周期内总数", MetricObject.ONLINE_AD, "ad_count"),
    ONLINE_AD_BEFORE_COUNT("在线广告自身总数", MetricObject.ONLINE_AD_BEFORE, "ad_count"),
    ONLINE_AD_COST("在线广告周期内总消耗", MetricObject.ONLINE_AD, "ad_cost_sum"),
    ONLINE_AD_BEFORE_COST("在线广告自身总消耗", MetricObject.ONLINE_AD_BEFORE, "ad_cost_sum"),
    ONLINE_AD_ARPU("在线广告周期内arpu", MetricObject.ONLINE_AD, "ad_cost"),
    ONLINE_AD_BEFORE_ARPU("在线广告自身arpu", MetricObject.ONLINE_AD_BEFORE, "ad_cost"),
    NEW_AD_COUNT("新增广告周期内总数", MetricObject.NEW_AD, "ad_count"),
    NEW_AD_BEFORE_COUNT("新增广告自身总数", MetricObject.NEW_AD_BEFORE, "ad_count"),
    NEW_AD_COST("新增广告周期内总消耗", MetricObject.NEW_AD, "ad_cost_sum"),
    NEW_AD_BEFORE_COST("新增广告自身总消耗", MetricObject.NEW_AD_BEFORE, "ad_cost_sum"),
    NEW_AD_ARPU("新增广告周期内arpu", MetricObject.NEW_AD, "ad_cost"),
    NEW_AD_BEFORE_ARPU("新增广告自身arpu", MetricObject.NEW_AD_BEFORE, "ad_cost"),

    ADV_CURRENT_COST_DONE_RATE("账户广告任务期成本偏差", MetricObject.ADV_CURRENT, "ad_cost_done_rate"),
    ADV_BEFORE_COST_DONE_RATE("账户广告前周期成本偏差", MetricObject.ADV_BEFORE, "ad_cost_done_rate"),
    ADV_CURRENT_GMV("账户广告任务期GMV", MetricObject.ADV_CURRENT, "gmv"),
    ADV_BEFORE_GMV("账户广告前周期GMV", MetricObject.ADV_BEFORE, "gmv"),


    ADV_CURRENT_EXPOSURE_COUNT("账户周期内曝光", MetricObject.ADV_CURRENT, "exposure_count"),
    ADV_BEFORE_EXPOSURE_COUNT("账户自身曝光", MetricObject.ADV_BEFORE, "exposure_count");

    private final String desc;
    private final MetricObject metricObject;
    private final String target;

    BaseIndex(String desc, MetricObject object, String target) {
        this.metricObject = object;
        this.desc = desc;
        this.target = target;
    }

    public String getDesc() {
        return desc;
    }

    public MetricObject getMetricObject() {
        return metricObject;
    }

    public String getTarget() {
        return target;
    }

}
