package raisetech.StudentManagement;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students")
List<Student> search();
}
