public class Employee {
    private int idEmployee;
    private String nameEmployee;
    private String role;
    private String email;
    private String password;

    public Employee(){}
    public Employee(int idEmployee, String nameEmployee, String role, String email, String password){
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
