package demo.util;

import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
 * 标签匹配规则Util
 *
 * @author by gatesma.
 */
@Slf4j
public class CommonTagUtil {

    /**
     * 逗号分割的set，是否包含values里的数据，任意一个匹配返回true
     */
    public static boolean strSetContainsOne(String strSet, String... values) {
        if (StringUtils.isEmpty(strSet) || null == values || values.length == 0) {
            return false;
        }
        Set<String> set = Arrays.stream(strSet.split(",")).collect(Collectors.toSet());
        for (String value : values) {
            if (set.contains(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 逗号分割的set，是否包含全部values里的数据
     */
    public static boolean strSetContainsAll(String strSet, String... values) {
        if (StringUtils.isEmpty(strSet) || null == values || values.length == 0) {
            return false;
        }
        Set<String> set = Arrays.stream(strSet.split(",")).collect(Collectors.toSet());
        for (String value : values) {
            if (!set.contains(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从json字符串中读取long field
     *
     * @param json json串
     * @param field 字段名
     * @param defVal 默认值
     */
    public static Long getLongFieldFromJson(String json, String field, Long defVal) {
        if (StringUtils.isEmpty(json) || StringUtils.isEmpty(field)) {
            return defVal;
        }
        try {
            Long val = JSONObject.parseObject(json).getLong(field);
            return val == null ? defVal : val;
        } catch (Exception e) {
            return defVal;
        }
    }

    public static void main(String[] args) {
        // System.out.println(strSetContainsOne("123,21431,123653237,,135"));

        String str = "{\"first_goal_105\":1,\"first_goal_10801\":98}";
        System.out.println(getLongFieldFromJson(str, "first_goal_405", 0L));
        System.out.println(CommonTagUtil.getLongFieldFromJson(str, "first_goal_405", 0L)
                + CommonTagUtil.getLongFieldFromJson(str, "first_goal_10801", 0L));
    }


}
