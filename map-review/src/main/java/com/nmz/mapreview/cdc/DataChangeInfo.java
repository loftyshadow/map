package com.nmz.mapreview.cdc;

public class DataChangeInfo {
    /**
     * 变更类型： 0 初始化 1新增 2修改 3删除 4导致源中的现有表被截断的操作
     */
    private Integer operatorType;
    /**
     * 变更前数据
     */
    private String beforeData;
    /**
     * 变更后数据
     */
    private String afterData;

    /**
     * 操作的数据
     */
    private String data;
    /**
     * binlog文件名
     */
    private String fileName;
    /**
     * binlog当前读取点位
     */
    private Integer filePos;
    /**
     * 数据库名
     */
    private String database;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 变更时间
     */
    private Long operatorTime;

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getBeforeData() {
        return beforeData;
    }

    public void setBeforeData(String beforeData) {
        this.beforeData = beforeData;
    }

    public String getAfterData() {
        return afterData;
    }

    public void setAfterData(String afterData) {
        this.afterData = afterData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFilePos() {
        return filePos;
    }

    public void setFilePos(Integer filePos) {
        this.filePos = filePos;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Long operatorTime) {
        this.operatorTime = operatorTime;
    }
}