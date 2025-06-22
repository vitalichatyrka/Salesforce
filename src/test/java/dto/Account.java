package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Account {

    private String name;
    private String phone;
    private String fax;
    private String rating;
}
