package Car;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Car {
    private Integer id;
    private String model;
    private String color;
}
