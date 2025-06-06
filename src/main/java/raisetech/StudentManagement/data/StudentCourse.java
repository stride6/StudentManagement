package raisetech.StudentManagement.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "受講生コース情報")
@Getter
@Setter
public class StudentCourse {

    @NotBlank
    @Pattern(regexp = "^\\d+$")
    private Integer id;

    @NotBlank
    @Pattern(regexp = "^\\d+$")
    private Integer studentId;

    @NotBlank
    private String courseName;

    @NotBlank
    private LocalDateTime courseStartAt;

    @NotBlank
    private LocalDateTime courseEndAt;
}

