/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laptrinhweb.healthcare.dao;

import com.laptrinhweb.healthcare.context.DBContext;
import com.laptrinhweb.healthcare.model.Comic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LuanPC
 */
public class ComicDAO {
    public ArrayList<Comic> getAllComics() throws SQLException {
        String sql = "select * from comics";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Comic> listComic = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Comic comic = new Comic();
                comic.setId(rs.getInt("ID"));
                comic.setName(rs.getString("Name"));
                comic.setImage(rs.getString("Image"));
                listComic.add(comic);
            }
        } catch (Exception e) {
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                con.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return listComic;
    }
}
