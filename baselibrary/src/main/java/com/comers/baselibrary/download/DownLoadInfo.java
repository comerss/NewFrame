package com.comers.baselibrary.download;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by 79653 on 2018/7/25.
 * 描述：
 */
@Entity
public class DownLoadInfo {
    @Id(autoincrement = true)
    Long Id;
    public boolean isFinished;
    public String url;
    public String filePath;
    public String fileName;
    public boolean isLoading;
    public long notifyID;
    public long totoalLength;
    public long currentLength;
    @Generated(hash = 811539338)
    public DownLoadInfo(Long Id, boolean isFinished, String url, String filePath,
            String fileName, boolean isLoading, long notifyID, long totoalLength,
            long currentLength) {
        this.Id = Id;
        this.isFinished = isFinished;
        this.url = url;
        this.filePath = filePath;
        this.fileName = fileName;
        this.isLoading = isLoading;
        this.notifyID = notifyID;
        this.totoalLength = totoalLength;
        this.currentLength = currentLength;
    }
    @Generated(hash = 1743687477)
    public DownLoadInfo() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public boolean getIsFinished() {
        return this.isFinished;
    }
    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getFilePath() {
        return this.filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFileName() {
        return this.fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public boolean getIsLoading() {
        return this.isLoading;
    }
    public void setIsLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }
    public long getNotifyID() {
        return this.notifyID;
    }
    public void setNotifyID(long notifyID) {
        this.notifyID = notifyID;
    }
    public long getTotoalLength() {
        return this.totoalLength;
    }
    public void setTotoalLength(long totoalLength) {
        this.totoalLength = totoalLength;
    }
    public long getCurrentLength() {
        return this.currentLength;
    }

    @Override
    public String toString() {
        return "DownLoadInfo{" +
                "Id=" + Id +
                ", isFinished=" + isFinished +
                ", url='" + url + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", isLoading=" + isLoading +
                ", notifyID=" + notifyID +
                ", totoalLength=" + totoalLength +
                ", currentLength=" + currentLength +
                '}';
    }

    public void setCurrentLength(long currentLength) {
        this.currentLength = currentLength;
    }
}
