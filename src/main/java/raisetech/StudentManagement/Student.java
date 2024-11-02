package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;


@Getter
@Setter
public class Student {

    private String id;
private String name;
private String kanaName;
private String nickname;
private String email;
private String age;
    private String sex;
}
