package driving.util;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class PageData<T> {
    //当前第几页
    private Integer curPage;
    //总记录数
    private Integer totalCount;
    //总页数 count
    private Integer count;
    private Integer totalPage;
    //当前页的数据
    private List<T>  data;
    //每页记录数
    private Integer pageSize;
    //状态码
    private Integer code=0;
}
