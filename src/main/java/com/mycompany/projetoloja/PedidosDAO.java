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
public class PedidosDAO {
    
    public void PedidoCreate(Pedido ped){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido (idCliente, status)VALUES(?,?)");
            stmt.setInt(1, ped.getCliente().getId());
            stmt.setString(2, ped.getStatus());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void RealizarPedido(Pedido ped){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedidoprod (idPedido,idProduto, quantidade)VALUES(?,?,?)");
            stmt.setInt(1, ped.getId());
            stmt.setInt(2, ped.getProdutos().getId());
            stmt.setInt(3, ped.getQuantidade());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    
    public List<Pedido> readPed(){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pedido ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Pedido ped = new Pedido();
                
                ped.setId(rs.getInt("idPedido"));
                
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("idCliente"));
                ped.setCliente(cliente);
                ped.setStatus(rs.getString("status"));
                
                
                pedido.add(ped);
            }
        }catch (SQLException ex){
            Logger.getLogger(LojaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    public List<Pedido> readPedProd(){
        
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedido = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM pedidoprod ");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Pedido ped = new Pedido();
                
                ped.setId(rs.getInt("idPedido"));
                
                Produto produtos = new Produto();
                produtos.setId(rs.getInt("idProduto"));
                ped.setProdutos(produtos);
                ped.setQuantidade(rs.getInt("quantidade"));
                ped.setIdPedProd(rs.getInt("idPedProd"));
                
                
                pedido.add(ped);
            }
        }catch (SQLException ex){
            Logger.getLogger(LojaOnline.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexao.closeConnection(con, stmt, rs);
        }
        
        return pedido;
    }
    
    public void PedidoDelete(Pedido ped){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {
            stmt = con.prepareStatement("DELETE FROM pedido WHERE idPedido = ? ");
            stmt.setInt(1, ped.getId());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Removido com sucesso com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao remover " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    public void PedidoProdDelete(Pedido ped){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        
        try {           
            stmt = con.prepareStatement("DELETE FROM pedidoprod WHERE idPedido = ? ");
            stmt.setInt(1, ped.getId());
            
            
            stmt.executeUpdate();
            
            
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao remover " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void PedidoUpdate(Pedido ped){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pedido SET idCliente = ?,status = ? WHERE idPedido = ?");
            stmt.setInt(1,ped.getCliente().getId());
            stmt.setString(2,ped.getStatus());
            stmt.setInt(3, ped.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
    
    public void PedidoProdUpdate(Pedido ped){
    
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE pedidoprod SET idProduto = ?,quantidade = ? WHERE idPedProd = ?");
            stmt.setInt(1,ped.getProdutos().getId());
            stmt.setInt(2,ped.getQuantidade());
            stmt.setInt(3, ped.getIdPedProd());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com sucesso");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao alterar " + ex);
        }finally{
            Conexao.closeConnection(con, stmt);
        }
    }
}
