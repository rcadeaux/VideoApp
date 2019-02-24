package com.ramon.videoapp;

public class Session {
    private int pageNumber=1;
    private boolean loadingMoreData;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setLoadingMoreData(boolean loadingMoreData) {
        this.loadingMoreData = loadingMoreData;
    }

    public boolean getLoadingMoreData() {
        return loadingMoreData;
    }

    public void incrementPageNumber() {
        pageNumber++;
    }
}
