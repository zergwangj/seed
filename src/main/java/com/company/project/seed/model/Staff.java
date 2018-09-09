package com.company.project.seed.model;

import javax.persistence.*;

public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String no;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "wechat_id")
    private String wechatId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * @return store_id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * @param storeId
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * @return wechat_id
     */
    public String getWechatId() {
        return wechatId;
    }

    /**
     * @param wechatId
     */
    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}