package org.test.dto;

/**
 * 班级作为一个实体  系 专业 作为属性
 * Created by apple on 2017/12/5.
 */
public class ClassDTO {
    private int classId;
    private String className;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
