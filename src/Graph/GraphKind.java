package Graph;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: GraphKind
 * @类描述: 图类型
 * @创建人: 权义翔
 * @创建时间: 2020/3/18 23:04
 **/
public enum GraphKind {
    DG("有向图", "DG"),
    DN("有向网", "DN"),
    UDG("无向图", "UDG"),
    UDN("无向网", "UDN"),
    ;

    GraphKind(String info, String name) {
        this.info = info;
        this.name = name;
    }

    private String info;
    private String name;

    public String getInfo() {
        return info;
    }

    public String getName() {
        return name;
    }
}