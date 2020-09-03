package by.itechart.library.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Reader implements Serializable {
    private static final long serialVersionUID = 4752563413543184299L;
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Date dateOfRegistration;
    private String phoneNumber;
}
