package demo.model;

import annotation.MyAnnotation;
import java.time.LocalDateTime;

@MyAnnotation
public class Person {

    private Integer age;

    private String name;

    private LocalDateTime createdTime;

    @MyAnnotation("qwe")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
