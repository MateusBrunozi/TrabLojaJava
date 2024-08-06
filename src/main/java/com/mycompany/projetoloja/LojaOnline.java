/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoloja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mateus
 */
public class LojaOnline {
    
    public void ClienteSave(Cliente c){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome,email,endereco)VALUES(?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEmail());
            stmt.setString(3,c.getEndereco());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    
    public void ProdutoSave(Produto p){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produtos (nome,preco,descricao)VALUES(?,?,?)");
            stmt.setString(1,p.getNome());
            stmt.setDouble(2,p.getPreco());
            stmt.setString(3,p.getDescricao());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public List<Cliente> read(){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                
                clientes.add(cliente);
            }
        }catch (SQLException ex){
            Logger.getLogger(LojaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    public List<Produto> readProd(){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));
                
                produtos.add(produto);
            }
        }catch (SQLException ex){
            Logger.getLogger(LojaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
        
    }
    public List<Produto> readProdForDesc(String nomeprod){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos WHERE nome LIKE ?");
            stmt.setString(1, "%"+nomeprod+"%");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setDescricao(rs.getString("descricao"));
                
                produtos.add(produto);
            }
        }catch (SQLException ex){
            Logger.getLogger(LojaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return produtos;
        
    }
    
        public void ClienteUpdate(Cliente c){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ? ,email = ?,endereco = ? WHERE id = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEmail());
            stmt.setString(3,c.getEndereco());
            stmt.setInt(4, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
        
        public void ProdutoUpdate(Produto p){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE produtos SET nome = ?,preco = ?,descricao = ? WHERE id = ?");
            stmt.setString(1,p.getNome());
            stmt.setDouble(2,p.getPreco());
            stmt.setString(3,p.getDescricao());
            stmt.setInt(4, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
        
        public void ProdutoDelete(Produto p){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM produtos WHERE id = ? ");
            stmt.setInt(1, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Removido com sucesso com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao remover " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
        
        public void ClienteDelete(Cliente c){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Removido com sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao remover " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
        
}
