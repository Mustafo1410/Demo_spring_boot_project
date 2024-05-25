package User;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class User {
    private Integer id;
    private String name;
    private Integer age;
}
