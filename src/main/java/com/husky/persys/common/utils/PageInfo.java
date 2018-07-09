package com.husky.persys.common.utils;

public class PageInfo {
    private int currentPage;
    private int size;
    private int totalPage;
    private int totalResult;
    private int start;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        if(size!=0&&totalResult!=0){
            totalPage = totalResult / size + 1;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {

        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
        if(size!=0&&totalResult!=0){
            totalPage = totalResult / size + 1;
            this.start = (this.currentPage-1)*this.size;
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "currentPage=" + currentPage +
                ", size=" + size +
                ", totalPage=" + totalPage +
                ", totalResult=" + totalResult +
                ", start=" + start +
                '}';
    }
}
