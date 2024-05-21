package com.ajs.listeners;

import com.ajs.utils.ReadExcelFileUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {

        ArrayList<Map<String, String>> list = ReadExcelFileUtils.getExcelDataAndReturnList();

        ArrayList<IMethodInstance> result = new ArrayList<>();

        for (int i = 0; i <= methods.size()-1; i++) {
            for (int j = 0; j <= list.size()-1; j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))) {
                    if (list.get(j).get("execute").equalsIgnoreCase("yes")) {
                        methods.get(i).getMethod().setDescription(list.get(j).get("description"));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));

                        result.add(methods.get(i));
                    }

                }
            }
        }

        return result;

    }
}
