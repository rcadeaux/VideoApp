
package com.ramon.videoapp.webservices.youtube.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class YoutubeResponse {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("regionCode")
    @Expose
    private String regionCode;
    @SerializedName("pageInfo")
    @Expose
    private PageInfo pageInfo;
    @SerializedName("youtubeItems")
    @Expose
    private List<YoutubeItem> youtubeItems = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public YoutubeResponse() {
    }

    /**
     * 
     * @param regionCode
     * @param etag
     * @param items
     * @param pageInfo
     * @param nextPageToken
     * @param kind
     */
    public YoutubeResponse(String kind, String etag, String nextPageToken, String regionCode, PageInfo pageInfo, List<YoutubeItem> items) {
        super();
        this.kind = kind;
        this.etag = etag;
        this.nextPageToken = nextPageToken;
        this.regionCode = regionCode;
        this.pageInfo = pageInfo;
        this.youtubeItems = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<YoutubeItem> getYoutubeItems() {
        return youtubeItems;
    }

    public void setYoutubeItems(List<YoutubeItem> youtubeItems) {
        this.youtubeItems = youtubeItems;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("kind", kind).append("etag", etag).append("nextPageToken", nextPageToken).append("regionCode", regionCode).append("pageInfo", pageInfo).append("youtubeItems", youtubeItems).toString();
    }

}
