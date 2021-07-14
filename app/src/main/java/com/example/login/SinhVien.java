package com.example.login;

public class SinhVien {
    private String username, password, ten_sv, khoa, lop;


    public SinhVien() {
    }

    public SinhVien(String username, String password, String ten_sv, String khoa, String lop) {
        this.username = username;
        this.password = password;
        this.ten_sv = ten_sv;
        this.khoa = khoa;
        this.lop = lop;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String Username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen_Sv() {
        return ten_sv;
    }

    public void setTen_sv(String ten_sv) {
        this.ten_sv = ten_sv;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setkhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getLop() {
        return lop;
    }

    public void setlop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "+ useName: " + username + "\n+ password: " + password + "\n+ Name: " + ten_sv + "\n+ khoa: " + khoa + "\n+ lop: " + lop;
    }

}
