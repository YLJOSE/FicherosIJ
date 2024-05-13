package EntornosDeDesarrollo;

public class Administrador {
    private String user;
    private long password;

    public Administrador(String user, long password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
