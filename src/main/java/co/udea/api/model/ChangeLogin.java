package co.udea.api.model;

public class ChangeLogin {
    private String correo;
    private String oldPassword;
    private String newPassword;

    public ChangeLogin(String correo, String oldPassword, String newPassword) {
        this.correo = correo;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}