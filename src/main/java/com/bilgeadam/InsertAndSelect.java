package com.bilgeadam;

import java.sql.*;

public class InsertAndSelect {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciAdi ="postgres";  //kullanıcı adı
        String sifre ="root";  //postgresql default sifresi.
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, kullaniciAdi, sifre);
//            String createSQL = "CREATE TABLE public.tablo_adi( name character varying(255), surname character varying(255));";
//            PreparedStatement createStatement = conn.prepareStatement(createSQL);
//            createStatement.executeQuery();

            //INSERT ISLEMI
            String insertSQL = "INSERT INTO public.tablo_adi(\n" +
                    "\tname,surname)\n" +
                    "\tVALUES (?, ?);";
            PreparedStatement insertStatement = conn.prepareStatement(insertSQL);
            insertStatement.setString(1,"Müco");
            insertStatement.setString(2, "Melo");
//            int affectedRows = insertStatement.executeUpdate();
//            System.out.println("INSERT islemi sonucunda etkilenen satir sayisi : " + affectedRows );

            //SELECT ISLEMI
            String selectSQL = "SELECT * FROM tablo_Adi" ;
            PreparedStatement selectStatement = conn.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                String sutun1Degeri = resultSet.getString("name");
                String sutun2Degeri = resultSet.getString("surname");
                System.out.println("Name : " + sutun1Degeri + "\nSurname : " + sutun2Degeri + "\n");

            }
            conn.close();
        }catch (SQLException e ){
            e.printStackTrace();
        }

    }
}
