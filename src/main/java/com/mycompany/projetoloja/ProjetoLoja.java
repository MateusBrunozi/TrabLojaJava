/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 *

package com.mycompany.projetoloja;

/**
 *
 * @author aluno.ipora
 *

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ProjetoLoja {

    static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        int opcprod;
        int opccli;
        int opcped;
        LojaOnline loja = new LojaOnline();

        do{
            System.out.println("Digite o menu que deseja acessar");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Pedidos");
            System.out.println("0 - Sair");
            opcao = sc1.nextInt();
            

            switch (opcao){
                case 1:
                    System.out.println("1 - Cadastrar Produto");
                    System.out.println("2 - Consultar Produtos");
                    System.out.println("3 - Remover Produto");
                    System.out.println("4 - Editar Produto");
                    System.out.println("0 - Voltar");
                    opcprod = sc1.nextInt();
                    switch (opcprod){
                        case 1:
                            System.out.println("Cadastro de produto");
                            Produto prod = new Produto();

                            System.out.println(("Insira o nome do produto:"));
                            prod.setNome(sc1.next());

                            System.out.println("Insira o preco do produto:");
                            prod.setPreco(sc1.nextDouble());

                            System.out.println("Insira a descricao do produto:");
                            prod.setDescricao(sc1.next());

                            loja.adicionarProduto(prod);
                    
                        break;


                        case 2:
                            
                            Produto prodconsulta = new Produto();
                                                        
                            System.out.println("Consulta de Produtos:");
                            
                            List<Produto> produtos = loja.listarProdutos();
                            
                            if(produtos.isEmpty()){
                                System.out.println("Lista de produtos cadastrados vazia");
                            }else{
                                for (Produto produto : produtos) {
                                    System.out.println("Id:" + produto.getId() + " - Nome:" + produto.getNome());
                                }
                                     
                            
                                System.out.println("Digite o ID do produto para mais informacoes");
                                prodconsulta.setId(sc1.nextInt());
                                for(Produto produto : loja.listarProdutos()){
                                    if(produto.getId() == prodconsulta.getId()){
                                        System.out.println("Id: " + produto.getId() + " - Nome: " + produto.getNome() + " - Preco: " + produto.getPreco() + " - Descricao do produto: " + produto.getDescricao());
                                    }
                                }
                            }
                            
                        break;
                        
                            
                        case 3:
                            
                            System.out.println("Remover produto");                                                    
                            
                            for (Produto produto : loja.listarProdutos()) {
                                    System.out.println("Id: " + produto.getId() + " - Nome: " + produto.getNome());
                                }
                            
                            System.out.println("Insira o nome do produto que deseja remover");
                            loja.removerProduto(loja.buscarProduto(sc1.next()));
                            
                            break;
                            
                        case 4:
                                List<Produto> produtosedit = loja.listarProdutos();
                            
                                for (Produto produto : produtosedit) {
                                    System.out.println("Id: " + produto.getId() + " - Nome: " + produto.getNome());
                                }
                            do{
                                System.out.println("Digite o ID do produto que deseja editar:");
                                int idProdEditar = sc1.nextInt();
                                Produto prodEditar = null;
                                
                                

                                for (Produto produto : loja.listarProdutos()) {
                                    if (produto.getId() == idProdEditar) {
                                        prodEditar = produto;
                                        break;  
                                    }
                                }
                                    System.out.println("Escolha oque deseja editar");
                                    System.out.println("1: Nome");
                                    System.out.println("2: Preco");


                                    switch(sc1.nextInt()){                                     
                                        case 1:
                                            System.out.println("Digite o novo Nome");
                                            prodEditar.setNome(sc1.next());
                                            break;
                                        case 2:
                                            System.out.println("Digite o novo preço:");
                                            prodEditar.setPreco(sc1.nextDouble());
                                            break;
                                    }
                                       System.out.println("Desejar editar mais alguma coisa? 1=sim 2=nao");

                           }while(sc1.nextInt() == 1);
                    }break;
                case 2:
                    
                    System.out.println("1 - Cadastrar Cliente");
                    System.out.println("2 - Consultar Clientes");
                    System.out.println("3 - Remover Cliente");
                    System.out.println("4 - Editar Cliente");
                    System.out.println("0 - Voltar");
                    opccli = sc1.nextInt();
                    switch (opccli){
                        case 1:
                            System.out.println("Cadastro de clientes");
                            Cliente cli = new Cliente();

                            System.out.println("Insira o id do cliente:");                            
                            cli.setId(sc1.nextInt());

                            System.out.println("Insira o nome do cliente:");
                            cli.setNome(sc1.next());

                            System.out.println("Insira o email do cliente:");
                            cli.setEmail(sc1.next());

                            System.out.println("Insira o endereco do cliente:");
                            cli.setEmail(sc1.next());

                            loja.adicionarCliente(cli);
                        break;
                        
                        case 2:
                            
                            System.out.println("Consulta de Clientes:");
                            
                            List<Cliente> clientes = loja.listarClientes();
                            
                            if(clientes.isEmpty()){
                                System.out.println("Lista de clientes cadastrados vazia");
                            }else{
                                for (Cliente cliente : clientes) {
                                    System.out.println(cliente.getNome() + " - " + cliente.getEmail());
                                }
                            }
                            
                        break;
                        
                        case 3:
                            
                            System.out.println("Remover Cliente");
                            
                            List<Cliente> clientesremove = loja.listarClientes();
                            
                            for (Cliente cliente : clientesremove) {
                                System.out.println("id: "+ cliente.getId() + " - nome:" + cliente.getNome() + " - email: " + cliente.getEmail());
                            }
                            
                            System.out.println("Insira o id do cliente que deseja remover");
                            loja.removerCliente(loja.buscarClientePorId(sc1.nextInt()));
                            }
                    break;
                            
                        case 4:
                            
                            System.out.println("Editar Cliente");
                            
                            List<Cliente> clientesedit = loja.listarClientes();
                            
                            for (Cliente cliente : clientesedit) {
                                System.out.println("id: "+ cliente.getId() + " - nome:" + cliente.getNome() + " - email: " + cliente.getEmail());
                            }
                        do{
                            System.out.println("Digite o ID do Cliente que deseja editar:");
                            int idCliEditar = sc1.nextInt();
                            Cliente cliEditar = null;

                            for (Cliente cliente : loja.listarClientes()) {
                                if (cliente.getId() == idCliEditar) {
                                    cliEditar = cliente;
                                    break;  
                                }
                            }
                                System.out.println("Escolha oque deseja editar");
                                System.out.println("1: Id");
                                System.out.println("2: Nome");
                                System.out.println("3: Endereco");
                                System.out.println("4: Email");


                                switch(sc1.nextInt()){
                                    case 1:
                                        System.out.println("Digite o novo Id");
                                        cliEditar.setId(sc1.nextInt());
                                        break;

                                    case 2:
                                        System.out.println("Digite o novo Nome");
                                        cliEditar.setNome(sc1.next());
                                        break;
                                    case 3:
                                        System.out.println("Digite o novo endereço:");
                                        cliEditar.setEndereco(sc1.next());
                                        break;
                                    case 4:
                                        System.out.println("Digite o novo email:");
                                        cliEditar.setEmail(sc1.next());
                                        break;
                                }
                                    System.out.println("Desejar editar mais alguma coisa? 1=sim 2=nao");

                           }while(sc1.nextInt() == 1);
                    

                    
                case 3:
                    System.out.println("1 - Realizar Pedido");
                    System.out.println("2 - Consultar Pedidos");
                    System.out.println("3 - Editar Pedido");
                    System.out.println("4 - Excluir Pedido");
                    System.out.println("0 - Voltar");
                    opcped = sc1.nextInt();
                    switch(opcped){
                        case 1:
                            Pedido novoPed = new Pedido();
                            
                            System.out.println("Digite o id do pedido");
                            novoPed.setId(sc1.nextInt());
                            
                            System.out.println("Digite o id do cliente");
                            int idClientePedido = sc1.nextInt();
                            Cliente clientePedido = null;
                            for(Cliente cliente : loja.listarClientes()){
                                if(cliente.getId() == idClientePedido){
                                    clientePedido = cliente;
                                }
                            }
                            novoPed.setCliente(clientePedido);
                            
                            List<Produto> produtosPedido = new ArrayList<>();
                            
                            int opcionador;
                            
                            do{
                                System.out.println("Insira o Id do produto");
                                int idProdPed = sc1.nextInt();
                                Produto prodPedido = null;
                                for(Produto produto : loja.listarProdutos()){
                                if(produto.getId() == idProdPed){
                                    prodPedido = produto;
                                    break;
                                }
                                
                            }
                                if (prodPedido != null) {
                                    produtosPedido.add(prodPedido);
                                } else {
                                    System.out.println("Produto não encontrado. Verifique o ID digitado.");
                                }
                                
                            
                                System.out.println("Deseja adicionar mais produtos? 1 = sim/2 = nao");
                                opcionador = sc1.nextInt();
                                
                            }while (opcionador != 2);
                             novoPed.setProdutos(produtosPedido);
                             loja.adicionarPedido(novoPed);
                        break;
                             
                        case 2:
                             System.out.println("Lista de Pedidos:");
                         
                                for (Pedido pedido : loja.listarPedidos()) {
                                    System.out.println("ID do Pedido: " + pedido.getId());
                                    System.out.println("Cliente: " + pedido.getCliente().getNome());
                                    System.out.println("Produtos:");
                                    
                                    for (Produto item : pedido.getProdutos()) {
                                        System.out.println("  - Nome: " + item.getNome());
                                    }
                                }break;
                        
                        case 3:
                        List<Pedido> pedidoEdit = loja.listarPedidos();
                            
                            for (Pedido pedido : pedidoEdit) {
                                System.out.println("id: "+ pedido.getId());
                            }
                        do{
                            System.out.println("Digite o ID do pedido que deseja editar:");
                            int idPedEditar = sc1.nextInt();
                            Pedido pedEditar = null;

                            for (Pedido pedido : loja.listarPedidos()) {
                                if (pedido.getId() == idPedEditar) {
                                    pedEditar = pedido;
                                    break;  
                                }
                            }
                                System.out.println("Escolha oque deseja editar");
                                System.out.println("1: Id");
                                System.out.println("2: Cliente");
                                System.out.println("3: Produtos");


                                switch(sc1.nextInt()){
                                    case 1:
                                        System.out.println("Digite o novo Id do pedido");
                                        pedEditar.setId(sc1.nextInt());
                                        break;

                                    case 2:
                                        System.out.println("Digite o novo Id do cliente");
                                        
                                        int novoIdCliente = sc1.nextInt();
                                        Cliente novoCliente = null;
                                        for (Cliente cliente : loja.listarClientes()) {
                                            if (cliente.getId() == novoIdCliente) {
                                                novoCliente = cliente;
                                                break;
                                            }
                                        }
                                        pedEditar.setCliente(novoCliente);
                                        break;
                                    
                                    case 3:
                                        System.out.println("Digite o Id do produto que deseja editar");
                                        for (Pedido pedido : loja.listarPedidos()) {
                                            for (Produto item : pedido.getProdutos()) {
                                                System.out.println("  - Id: " + item.getId());
                                            }
                                        }
                                        
                                        int idProdPedEdit = sc1.nextInt();
                                        Produto pedProdEditar = null;
                                        
                                        if(idProdPedEdit == pedProdEditar.getId()){
                                            System.out.println("O que gostaria de editar:");
                                            System.out.println("1 - Adicionar novo produto ao pedido");
                                            System.out.println("2 - Remover produto do pedido");
                                            System.out.println("3 - Alterar produto do pedido");
                                            
                                            switch(sc1.nextInt()){
                                                case 1:
                                                   List<Produto> produtosPedidoEditar = new ArrayList<>();
                                                    System.out.println("Insira o Id do produto que deseja adicionar");
                                                    int idProdPed = sc1.nextInt();
                                                    Produto prodPedido = null;
                                                    for(Produto produto : loja.listarProdutos()){
                                                        if(produto.getId() == idProdPed){
                                                            prodPedido = produto;
                                                            break;
                                                        }

                                                    }
                                                    if (prodPedido != null) {
                                                        produtosPedidoEditar.add(prodPedido);
                                                    } else {
                                                        System.out.println("Produto não encontrado. Verifique o ID digitado.");
                                                    }
                                                    break;
                                                case 2:
                                                   /* loja.removerProdutoPedido(loja.buscarProdutoPorId(idProdPedEdit));
                                                    System.out.println("produto removido");
                                                break;
                                                case 3:
                                                    System.out.println("Digite o novo id do produto");
                                            }
                                                
                                        }else{
                                            System.out.println("este produto nao consta no pedido");
                                        }

                                                    }
                                    System.out.println("Desejar editar mais alguma coisa? 1=sim 2=nao");

                           }while(sc1.nextInt() == 1);
                        break;
                        
                        case 4:
                            
                            System.out.println("Remover Pedido");
                            
                            List<Pedido> pedidosremove = loja.listarPedidos();
                            
                            for (Pedido pedido : pedidosremove) {
                                System.out.println("id: "+ pedido.getId());
                            }
                            
                            System.out.println("Insira o id do pedido que deseja remover");
                            loja.removerPedido(loja.buscarPedidoPorId(sc1.nextInt()));
                            }
                        break;
                        }
                    
            
            
           } while (opcao != 0);
    }
}*/
