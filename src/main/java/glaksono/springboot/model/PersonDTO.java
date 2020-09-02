package glaksono.springboot.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PersonDTO implements Serializable {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String phoneNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
