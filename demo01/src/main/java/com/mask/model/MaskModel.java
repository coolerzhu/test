package com.mask.model;

/**
 * 口罩实体
 */
public class MaskModel {
    private  Integer id;
    private  String name;

    public MaskModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaskModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
