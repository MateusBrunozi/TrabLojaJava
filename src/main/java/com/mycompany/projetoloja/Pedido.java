/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoloja;

/**
 *
 * @author aluno.ipora
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class Pedido {
    
    private int id;
    private Cliente cliente;
    private Produto produtos;
    private String status;
    private int quantidade;
    private int idPedProd;
    private static int count = 1;
    
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public Pedido() {
        
    }

    public Pedido(int id, Cliente cliente, Produto produtos) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = "Em processamento";
    }
    
    
    
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    
    public Produto getProdutos(){
        return this.produtos;
    }
    public void setProdutos(Produto produtos){
        this.produtos = produtos;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public int getIdPedProd(){
        return idPedProd;
    }
    public void setIdPedProd(int idPedProd){
        this.idPedProd = idPedProd;
    }
    
}


