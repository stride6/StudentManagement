package raisetech.StudentManagement;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
//import org.apache.ibatis.annotations.Select;


@JsonAnyGetter
@JsonAnySetter

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
