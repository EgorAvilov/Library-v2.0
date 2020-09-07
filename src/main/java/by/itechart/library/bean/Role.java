package by.itechart.library.bean;

public enum Role {
    ADMIN(1),
    USER(2);

    private int roleId;

    Role(int bookStatusId){
        this.roleId = roleId;
    }

    public int getRoleId(){
        return roleId;
    }
}
