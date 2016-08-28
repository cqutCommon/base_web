package com.cqut.helper;

/**
 * ClassName
 *
 * @author qiaowei.wu
 * @version 1.0 2015/12/9 18:02
 */
public class Page {

    private int offset;

    private Integer pageSize = 10;

    private int totalCount;

    private Integer pageNum = 1;

    private int totalPage;

    public Page() {
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        calculate();
    }

    public void calculate() {
        offset = (pageNum - 1) * pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        calculate();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.totalPage = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize != 0) {
            this.totalPage++;
        }
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        calculate();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
