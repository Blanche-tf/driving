package driving.util;

import java.util.List;
import java.util.Map;

public class ModulesNode {
    private String  id;//绑定节点的标识值。
    private String text;//显示的节点文本标题
    private String iconCls;//显示的节点图标CSS类ID。
    private String checked;//该节点是否被选中。
    private String state;//节点状态，'open' 或 'closed'。
    private Map<String,String> attributes;//绑定该节点的自定义属性。

    // 一对多
    private List<ModulesNode> children;// 子节点

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<ModulesNode> getChildren() {
        return children;
    }

    public void setChildren(List<ModulesNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "ModulesNode{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", checked='" + checked + '\'' +
                ", state='" + state + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
