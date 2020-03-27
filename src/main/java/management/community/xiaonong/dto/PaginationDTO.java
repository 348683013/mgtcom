package management.community.xiaonong.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/3/27
 */
@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showNext;
    private boolean showPrevious;
    private boolean showEndPage;
    private boolean showFirstPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage = totalPage;
        this.page = page;

//        使得当前页面左右各有四个能看得见的页面
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }
    }
}

