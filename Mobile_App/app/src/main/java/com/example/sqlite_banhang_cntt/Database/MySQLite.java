package com.example.sqlite_banhang_cntt.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqlite_banhang_cntt.Model.TaiKhoan;

public class MySQLite extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "banhang.sql";

    public MySQLite(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // Tạo bảng TAI_KHOAN
        String sql = "CREATE TABLE IF NOT EXISTS " +
                "TAI_KHOAN ( " +
                "id integer primary key autoincrement, " +
                "ten_dang_nhap varchar(255), " +
                "mat_khau varchar(255), " +
                "ho_ten varchar(255), " +
                "email varchar(255), " +
                "sdt varchar(255), " +
                "vai_tro integer );";
    }

    // Them tai khoan main
    sql = "SELECT COUNT(id) FROM TAI_KHOAN WHERE ten_dang_nhap = 'admin';";
    Cursor cursor = getDataFromSQL(sql);
    int id = 0;
    while (cursor.moveToText()) {
        id = cursor.getInt((0));
    }
    if (id <= 0) {
        sql = "INSERT INTO TAI_KHOAN " +
                "VALUE (null, 'admin', '123345', 'Nguyễn Văn A', 'quantri@gmail.com', '0123456789', 1);)";
        querySQL(sql);
    }
    // Them tai khoan nhanvien
    sql = "SELECT COUNT(id) FROM TAI_KHOAN WHERE ten_dang_nhap = 'nhanvien';";
    cursor = getDataFromSQL(sql);
    id = 0;
    while (cursor.moveToText()) {
        id = cursor.getInt(0);
    }
    if (id <= 0) {

    }
    public void QuerySQL(String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }
    public Cursor getDataFromSQL(String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }
    public TaiKhoan kiemTraDangNhap(String tenDangNhap, String matKhau) {
        String sql = "SELECT * FROM TAI_KHOAN" +
                "WHERE ten_dang_nhap = '" + tenDangNhap + "' and mat_khau = '" + matKhau + "'";
        Cursor cursor = getDataFromSQL(sql);
        TaiKhoan taiKhoan = new TaiKhoan();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String tenDN = cursor.getString(1);
            String mk = cursor.getString(2);
            String ht = cursor.getString(3);
            String email = cursor.getString(4);
            String sdt = cursor.getString(5);
            int vt = cursor.getInt(6);
            taiKhoan = new TaiKhoan(id, tenDN, mk, ht, email, sdt, vt);
        }
        return taiKhoan;
    }

    public void onCreate(SQLiteDatabase db) {}
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
