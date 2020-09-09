package by.itechart.library.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4752563413543184299L;

    private int id;
    private String firstName;//
    private String lastName;//
    private int genderId;//?
    private String email;//
    private Date dateOfRegistration;
    private String phoneNumber;//
    private String username;//
    private String password;//
    private Role role;
    private boolean deletedStatus;
}
