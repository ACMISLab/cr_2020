package com.simplerpa.cloudservice.utils.factory.webpage;

import com.ruoyi.common.core.utils.StringUtils;
import com.simplerpa.cloudservice.entity.TaskNodeDetail;
import com.simplerpa.cloudservice.entity.util.library.node.webpage.GetElementNode;
import com.simplerpa.cloudservice.entity.util.library.node.webpage.WebAction;

public class GetElementNodeFactory extends WebActionFactory{

    public GetElementNodeFactory(TaskNodeDetail taskNodeDetail) {
        super(taskNodeDetail);
    }

    @Override
    public WebAction getNode(TaskNodeDetail taskNodeDetail) throws Exception {
        GetElementNode node = new GetElementNode(taskNodeDetail);
        String outputParamName = getTaskNodeDetail().getParams().getString("outputParamName");
        if(StringUtils.isEmpty(outputParamName)){
            throw new Exception(this.getClass().getName() + " : 没有数据输出参数名称！解析失败！");
        }
        node.setOutputParamName(outputParamName);
        return node;
    }
}
