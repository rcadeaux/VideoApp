
package com.ramon.videoapp.webservices.youtube.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PageInfo {

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;
    @SerializedName("resultsPerPage")
    @Expose
    private Integer resultsPerPage;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PageInfo() {
    }

    /**
     * 
     * @param totalResults
     * @param resultsPerPage
     */
    public PageInfo(Integer totalResults, Integer resultsPerPage) {
        super();
        this.totalResults = totalResults;
        this.resultsPerPage = resultsPerPage;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(Integer resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("totalResults", totalResults).append("resultsPerPage", resultsPerPage).toString();
    }

}
