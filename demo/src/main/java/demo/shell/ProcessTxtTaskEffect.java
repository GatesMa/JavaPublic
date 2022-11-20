package demo.shell;

import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import demo.model.BaseIndex;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 * ProcessTxt
 *
 * @author by gatesma.
 */
public class ProcessTxtTaskEffect {


    public static void main(String[] args) throws IOException {
        String path = "/Users/gatesma/tmp/20221116/crm_task_sql_result_20221116142625.txt";

        try {
            List<String> lines = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
            for (String line : lines) {
                String[] strings = line.split("\t");
                // System.out.println(strings[1]);
                JSONObject jsonObject = JSONObject.parseObject(strings[1].replace("\\\\", "\\"));
                // System.out.println(jsonObject.get("baseMetric"));
                final Map<BaseIndex, Double> baseMetricSummary = new Gson().fromJson(
                        jsonObject.get("baseMetric").toString(),
                        new TypeToken<Map<BaseIndex, Double>>() {
                        }.getType());
                System.out.println(baseMetricSummary.get(BaseIndex.NEW_AD_COUNT) + "," + baseMetricSummary.get(
                        BaseIndex.NEW_AD_BEFORE_COUNT));
                // System.out.println("121231");
            }
        } catch (Exception e) {
            throw e;
        }


    }

}
