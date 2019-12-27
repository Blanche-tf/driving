package driving.util;

import lombok.Data;

import java.util.List;

@Data
public class ModulesNodeTree {
    private String  value;//绑定节点的标识值。
    private String title;//显示的节点文本标题
    private boolean checked;    //节点状态，true / false 是否选择多选框
    private boolean disabled = false; // 不能
    // 一对多
    private List<ModulesNodeTree> data;// 子节点
}