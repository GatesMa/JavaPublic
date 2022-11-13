package demo.model;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * pushmail 调用report service获取基础信息
 */
@Slf4j
public enum MetricObject {
    ADV_CURRENT("账户周期内"),
    ADV_BEFORE("账户自身"),
    AGENCY_CURRENT("客户周期内"),
    AGENCY_BEFORE("客户自身"),
    AGENCY_BEFORE2("客户自身2个周期"),
    NEW_ADV("新户"),
    ONLINE_AD("在线广告周期内"),
    ONLINE_AD_BEFORE("在线广告自身"),
    NEW_AD("新增广告周期内"),
    NEW_AD_BEFORE("新增广告自身");


    private static final List<String> NEW_ADV_FIELDS = Arrays.asList("cost");
    private static final List<String> FIELDS = Arrays.asList("cost", "conversions_rate", "deep_conversions_rate",
            "view_count", "ctr", "conversions_cost", "conversions_count");
    private static final Integer DEFAULT_PAGE_SIZE = 100;

    private final String desc;

    public String getDesc() {
        return desc;
    }

    MetricObject(String desc) {
        this.desc = desc;
    }

    /**
     * 获取group by信息
     *
     * @return
     */
    private List<String> getGroupBy() {
        switch (this) {
            case ADV_CURRENT:
            case ADV_BEFORE:
                return Lists.newArrayList("uid");
            case NEW_ADV:
                // 按天查询
                return Lists.newArrayList("uid", "stats_date");
            default:
                return null;
        }
    }

}
