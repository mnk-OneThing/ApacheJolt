package com.mnk.Jolt;

import java.util.List;
import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
public class JoltTransformation {

    public static void main(String[] args) {
        String inputPath="src\\main\\resources\\InputJson\\test1.json";
        String specPath="src\\main\\resources\\SpecJson\\test1Spec.json";
        System.out.println(trasnformJSON(inputPath,specPath));
    }
    private static String trasnformJSON(String inputPath,String specPath) {
        List<Object> specs = JsonUtils.filepathToList(specPath);
        Chainr chainr = Chainr.fromSpec(specs);
        Object inputJSON = JsonUtils.filepathToList(inputPath);
        Object transformedOutput = chainr.transform(inputJSON);
        return JsonUtils.toPrettyJsonString(transformedOutput);
    }
}
