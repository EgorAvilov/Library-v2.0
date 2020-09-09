package by.itechart.library.bean;

import lombok.Getter;

public enum Role {
    ADMIN(1),
    USER(2);
    @Getter
    private int roleId;

    Role(int bookStatusId) {
        this.roleId = roleId;
    }

}
